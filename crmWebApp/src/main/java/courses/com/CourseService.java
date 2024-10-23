package courses.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository; // Inject the repository

    // Retrieve all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll(); // Fetch all courses from the database
    }

    // Retrieve a course by its ID
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id); // Fetch a course by ID from the database
    }

    // Create a new course
    public Course createCourse(Course course) {
        return courseRepository.save(course); // Save the course to the database
    }

    // Update an existing course
    public Course updateCourse(Long id, Course courseDetails) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id)); // Fetch the course

        // Update course fields
        course.setCourseName(courseDetails.getCourseName());
        course.setCourseFee(courseDetails.getCourseFee());
        course.setDescription(courseDetails.getDescription());
        course.setCourseImage(courseDetails.getCourseImage());
        course.setCourseBrochure(courseDetails.getCourseBrochure());

        return courseRepository.save(course); // Save the updated course to the database
    }

    // Delete a course by its ID
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id)); // Fetch the course
        courseRepository.delete(course); // Delete the course from the database
    }
}
