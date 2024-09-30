package learners.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LearnerService {

    @Autowired
    private LearnerRepository learnerRepository; 

    // Method to save a new learner
    public Learner saveLearner(Learner learner) {
        return learnerRepository.save(learner);
    }

    // Method to fetch all learners with pagination
    public Page<Learner> findAll(Pageable pageable) {
        return learnerRepository.findAll(pageable);
    }

    // Method to search learners by first name
    public Page<Learner> searchLearnersByfirstname(String firstname, Pageable pageable) {
        return learnerRepository.findByfirstnameContainingIgnoreCase(firstname, pageable);
    }

    // Method to search learners by last name
    public Page<Learner> searchLearnersBylastname(String lastname, Pageable pageable) {
        return learnerRepository.findBylastnameContainingIgnoreCase(lastname, pageable);
    }

    // Method to get a learner by ID
    public Optional<Learner> getLearnerById(Long id) {
        return learnerRepository.findById(id);
    }

    // Method to update an existing learner
    public Learner updateLearner(Long id, Learner learnerDetails) {
        Learner existingLearner = learnerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Learner not found with id: " + id));

        // Update fields
        existingLearner.setfirstname(learnerDetails.getfirstname());
        existingLearner.setlastname(learnerDetails.getlastname());
        existingLearner.setIdproof(learnerDetails.getIdproof());
        existingLearner.setPhone(learnerDetails.getPhone());
        existingLearner.setDateofbirth(learnerDetails.getDateofbirth());
        existingLearner.setEmail(learnerDetails.getEmail());
        existingLearner.setRegistereddate(learnerDetails.getRegistereddate());
        existingLearner.setLocation(learnerDetails.getLocation());
        existingLearner.setBatchids(learnerDetails.getBatchids());
        existingLearner.setAlternatephone(learnerDetails.getAlternatephone());
        existingLearner.setDescription(learnerDetails.getDescription());
        existingLearner.setExchangerate(learnerDetails.getExchangerate());
        existingLearner.setSource(learnerDetails.getSource());
        existingLearner.setAttendeddemo(learnerDetails.getAttendeddemo());
        existingLearner.setLearnerowner(learnerDetails.getLearnerowner());
        existingLearner.setLearnerstage(learnerDetails.getLearnerstage());

        // Add more fields if necessary...

        // Save and return the updated learner
        return learnerRepository.save(existingLearner);
    }

    // Method to delete a learner by ID
    public void deleteLearner(Long learnerId) {
        learnerRepository.deleteById(learnerId);
    }
}
