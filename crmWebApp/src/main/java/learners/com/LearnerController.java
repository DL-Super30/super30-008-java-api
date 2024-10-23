package learners.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

import java.util.Optional;

@RestController
@RequestMapping("/api/learners")
public class LearnerController {

    @Autowired
    private LearnerService learnerService;

    @Operation(summary = "Create a new learner")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Learner created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request"),
        @ApiResponse(responseCode = "409", description = "Email already exists")
    })
    @PostMapping
    public ResponseEntity<?> createLearner(@Valid @RequestBody Learner learner) {
        try {
            Learner createdLearner = learnerService.saveLearner(learner);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdLearner);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @Operation(summary = "Fetch all learners")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Fetched successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @GetMapping
    public Page<Learner> getAllLearners(
            @Parameter(description = "Page number (0-based)", example = "0")
            @RequestParam(defaultValue = "0") int page,

            @Parameter(description = "Number of records per page", example = "10")
            @RequestParam(defaultValue = "10") int size,

            @Parameter(description = "Sort order in the format: property(,asc|desc)", example = "firstname,asc")
            @RequestParam(defaultValue = "id,asc") String[] sort) {

        Sort sortOrder = Sort.by(
            sort[0].endsWith("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,
            sort[0].replace(",asc", "").replace(",desc", "")
        );

        Pageable pageable = PageRequest.of(page, size, sortOrder);
        return learnerService.findAll(pageable);
    }

    @Operation(summary = "Get learner by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Fetched learner by ID successfully"),
        @ApiResponse(responseCode = "404", description = "Learner not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Learner> getLearnerById(@Parameter(description = "ID of the learner to be fetched", required = true) @PathVariable Long id) {
        Optional<Learner> learner = learnerService.getLearnerById(id);
        return learner.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update learner")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Updated successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request"),
        @ApiResponse(responseCode = "404", description = "Learner not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Learner> updateLearner(
            @Parameter(description = "ID of the learner to be updated", required = true) @PathVariable Long id,
            @Valid @RequestBody Learner learnerDetails) {
        Learner updatedLearner = learnerService.updateLearner(id, learnerDetails);
        return ResponseEntity.ok(updatedLearner);
    }

    @Operation(summary = "Delete learner")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Learner not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLearner(@Parameter(description = "ID of the learner to be deleted", required = true) @PathVariable Long id) {
        learnerService.deleteLearner(id);
        return ResponseEntity.noContent().build();
    }
}
