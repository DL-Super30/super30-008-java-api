package courses.com;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "course_name")
    @JsonProperty("Course Name")
    private String courseName;

    @Column(name = "course_fee")
    @JsonProperty("Course Fee")
    private String courseFee;

    @Column(name = "description")
    @JsonProperty("Description")
    private String description;

    // Using byte[] to store image data
    @Lob
    @Column(name = "course_image", columnDefinition = "BLOB")
    @JsonProperty("Course Image")
    private byte[] courseImage;

    // Using byte[] to store brochure data
    @Lob
    @Column(name = "coursebrochure", columnDefinition = "BLOB")
    @JsonProperty("Course Brochure")
    private byte[] courseBrochure;

    // Default Constructor
    public Course() {}

    // Parameterized Constructor
    public Course(String courseName, String courseFee, String description, byte[] courseImage, byte[] courseBrochure) {
        this.courseName = courseName;
        this.courseFee = courseFee;
        this.description = description;
        this.courseImage = courseImage;
        this.courseBrochure = courseBrochure;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(String courseFee) {
        this.courseFee = courseFee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(byte[] courseImage) {
        this.courseImage = courseImage;
    }

    public byte[] getCourseBrochure() {
        return courseBrochure;
    }

    public void setCourseBrochure(byte[] courseBrochure) {
        this.courseBrochure = courseBrochure;
    }
}
