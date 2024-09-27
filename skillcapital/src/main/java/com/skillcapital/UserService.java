package com.skillcapital;

import com.skillcapital.UserRepository;
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
    public User saveUser(User user)
    {
//        Hashing the pw before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
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
        return userRepository.findByUsername(username).orElse(null);
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
