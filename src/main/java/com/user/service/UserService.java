package com.user.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @SuppressWarnings("null")
	public String authenticateUser(User user) throws NotFoundException
    {
    	BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
    	CrudRepository<User, Integer> usersRepository = null;
		Optional<User> opUser= usersRepository.findById(user.getId());
    	if(opUser.isPresent())
    	{
    		User dbUser=opUser.get();
    		if(bcrypt.matches(user.getPassword(), dbUser.getPassword()))
    		
    			return "Authencated User";
    		else
    			return "Incorrect Password";
    	}
    	throw new NotFoundException();
    	}
    

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public User updateUser(int id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow();
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword()); // Ensure password hashing
        return userRepository.save(user);
    }
    

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

public String addUser(User user)
{
BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
String encryptedPwd=bcrypt.encode(user.getPassword());
User savedUser=userRepository.save(user);
user.setPassword(encryptedPwd);
return savedUser.getUsername()+"added to database succefully";

}
}