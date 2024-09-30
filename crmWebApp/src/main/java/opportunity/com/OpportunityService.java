package opportunity.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OpportunityService {

    @Autowired
    private OpportunityRepository opportunityRepository;

    // CREATE operation
    public Opportunity saveOpportunity(Opportunity opportunity) {
        return opportunityRepository.save(opportunity);
    }

    // READ operation (paginated list)
    public Page<Opportunity> getOpportunities(Pageable pageable) {
        return opportunityRepository.findAll(pageable);
    }

    // READ operation (single opportunity by ID)
    public Optional<Opportunity> getOpportunityById(Long id) {
        return opportunityRepository.findById(id);
    }

    // UPDATE operation
    public Opportunity updateOpportunity(Long id, Opportunity updatedOpportunity) {
        Optional<Opportunity> existingOpportunity = opportunityRepository.findById(id);
        if (existingOpportunity.isPresent()) {
            Opportunity opportunity = existingOpportunity.get();
            // Update fields as needed
            opportunity.setName(updatedOpportunity.getName());
            opportunity.setCc(updatedOpportunity.getCc());
            opportunity.setPhone(updatedOpportunity.getPhone());
            opportunity.setEmail(updatedOpportunity.getEmail());
            opportunity.setFeeQuoted(updatedOpportunity.getFeeQuoted());
            opportunity.setOpportunityStatus(updatedOpportunity.getOpportunityStatus());
            opportunity.setOpportunityStage(updatedOpportunity.getOpportunityStage());
            opportunity.setdemoattendedstage(updatedOpportunity.getdemoattendedstage()); // corrected method name
            opportunity.setVisitedStage(updatedOpportunity.getVisitedStage());
            opportunity.setLostOpportunityReason(updatedOpportunity.getLostOpportunityReason());
            opportunity.setNextFollowUp(updatedOpportunity.getNextFollowUp());
            opportunity.setLeadStatus(updatedOpportunity.getLeadStatus());
            opportunity.setLeadSource(updatedOpportunity.getLeadSource());
            opportunity.setCourse(updatedOpportunity.getCourse());
            opportunity.setDescription(updatedOpportunity.getDescription());
            // Save updated opportunity
            return opportunityRepository.save(opportunity);
        } else {
            return null; 
        }
    }

    // DELETE operation
    public void deleteOpportunity(Long id) {
        opportunityRepository.deleteById(id);
    }

    // Check if opportunity exists by ID
    public boolean existsById(Long id) {
        return opportunityRepository.existsById(id);
    }
}
