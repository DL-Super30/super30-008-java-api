package opportunity.com;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/opportunities")
@Validated
public class OpportunityController {

    private static final Logger logger = LoggerFactory.getLogger(OpportunityController.class);

    @Autowired
    private OpportunityService opportunityService;

    @Operation(summary = "Create a new opportunity")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Opportunity created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request"),
        @ApiResponse(responseCode = "409", description = "Email already exists in opportunity")
    })
    @PostMapping
    public ResponseEntity<?> createOpportunity(@Validated @RequestBody Opportunity opportunity) {
        // Log the incoming opportunity data
        logger.info("Creating opportunity with data: {}", opportunity);

        try {
            Opportunity createdOpportunity = opportunityService.createOpportunity(opportunity);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOpportunity);
        } catch (IllegalArgumentException e) {
            logger.warn("Conflict while creating opportunity: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            logger.error("Error creating opportunity", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the opportunity.");
        }
    }

    @Operation(summary = "Fetch list of opportunities", description = "Fetch all opportunities with pagination support.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Fetched successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid pagination parameters")
    })
    @GetMapping
    public ResponseEntity<Page<Opportunity>> getOpportunities(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        if (size <= 0) {
            return ResponseEntity.badRequest().body(null); // Bad request for invalid size
        }
        Pageable pageable = PageRequest.of(page, size);
        try {
            Page<Opportunity> opportunities = opportunityService.getOpportunities(pageable);
            return ResponseEntity.ok(opportunities);
        } catch (Exception e) {
            logger.error("Error fetching opportunities", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "Get an opportunity by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Fetched successfully"),
        @ApiResponse(responseCode = "404", description = "Opportunity not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Opportunity> getOpportunityById(@PathVariable Long id) {
        Opportunity opportunity = opportunityService.getOpportunityById(id);
        return opportunity != null 
                ? ResponseEntity.ok(opportunity) 
                : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Update an existing opportunity by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Updated successfully"),
        @ApiResponse(responseCode = "404", description = "Opportunity not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Opportunity> updateOpportunity(@PathVariable Long id, @Validated @RequestBody Opportunity updatedOpportunity) {
        Opportunity savedOpportunity = opportunityService.updateOpportunity(id, updatedOpportunity);
        return savedOpportunity != null
            ? ResponseEntity.ok(savedOpportunity)
            : ResponseEntity.notFound().build();
    }

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
