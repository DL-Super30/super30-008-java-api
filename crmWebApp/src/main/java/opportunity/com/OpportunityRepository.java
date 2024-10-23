package opportunity.com;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {
    
    Optional<Opportunity> findById(Long id); // Use camelCase 'Id'
    
    void deleteById(Long id); // Use camelCase 'Id'
    
    boolean existsByEmail(String email); // Use camelCase 'Email'

    // The save and existsById methods are inherited from JpaRepository, no need to override or declare them.
}
