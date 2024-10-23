package lead.com;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface LeadRepository extends JpaRepository<LeadEntity, Long> {

    // Query to find a lead by email, returning an Optional
    Optional<LeadEntity> findByEmail(String email);

    // Query to find leads created between two LocalDateTime values
    @Query("SELECT l FROM LeadEntity l WHERE l.createdAt BETWEEN :startOfDay AND :endOfDay")
    List<LeadEntity> findLeadsByCreatedAtBetween(@Param("startOfDay") LocalDateTime startOfDay, 
                                                 @Param("endOfDay") LocalDateTime endOfDay);

    // Retrieve lead by ID, returning Optional
    Optional<LeadEntity> findById(Long leadId);
}
