package com.skillcapital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
// http://localhost:8080/api/auth after this we can use register  method.
public class AuthController
{

    @Autowired
    private UserService userService;

    // 1: REGISTERING A NEW USER
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return ResponseEntity.ok("User registered successfully");
        }
        catch (Exception e) {
            // Log the exception and return internal server error
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error occurred: " + e.getMessage());
        }
    }
}
