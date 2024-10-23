package learners.com;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearnerRepository extends JpaRepository<Learner, Long> {
    boolean existsByEmail(String email);

    boolean existsById(Long id);

    void deleteById(Long id);

    Optional<Learner> findById(Long id);

    // Removed the method related to finding learners by lead ID
    // List<Learner> findByLeadId(Long leadId);
}
