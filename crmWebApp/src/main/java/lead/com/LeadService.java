package lead.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    // Create a new lead
    public LeadEntity createLead(LeadEntity lead) {
        return leadRepository.save(lead);
    }

    // Get all leads
    public List<LeadEntity> getAllLeads() {
        return leadRepository.findAll();
    }

    // Get a lead by ID
    public Optional<LeadEntity> getLeadById(int id) {
        return leadRepository.findById(id);
    }

    // Update a lead by ID
    public LeadEntity updateLead(int id, LeadEntity updatedLead) {
        return leadRepository.findById(id)
                .map(lead -> {
                    lead.setName(updatedLead.getName());
                    lead.setCc(updatedLead.getCc());
                    lead.setPhone(updatedLead.getPhone());
                    lead.setEmail(updatedLead.getEmail());
                    lead.setFeeQuoted(updatedLead.getFeeQuoted());
                    lead.setLeadStatus(updatedLead.getLeadStatus());
                    lead.setLeadSource(updatedLead.getLeadSource());
                    lead.setStack(updatedLead.getStack());
                    lead.setCourse(updatedLead.getCourse());
                    lead.setClassMode(updatedLead.getClassMode());
                    lead.setNextFollowUp(updatedLead.getNextFollowUp());
                    lead.setDescription(updatedLead.getDescription());
                    lead.setbatchtiming(updatedLead.getbatchtiming());
                    return leadRepository.save(lead);
                })
                .orElseThrow(() -> new RuntimeException("Lead not found"));
    }

    // Delete a lead by ID
    public void deleteLead(int id) {
        leadRepository.deleteById(id);
    }
}
