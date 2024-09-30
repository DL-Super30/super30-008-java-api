package courses.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Get all courses
    @Operation(summary = "fetch all courses")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "fetched all courses successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    // Get a course by ID
    @Operation(summary = "get course by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "fetched by id successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id)
                .map(course -> ResponseEntity.ok().body(course))
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new course
    @Operation(summary = "Create a new course")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "course created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course createdCourse = courseService.createCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCourse);
    }

    // Update an existing course
    @Operation(summary = "update course")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "updated  successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        Course updatedCourse = courseService.updateCourse(id, courseDetails);
        return ResponseEntity.ok(updatedCourse);
    }
    @Operation(summary = "delete course")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "deleted successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    // Delete a course by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
