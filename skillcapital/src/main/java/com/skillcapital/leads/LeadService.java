package com.skillcapital.leads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeadService
{
    private final LeadRepository leadRepository;

    @Autowired
    public LeadService(LeadRepository leadRepository)
    {
        this.leadRepository = leadRepository;
    }

//    1: SAVING THE LEAD
    public Lead saveLead(Lead lead)
    {
        return leadRepository.save(lead);
    }

//    2: FIND ALL LEADS
    public List<Lead> findAllLeads()
    {
        return leadRepository.findAll();
    }


//  3: FIND BY USERNAME
    public Lead findByName(String name)
    {
        Optional<Lead> lead = leadRepository.findByName(name);
        return lead.orElse(null);
    }

//    4: FIND BY ID
    public Lead findById(Long id)
    {
        Optional<Lead> lead = leadRepository.findById(id);
        return lead.orElse(null);
    }


//    5: UPDATE BY ID
    public Lead updateLead(Long id, Lead updatedLead)
    {
        Optional<Lead> existingLeadOptional = leadRepository.findById(id);
        if (existingLeadOptional.isPresent())
        {
            Lead existingLead = existingLeadOptional.get();
            // Update fields as needed
            existingLead.setName(updatedLead.getName());
            existingLead.setEmail(updatedLead.getEmail());
            // Continue updating other fields...

            return leadRepository.save(existingLead);
        }
        return null;
    }

//    6: DELETE BY ID

    public boolean deleteById(Long id)
    {
        if (leadRepository.existsById(id))
        {
            leadRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
