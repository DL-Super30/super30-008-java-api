package learners.com;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LearnerRepository extends JpaRepository<Learner, Long> {
    // Method to find learners by first name
    
    
    // Method to find learners by last name
   
    Page<Learner> findBylastnameContainingIgnoreCase(String lastname, Pageable pageable);
    Page<Learner> findByfirstnameContainingIgnoreCase(String firstname, Pageable pageable);

}
