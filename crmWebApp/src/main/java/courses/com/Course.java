package courses.com;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
    
    @Column(name = "course_image")
    @JsonProperty("Course Image")
    private String courseImage;
    
    @Column(name = "coursebrochure")
    @JsonProperty("Course Brochure")
    private String coursebrochure; 

    // Constructors
    public Course() {}

    public Course(String courseName, String courseFee, String description, String courseImage, String coursebrochure) {
        this.courseName = courseName;
        this.courseFee = courseFee;
        this.description = description;
        this.courseImage = courseImage;
        this.coursebrochure = coursebrochure;
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

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public String getcoursebrochure() {
        return coursebrochure;
    }

    public void setCoursebrochure(String coursebrochure) {
        this.coursebrochure = coursebrochure;
    }

	
}
