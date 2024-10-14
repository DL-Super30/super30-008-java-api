package com.skillcapital.leads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//                  LeadService: This is responsible for implementing methods used by the LeadController for CRUD operations.


@Service
public class LeadService
{

    private final LeadRepository leadRepository;

    @Autowired
    public LeadService(LeadRepository leadRepository)
    {
        this.leadRepository = leadRepository;
    }

    // 1: SAVING THE LEAD
    public String registerLead(Lead lead) {

        // Check if the same lead (all details match) is already registered
        Optional<Lead> existingLead = leadRepository.findByNameAndEmailIgnoreCase(lead.getName(), lead.getEmail());

        if (existingLead.isPresent())
        {
            return " Lead Credentials Exists ";
        }

        // Check if a lead with the same email already exists
        if (leadRepository.existsByEmail(lead.getEmail()))
        {
            return " Email Already Exists ";
        }

        // Save the new lead
        leadRepository.save(lead);
        return " Lead Registered Successfully ";
    }

    // 2: FIND ALL LEADS
    public List<Lead> findAllLeads()
    {
        return leadRepository.findAll();
    }

    // 3: FIND BY NAME
    public Lead findByName(String name)
    {
        Optional<Lead> lead = leadRepository.findByNameIgnoreCase(name);
        return lead.orElse(null);
    }

    // 4: FIND BY ID
    public Lead findById(Long id)
    {
        Optional<Lead> lead = leadRepository.findById(id);
        return lead.orElse(null);
    }

    // 5: UPDATE BY ID
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

    // 6: DELETE BY ID
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
