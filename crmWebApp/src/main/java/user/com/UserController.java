package user.com;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create a new user
    @Operation(summary = "Create a new user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "user created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    // Fetch all users
    @Operation(summary = "fetch all users")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "fetched successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    // Fetch user by ID
    @Operation(summary = "fetch user by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "fetched by id successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        return user.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an existing user
    @Operation(summary = "update user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "updated successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails)
                .map(updatedUser -> ResponseEntity.ok(updatedUser))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a user by ID
    @Operation(summary = "delete user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "deleted successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
