package user.com;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { // Changed Integer to Long

    Optional<User> findByemail(String email); // Renamed parameter to email

    User findByUsernameAndEmail(String username, String email);

    User findByUsernameAndPassword(String username, String password); // Renamed parameter to username

    User findByusername(String username); // Renamed parameter to username

   // Optional<User> findByid(Long id); // Changed Integer to Long and renamed parameter to id

	boolean existsByid(Long id);

	Optional<User> findByid(Long id);
}
