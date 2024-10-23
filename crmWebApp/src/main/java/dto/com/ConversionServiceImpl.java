package dto.com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConversionServiceImpl implements ConversionService {

    private static final Logger logger = LoggerFactory.getLogger(ConversionServiceImpl.class);

    // Mocked data store for demonstration purposes
    private static final Map<Long, LeadDTO> leadStore = new HashMap<>();
    private static final Map<Long, OpportunityDTO> opportunityStore = new HashMap<>();

    // Static block to initialize some mock data
    static {
        // Example LeadDTOs (populate fields as necessary)
        leadStore.put(1L, new LeadDTO(/* Populate fields here */));
        leadStore.put(2L, new LeadDTO(/* Populate fields here */));

        // Example OpportunityDTOs (populate fields as necessary)
        opportunityStore.put(1L, new OpportunityDTO(/* Populate fields here */));
        opportunityStore.put(2L, new OpportunityDTO(/* Populate fields here */));
    }

    @Override
    public OpportunityDTO convertLeadToOpportunity(Long leadId) {
        LeadDTO leadDTO = findLeadById(leadId);
        if (leadDTO == null) {
            logger.error("Lead not found with id: {}", leadId);
            return null; // Indicate failure to find the lead
        }
        OpportunityDTO opportunityDTO = DtoMapper.convertLeadToOpportunity(leadDTO);
        logger.info("Converted LeadDTO to OpportunityDTO: {}", opportunityDTO);
        return opportunityDTO;
    }

    @Override
    public LearnerDTO convertLeadToLearner(Long leadId) {
        LeadDTO leadDTO = findLeadById(leadId);
        if (leadDTO == null) {
            logger.error("Lead not found with id: {}", leadId);
            return null; // Indicate failure to find the lead
        }
        LearnerDTO learnerDTO = DtoMapper.convertLeadToLearner(leadDTO);
        logger.info("Converted LeadDTO to LearnerDTO: {}", learnerDTO);
        return learnerDTO;
    }

    @Override
    public LearnerDTO convertOpportunityToLearner(Long opportunityId) {
        OpportunityDTO opportunityDTO = findOpportunityById(opportunityId);
        if (opportunityDTO == null) {
            logger.error("Opportunity not found with id: {}", opportunityId);
            return null; // Indicate failure to find the opportunity
        }
        LearnerDTO learnerDTO = DtoMapper.convertOpportunityToLearner(opportunityDTO);
        logger.info("Converted OpportunityDTO to LearnerDTO: {}", learnerDTO);
        return learnerDTO;
    }

    @Override
    public LeadDTO findLeadById(Long leadId) {
        LeadDTO leadDTO = leadStore.get(leadId);
        if (leadDTO == null) {
            logger.error("Lead not found with id: {}", leadId);
            return null; // Indicate failure to find the lead
        }
        return leadDTO;
    }

    @Override
    public OpportunityDTO findOpportunityById(Long opportunityId) {
        OpportunityDTO opportunityDTO = opportunityStore.get(opportunityId);
        if (opportunityDTO == null) {
            logger.error("Opportunity not found with id: {}", opportunityId);
            return null; // Indicate failure to find the opportunity
        }
        return opportunityDTO;
    }

    @Override
    public void deleteLeadById(Long leadId) {
        if (leadStore.remove(leadId) == null) {
            logger.error("Lead not found with id: {}", leadId);
            // Indicate failure to delete the lead without throwing an exception
            return; 
        }
        logger.info("Deleted lead with id: {}", leadId);
    }

    @Override
    public void deleteOpportunityById(Long opportunityId) {
        if (opportunityStore.remove(opportunityId) == null) {
            logger.error("Opportunity not found with id: {}", opportunityId);
            // Indicate failure to delete the opportunity without throwing an exception
            return; 
        }
        logger.info("Deleted opportunity with id: {}", opportunityId);
    }
}
