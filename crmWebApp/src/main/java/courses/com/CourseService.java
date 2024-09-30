package courses.com;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


class CourseNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CourseNotFoundException(Long id) {
        super("Course not found with id " + id);
    }
}

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Retrieve all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Retrieve a course by its ID
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    // Create a new course
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // Update an existing course
    public Course updateCourse(Long id, Course courseDetails) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));

        // Update course fields
        course.setCourseName(courseDetails.getCourseName());
        course.setCourseFee(courseDetails.getCourseFee());
        course.setDescription(courseDetails.getDescription());
        course.setCourseImage(courseDetails.getCourseImage());
        course.setCoursebrochure(courseDetails.getcoursebrochure());

        return courseRepository.save(course);
    }

    // Delete a course by its ID
    public void deleteCourse(Long id) {
        // Check if the course exists before deletion
        if (!courseRepository.existsById(id)) {
            throw new CourseNotFoundException(id);
        }
        courseRepository.deleteById(id);
    }
}
