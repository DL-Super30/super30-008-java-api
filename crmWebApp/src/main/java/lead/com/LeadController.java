package lead.com;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

    @Autowired
    private LeadService leadService;

    // Get all leads
    @Operation(summary = "Retrieve all leads")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Leads retrieved successfully"),
        @ApiResponse(responseCode = "204", description = "No leads found")
    })
    @GetMapping
    public ResponseEntity<List<LeadEntity>> getAllLeads() {
        List<LeadEntity> leads = leadService.getTodaysLeads();
        if (leads.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(leads);
    }

    // Get lead by ID
    @Operation(summary = "Retrieve a lead by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lead retrieved successfully"),
        @ApiResponse(responseCode = "404", description = "Lead not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<LeadEntity> getLeadById(@PathVariable long id) {
        return leadService.getLeadById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Create a new lead with email validation
    @Operation(summary = "Create a new lead")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Lead created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request"),
        @ApiResponse(responseCode = "409", description = "Email already exists in lead")
    })
    @PostMapping
    public ResponseEntity<LeadEntity> createLead(@RequestBody LeadEntity leadEntity) {
        try {
            LeadEntity createdLead = leadService.createLead(leadEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdLead);
        } catch (EmailAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    // Update an existing lead
    @Operation(summary = "Update an existing lead")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lead updated successfully"),
        @ApiResponse(responseCode = "404", description = "Lead not found"),
        @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @PutMapping("/{id}")
    public ResponseEntity<LeadEntity> updateLead(@PathVariable Long id, @RequestBody LeadEntity leadEntity) {
        LeadEntity updatedLead = leadService.updateLead(id, leadEntity);
        return ResponseEntity.ok(updatedLead);
    }

    // Delete a lead
    @Operation(summary = "Delete a lead by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Lead deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Lead not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLead(@PathVariable long id) {
        if (leadService.getLeadById(id).isPresent()) {
            leadService.deleteLead(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
