package user.com;

import jwt.com.JwtUtil;
import jwt.com.LoginRequest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class JwtAuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    // POST method for user login and JWT token generation
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Validate username and password
        Optional<User> optionalUser = userService.findByusername(loginRequest.getUsername()); // Updated to match naming conventions
        if (optionalUser.isEmpty() || !userService.checkPassword(optionalUser.get(), loginRequest.getPassword())) { // Updated to match naming conventions
            return ResponseEntity.status(401).body("Invalid username or password");
        }

        // Generate JWT token
        String token = jwtUtil.generateToken(optionalUser.get().getusername()); // Updated to match naming conventions
        return ResponseEntity.ok(token);
    }

    // GET method to retrieve JWT token without authentication (optional)
    @GetMapping("/token")
    public ResponseEntity<String> getToken(@RequestParam String username) {
        Optional<User> optionalUser = userService.findByusername(username); // Ensure this returns a User object
        if (optionalUser.isPresent()) {
            // Generate JWT token
            String token = jwtUtil.generateToken(optionalUser.get().getusername()); // Updated to match naming conventions
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(404).body("User not found");
    }
}
