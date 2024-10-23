package dto.com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ConvertController {

    private static final Logger logger = LoggerFactory.getLogger(ConvertController.class);
    private final ConversionService conversionService;

    public ConvertController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @GetMapping("/lead/{leadId}/to-opportunity")
    public ResponseEntity<OpportunityDTO> convertLeadToOpportunity(@PathVariable Long leadId) {
        logger.info("Converting lead with ID {} to Opportunity", leadId);
        OpportunityDTO opportunityDTO = conversionService.convertLeadToOpportunity(leadId);
        return ResponseEntity.ok(opportunityDTO);
    }

    @GetMapping("/lead/{leadId}/to-learner")
    public ResponseEntity<LearnerDTO> convertLeadToLearner(@PathVariable Long leadId) {
        logger.info("Converting lead with ID {} to Learner", leadId);
        LearnerDTO learnerDTO = conversionService.convertLeadToLearner(leadId);
        return ResponseEntity.ok(learnerDTO);
    }

    @GetMapping("/opportunity/{opportunityId}/to-learner")
    public ResponseEntity<LearnerDTO> convertOpportunityToLearner(@PathVariable Long opportunityId) {
        logger.info("Converting opportunity with ID {} to Learner", opportunityId);
        LearnerDTO learnerDTO = conversionService.convertOpportunityToLearner(opportunityId);
        return ResponseEntity.ok(learnerDTO);
    }

    @GetMapping("/lead/{leadId}")
    public ResponseEntity<LeadDTO> getLeadById(@PathVariable Long leadId) {
        logger.info("Fetching Lead with ID {}", leadId);
        LeadDTO leadDTO = conversionService.findLeadById(leadId);
        return ResponseEntity.ok(leadDTO);
    }

    @GetMapping("/opportunity/{opportunityId}")
    public ResponseEntity<OpportunityDTO> getOpportunityById(@PathVariable Long opportunityId) {
        logger.info("Fetching Opportunity with ID {}", opportunityId);
        OpportunityDTO opportunityDTO = conversionService.findOpportunityById(opportunityId);
        return ResponseEntity.ok(opportunityDTO);
    }

    @DeleteMapping("/lead/{leadId}")
    public ResponseEntity<Void> deleteLeadById(@PathVariable Long leadId) {
        logger.info("Deleting Lead with ID {}", leadId);
        try {
			conversionService.deleteLeadById(leadId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/opportunity/{opportunityId}")
    public ResponseEntity<Void> deleteOpportunityById(@PathVariable Long opportunityId) {
        logger.info("Deleting Opportunity with ID {}", opportunityId);
        conversionService.deleteOpportunityById(opportunityId);
        return ResponseEntity.noContent().build();
    }
}
