package user.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; // Injecting the UserRepository

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Create a new user
    public User createUser(User user) {
        // Check if the email already exists
        Optional<User> existingUser = userRepository.findByemail(user.getemail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already exists"); // Exception for duplicate email
        }

        // Encode the password
        user.setpassword(passwordEncoder.encode(user.getpassword()));
        return userRepository.save(user); // Save user to database
    }

    // Fetch all users
    public List<User> findAll() {
        return userRepository.findAll(); // Return a list of all users from the database
    }

    // Find a user by ID
    public Optional<User> findByid(Long id) {
        return userRepository.findByid(id); // Return Optional<User>
    }

    // Check if the provided password matches the encoded password
    public boolean checkPassword(User user, String password) {
        return passwordEncoder.matches(password, user.getpassword());
    }

    // Method to update an existing user
    public User updateUser(Long id, User userDetails) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update the user details
        existingUser.setusername(userDetails.getusername());
        existingUser.setpassword(passwordEncoder.encode(userDetails.getpassword())); // Re-encode the password
        existingUser.setemail(userDetails.getemail()); // Update email if necessary
        return userRepository.save(existingUser); // Save updated user
    }

    // Method to delete a user by ID
    public void deleteUser(Long id) {
        if (!userRepository.existsByid(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id); // Remove the user from the database
    }

    // Find a user by username
    public Optional<User> findByusername(String username) {
        return Optional.ofNullable(userRepository.findByusername(username)); // Return user if found
    }

	public boolean checkpassword(Optional<User> user, String getpassword) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
