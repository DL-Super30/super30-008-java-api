package user.com;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

   // @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Create a new user and hash the password
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Hash the password
        return userRepository.save(user); // Save the user entity to the repository
    }

    // Fetch all users
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Fetch user by ID
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    // Update an existing user
    public Optional<User> updateUser(Long id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setPassword(passwordEncoder.encode(userDetails.getPassword())); // Hash the password
            return userRepository.save(user);
        });
    }

    // Delete a user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
