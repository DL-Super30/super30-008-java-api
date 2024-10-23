package opportunity.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OpportunityService {

    @Autowired
    private OpportunityRepository opportunityRepository;

    // CREATE operation with duplicate email check
    @Transactional
    public Opportunity createOpportunity(Opportunity opportunity) {
        if (opportunityRepository.existsByEmail(opportunity.getemail())) {
            throw new IllegalArgumentException("Email already exists in opportunity.");
        }
        return opportunityRepository.save(opportunity);
    }

    // READ operation (all opportunities)
    @Transactional(readOnly = true)
    public List<Opportunity> getAllOpportunities() {
        return opportunityRepository.findAll();
    }

    // READ operation (paginated list)
    @Transactional(readOnly = true)
    public Page<Opportunity> getOpportunities(Pageable pageable) {
        return opportunityRepository.findAll(pageable);
    }

    // READ operation (single opportunity by ID)
    @Transactional(readOnly = true)
    public Opportunity getOpportunityById(Long id) {
        return opportunityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Opportunity not found"));
    }

    // UPDATE operation
    @Transactional
    public Opportunity updateOpportunity(Long id, Opportunity updatedOpportunity) {
        Opportunity existingOpportunity = opportunityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Opportunity not found"));

        // Update fields as needed
        existingOpportunity.setname(updatedOpportunity.getname());
        existingOpportunity.setcc(updatedOpportunity.getcc());
        existingOpportunity.setphone(updatedOpportunity.getphone());
        existingOpportunity.setemail(updatedOpportunity.getemail());
        existingOpportunity.setfeequoted(updatedOpportunity.getfeequoted());
        existingOpportunity.setopportunitystatus(updatedOpportunity.getopportunitystatus());
        existingOpportunity.setopportunitystage(updatedOpportunity.getopportunitystage());
        existingOpportunity.setvisitedstage(updatedOpportunity.getvisitedstage());
        existingOpportunity.setlostopportunityreason(updatedOpportunity.getlostopportunityreason());
        existingOpportunity.setnextfollowup(updatedOpportunity.getnextfollowup());
        existingOpportunity.setleadstatus(updatedOpportunity.getleadstatus());
        existingOpportunity.setleadsource(updatedOpportunity.getleadsource());
        existingOpportunity.setcourse(updatedOpportunity.getcourse());
        existingOpportunity.setdescription(updatedOpportunity.getdescription());
        existingOpportunity.setclassmode(updatedOpportunity.getclassmode());
        existingOpportunity.setdemoattendedstage(updatedOpportunity.getdemoattendedstage());
        existingOpportunity.setbatchtiming(updatedOpportunity.getbatchtiming());
        existingOpportunity.setstack(updatedOpportunity.getstack());

        return opportunityRepository.save(existingOpportunity);
    }

    // DELETE operation
    @Transactional
    public void deleteOpportunity(Long id) {
        if (!opportunityRepository.existsById(id)) {
            throw new RuntimeException("Opportunity not found");
        }
        opportunityRepository.deleteById(id);
    }

    // Check if opportunity exists by ID
    @Transactional(readOnly = true)
    public boolean existsById(Long id) {
        return opportunityRepository.existsById(id);
    }
}
