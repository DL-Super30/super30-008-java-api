package opportunity.com;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/opportunities")
public class OpportunityController {

    @Autowired
    private OpportunityService opportunityService;

    // CREATE operation
    @Operation(summary = "Create a new opportunity")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Opportunity created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @PostMapping
    public ResponseEntity<Opportunity> createOpportunity(@RequestBody Opportunity opportunity) {
        Opportunity createdOpportunity = opportunityService.saveOpportunity(opportunity);
        URI location = URI.create("/api/opportunities/" + createdOpportunity.getId());
        return ResponseEntity.created(location).body(createdOpportunity);
    }

    // READ operation with pagination
    @Operation(summary = "Fetch list of opportunities", description = "Fetch all opportunities with pagination support.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Fetched successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid pagination parameters")
    })
    @GetMapping
    public ResponseEntity<Page<Opportunity>> getOpportunities(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Opportunity> opportunities = opportunityService.getOpportunities(pageable);
        return ResponseEntity.ok(opportunities);
    }

    // READ single opportunity
    @Operation(summary = "Get an opportunity by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Fetched successfully"),
        @ApiResponse(responseCode = "404", description = "Opportunity not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Opportunity> getOpportunityById(@PathVariable Long id) {
        return opportunityService.getOpportunityById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // UPDATE operation
    @Operation(summary = "Update an existing opportunity by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Updated successfully"),
        @ApiResponse(responseCode = "404", description = "Opportunity not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Opportunity> updateOpportunity(@PathVariable Long id, @RequestBody Opportunity updatedOpportunity) {
        Opportunity savedOpportunity = opportunityService.updateOpportunity(id, updatedOpportunity);
        return savedOpportunity != null 
            ? ResponseEntity.ok(savedOpportunity)
            : ResponseEntity.notFound().build();
    }

    // DELETE operation
    @Operation(summary = "Delete an opportunity by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Opportunity not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOpportunity(@PathVariable Long id) {
        if (opportunityService.existsById(id)) {
            opportunityService.deleteOpportunity(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

