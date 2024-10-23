package dto.com;




public class DtoMapper {

   
    public static OpportunityDTO convertLeadToOpportunity(LeadDTO leadDTO) {
        OpportunityDTO opportunityDTO = new OpportunityDTO();
        opportunityDTO.setId(leadDTO.getId());
        opportunityDTO.setName(leadDTO.getName());
        opportunityDTO.setCc(leadDTO.getCc());
        opportunityDTO.setPhone(leadDTO.getPhone());
        opportunityDTO.setEmail(leadDTO.getEmail());
        opportunityDTO.setFeequoted(leadDTO.getFeequoted());
        opportunityDTO.setLeadstatus(leadDTO.getLeadstatus());
        opportunityDTO.setLeadsource(leadDTO.getLeadsource());
        opportunityDTO.setStack(leadDTO.getStack());
        opportunityDTO.setCourse(leadDTO.getCourse());
        opportunityDTO.setClassmode(leadDTO.getClassmode());
        opportunityDTO.setNextfollowup(leadDTO.getNextfollowup());
        opportunityDTO.setDescription(leadDTO.getDescription());
        opportunityDTO.setBatchtiming(leadDTO.getBatchtiming());
        return opportunityDTO;
    }

    // Convert LeadDTO to LearnerDTO
    public static LearnerDTO convertLeadToLearner(LeadDTO leadDTO) {
        LearnerDTO learnerDTO = new LearnerDTO();
        learnerDTO.setId(leadDTO.getId());
        learnerDTO.setFirstname(leadDTO.getName());  // Assuming firstName is derived from name
        learnerDTO.setPhone(leadDTO.getPhone());
        learnerDTO.setEmail(leadDTO.getEmail());
        learnerDTO.setDescription(leadDTO.getDescription());
        learnerDTO.setBatchids(leadDTO.getStack()); // Assuming batchIds are derived from stack
        // Set other fields as needed
        return learnerDTO;
    }

    // Convert OpportunityDTO to LearnerDTO
    public static LearnerDTO convertOpportunityToLearner(OpportunityDTO opportunityDTO) {
        LearnerDTO learnerDTO = new LearnerDTO();
        learnerDTO.setId(opportunityDTO.getId());
        learnerDTO.setFirstname(opportunityDTO.getName());  // Assuming firstName is derived from name
        learnerDTO.setPhone(opportunityDTO.getPhone());
        learnerDTO.setEmail(opportunityDTO.getEmail());
        learnerDTO.setDescription(opportunityDTO.getDescription());
        learnerDTO.setBatchids(opportunityDTO.getStack()); // Assuming batchIds are derived from stack
        // Set other fields as needed
        return learnerDTO;
    }
}
