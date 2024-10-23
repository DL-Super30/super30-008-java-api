package learners.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@Service
public class LearnerService {

    @Autowired
    private LearnerRepository learnerRepository;

    public Learner saveLearner(@Valid Learner learner) {
        // Check if email already exists
        if (learnerRepository.existsByEmail(learner.getemail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        return learnerRepository.save(learner);
    }

    public Page<Learner> findAll(Pageable pageable) {
        return learnerRepository.findAll(pageable);
    }

    public Optional<Learner> getLearnerById(Long id) {
        return learnerRepository.findById(id);
    }

    public Learner updateLearner(Long id, Learner learnerDetails) {
        Learner existingLearner = learnerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Learner not found"));

        // Update fields
        existingLearner.setfirstname(learnerDetails.getfirstname());
        existingLearner.setlastname(learnerDetails.getlastname());
        existingLearner.setidproof(learnerDetails.getidproof());
        existingLearner.setphone(learnerDetails.getphone());
        existingLearner.setdateofbirth(learnerDetails.getdateofbirth());
        existingLearner.setemail(learnerDetails.getemail());
        existingLearner.setregistereddate(learnerDetails.getregistereddate());
        existingLearner.setlocation(learnerDetails.getlocation());
        existingLearner.setbatchids(learnerDetails.getbatchids());
        existingLearner.setalternatephone(learnerDetails.getalternatephone());
        existingLearner.setdescription(learnerDetails.getdescription());
        existingLearner.setexchangerate(learnerDetails.getexchangerate());
        existingLearner.setsource(learnerDetails.getsource());
        existingLearner.setattendeddemo(learnerDetails.getattendeddemo());
        existingLearner.setlearnerowner(learnerDetails.getlearnerowner());
        existingLearner.setlearnerstage(learnerDetails.getlearnerstage());
        existingLearner.setcurrency(learnerDetails.getcurrency());
        existingLearner.setleadcreatedtime(learnerDetails.getleadcreatedtime());
        existingLearner.setcounsellingdoneby(learnerDetails.getcounsellingdoneby());
        existingLearner.setregisteredcourse(learnerDetails.getregisteredcourse());
        existingLearner.setpreferabletime(learnerDetails.getpreferabletime());
        existingLearner.settechstack(learnerDetails.gettechstack());
        existingLearner.setbatchtiming(learnerDetails.getbatchtiming());
        existingLearner.setcoursecomments(learnerDetails.getcoursecomments());
        existingLearner.setmodeofclass(learnerDetails.getmodeofclass());
        existingLearner.setslackaccess(learnerDetails.getslackaccess());
        existingLearner.setcomment(learnerDetails.getcomment());
        existingLearner.setlmsaccess(learnerDetails.getlmsaccess());

        return learnerRepository.save(existingLearner);
    }

    @Transactional // Ensure the delete method has this annotation
    public void deleteLearner(Long id) {
        if (!learnerRepository.existsById(id)) {
            throw new IllegalArgumentException("Learner not found");
        }
        learnerRepository.deleteById(id);
    }

    // Removed methods related to finding and deleting learners by lead ID
    // public List<Learner> findByLeadId(Long leadId) { ... }
    // public void deleteByLeadId(Long leadId) { ... }

    public Learner convertLeadToLearner(/* parameters */) {
        // Implementation not provided
        return null;
    }

    public static List<?> getAllLeads() {
        // Implementation not provided
        return null;
    }
}
