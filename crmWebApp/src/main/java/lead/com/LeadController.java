package lead.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/api/lead")
public class LeadController {

    @Autowired
    private LeadService leadService;

    // Create a new lead
    @Operation(summary = "Create a new lead")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "lead created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @PostMapping
    public ResponseEntity<LeadEntity> createLead(@RequestBody LeadEntity lead) {
        LeadEntity createdLead = leadService.createLead(lead);
        return ResponseEntity.ok(createdLead);
    }

    // Get all leads
    @Operation(summary = "get all leads")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "fetched successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @GetMapping
    public List<LeadEntity> getAllLeads() {
        return leadService.getAllLeads();
    }

    // Get a lead by ID
    @Operation(summary = "get lead by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "fetched lead by id"),
        @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @GetMapping("/{id}")
    public ResponseEntity<LeadEntity> getLeadById(@PathVariable int id) {
        return leadService.getLeadById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a lead by ID
    @Operation(summary = "update lead")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "updated  successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @PutMapping("/{id}")
    public ResponseEntity<LeadEntity> updateLead(@PathVariable int id, @RequestBody LeadEntity updatedLead) {
        LeadEntity lead = leadService.updateLead(id, updatedLead);
        return ResponseEntity.ok(lead);
    }

    // Delete a lead by ID
    @Operation(summary = "delete lead")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "deleted successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLead(@PathVariable int id) {
        leadService.deleteLead(id);
        return ResponseEntity.noContent().build();
    }
}
