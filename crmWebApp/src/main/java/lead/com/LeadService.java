package lead.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    // Fetch a lead by ID
    public Optional<LeadEntity> getLeadById(Long id) {
        return leadRepository.findById(id);
    }

    // Create a new lead with email validation
    public LeadEntity createLead(LeadEntity leadEntity) {
        Optional<LeadEntity> existingLead = leadRepository.findByEmail(leadEntity.getEmail());
        if (existingLead.isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists: " + leadEntity.getEmail());
        }
        return leadRepository.save(leadEntity);
    }

    // Update an existing lead
    public LeadEntity updateLead(Long id, LeadEntity updatedLead) {
        return leadRepository.findById(id).map(lead -> {
            lead.setName(updatedLead.getName());
            lead.setCc(updatedLead.getCc());
            lead.setPhone(updatedLead.getPhone());
            lead.setEmail(updatedLead.getEmail());
            lead.setFeequoted(updatedLead.getFeequoted());
            lead.setLeadstatus(updatedLead.getLeadstatus());
            lead.setLeadsource(updatedLead.getLeadsource());
            lead.setStack(updatedLead.getStack());
            lead.setCourse(updatedLead.getCourse());
            lead.setClassmode(updatedLead.getClassmode());
            lead.setNextfollowup(updatedLead.getNextfollowup());
            lead.setDescription(updatedLead.getDescription());
            lead.setBatchtiming(updatedLead.getBatchtiming());
            return leadRepository.save(lead);
        }).orElseThrow(() -> new RuntimeException("Lead not found with ID: " + id));
    }

    // Delete a lead by ID
    public void deleteLead(Long id) {
        leadRepository.deleteById(id);
    }

    // Get all leads created today
    public List<LeadEntity> getTodaysLeads() {
        LocalDate today = LocalDate.now();
        return leadRepository.findLeadsByCreatedAtBetween(today.atStartOfDay(), today.plusDays(1).atStartOfDay());
    }
}
