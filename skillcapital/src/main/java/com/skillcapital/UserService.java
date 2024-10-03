package com.skillcapital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    private  UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

   public UserService(UserRepository userRepository)
   {
       this.userRepository=userRepository;
       this.passwordEncoder=new BCryptPasswordEncoder();
   }

//    1: SAVING THE USER
public String saveUser(User user) {
    // Check for existing user by all fields (username and email)
    List<User> existingUsersWithSameDetails = userRepository.findByAllFields(
            user.getUsername(), user.getEmail() /* add other fields here if needed */);

    if (!existingUsersWithSameDetails.isEmpty()) {
        return "User already exists with the same details.";
    }

    // Check for existing user by email only
    Optional<User> existingUserByEmail = userRepository.findByEmailIgnoreCase(user.getEmail());
    if (existingUserByEmail.isPresent()) {
        return "Email already exists/in use.";
    }

    // Hashing the password before saving
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepository.save(user);
    return "User registered successfully";
}

//    2: FIND ALL USERS
    public List<User> findAllUsers()
    {
        return userRepository.findAll();
    }

//    3: FIND USERNAME BY ID
    public User findById(Long id)
    {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

//    4: FINDING USERNAME BY USERNAME
    public User findByUsername(String username)
    {
        return userRepository.findByUsernameIgnoreCase(username).orElse(null);
    }

//    5: UPDATING USER
    public User updateUser(Long id, User updatedUser) {
        Optional<User> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            // Update user fields
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());

            // If the password is provided, update it (hash before saving)
            if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
                existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
            }

            return userRepository.save(existingUser); // Save updated user
        }
        return null; // Or throw an exception if needed
    }



//    6: DELETE USERNAME BY ID
    public boolean deleteById(Long id)
    {
        if(userRepository.existsById(id))
        {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

//    5: CHECKING PASSWORD
    public boolean CheckPassword(String rawPassword, String encodedPassword)
    {
        return passwordEncoder.matches(rawPassword,encodedPassword);
    }
}
