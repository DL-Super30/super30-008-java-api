package com.skillcapital.leads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//                           LeadController : This class is responsible for API Call methods


@RestController
@RequestMapping("/api/leads")
public class LeadController
{

    @Autowired
    private LeadService leadService;

    // 1: CREATING A NEW LEAD
    @PostMapping("/register") // Endpoint to register a new lead
    public ResponseEntity<String> createLead(@RequestBody Lead lead)
    {
        try {
            String result = leadService.registerLead(lead); // Use result from registerLead
            if (result.equals("Lead registered successfully"))
            {
                return ResponseEntity.ok(result);
            }
            else
            {
                return ResponseEntity.status(409).body(result); // 409 Conflict for existing leads
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error occurred: " + e.getMessage());
        }
    }

    // 2: FIND ALL LEADS
    @GetMapping("/all")
    public ResponseEntity<List<Lead>> findAllLeads()
    {
        List<Lead> leads = leadService.findAllLeads();
        return ResponseEntity.ok(leads);
    }


    // 3: GET LEAD BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Lead> getLead(@PathVariable Long id)
    {
        Lead lead = leadService.findById(id);
        return lead != null ? ResponseEntity.ok(lead) : ResponseEntity.notFound().build();
    }

    // 4: GET LEAD BY NAME
    @GetMapping("/name/{name}") // New endpoint to get lead by name
    public ResponseEntity<Lead> getLeadByName(@PathVariable String name)
    {
        Lead lead = leadService.findByName(name);
        return lead != null ? ResponseEntity.ok(lead) : ResponseEntity.notFound().build();
    }

    // 5: UPDATE LEAD BY ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateLead(@PathVariable Long id, @RequestBody Lead updatedLead)
    {
        Lead lead = leadService.updateLead(id, updatedLead);
        if (lead != null)
        {
            return ResponseEntity.ok("Lead Updated Successfully");
        }
        return ResponseEntity.notFound().build();
    }

    // 6: DELETE LEAD BY ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLead(@PathVariable Long id)
    {
        if (leadService.deleteById(id))
        {
            return ResponseEntity.ok("Lead Deleted Successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
