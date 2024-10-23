package dto.com;



public interface ConversionService {
    OpportunityDTO convertLeadToOpportunity(Long leadId);
    LearnerDTO convertLeadToLearner(Long leadId);
    LearnerDTO convertOpportunityToLearner(Long opportunityId);
    LeadDTO findLeadById(Long leadId);
    OpportunityDTO findOpportunityById(Long opportunityId);
    
    void deleteLeadById(Long leadId) throws ClassNotFoundException;  // Method for deleting LeadDTO by ID
    void deleteOpportunityById(Long opportunityId);  // Method for deleting OpportunityDTO by ID
}
