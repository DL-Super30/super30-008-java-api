package learners.com;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "learners")
public class Learner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required")
    @Size(min = 2, message = "First name should have at least 2 characters")
    @Column(name = "firstname")
    @JsonProperty("First Name")
    private String firstname;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, message = "Last name should have at least 2 characters")
    @Column(name = "lastname")
    @JsonProperty("Last Name")
    private String lastname;

    @Column(name = "idproof")
    @JsonProperty("Id Proof")
    private String idproof; 

    @NotBlank(message = "Phone number is required")
    @Column(name = "phone")
    @JsonProperty("Phone")
    private String phone;

    @Column(name = "dateofbirth")
    @JsonProperty("Date of Birth")
    private String dateofbirth;

    @NotBlank(message = "Email is required")
    @Column(name = "email")
    @JsonProperty("Email")
    private String email;

    @Column(name = "registereddate")
    @JsonProperty("Registered Date")
    private String registereddate;

    @Column(name = "location")
    @JsonProperty("Location")
    private String location;

    @Column(name = "batchids")
    @JsonProperty("Batch ID's")
    private String batchids; 

    @Column(name = "alternatephone")
    @JsonProperty("Alternate Phone")
    private String alternatephone;

    @Column(name = "description")
    @JsonProperty("Description")
    private String description;

    @Column(name = "exchangerate")
    @JsonProperty("Exchange Rate")
    private String exchangerate;

    @Column(name = "source")
    @JsonProperty("Source")
    private String source;

    @Column(name = "attendeddemo")
    @JsonProperty("Attended Demo")
    private String attendeddemo;

    @Column(name = "learnerowner")
    @JsonProperty("Learner Owner")
    private String learnerowner; 

    @Column(name = "learnerstage")
    @JsonProperty("Learner Stage")
    private String learnerstage;

    @Column(name = "currency")
    @JsonProperty("Currency")
    private String currency;

    @Column(name = "leadcreatedtime")
    @JsonProperty("Lead Created Time")
    private String leadcreatedtime;

    @Column(name = "counsellingdoneby")
    @JsonProperty("Counseling Done By")
    private String counsellingdoneby;

    @Column(name = "registeredcourse")
    @JsonProperty("Registered Course")
    private String registeredcourse;

    @Column(name = "preferabletime")
    @JsonProperty("Preferable Time")
    private String preferabletime;

    @Column(name = "techstack")
    @JsonProperty("Tech Stack")
    private String techstack;

    @Column(name = "batchtiming")
    @JsonProperty("Batch Timing")
    private String batchtiming;

    @Column(name = "coursecomments")
    @JsonProperty("Course Comments")
    private String coursecomments;

    @Column(name = "modeofclass")
    @JsonProperty("Mode Of Class")
    private String modeofclass;

    @Column(name = "slackaccess")
    @JsonProperty("Slack Access")
    private String slackaccess;

    @Column(name = "comment")
    @JsonProperty("Comment")
    private String comment;

    @Column(name = "lmsaccess")
    @JsonProperty("LMS Access")
    private String lmsaccess;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfirstname() {
        return firstname;
    }

    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getlastname() {
        return lastname;
    }

    public void setlastname(String lastname) {
        this.lastname = lastname;
    }

    public String getIdproof() {
        return idproof;
    }

    public void setIdproof(String idproof) {
        this.idproof = idproof;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistereddate() {
        return registereddate;
    }

    public void setRegistereddate(String registereddate) {
        this.registereddate = registereddate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBatchids() {
        return batchids;
    }

    public void setBatchids(String batchids) {
        this.batchids = batchids;
    }

    public String getAlternatephone() {
        return alternatephone;
    }

    public void setAlternatephone(String alternatephone) {
        this.alternatephone = alternatephone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExchangerate() {
        return exchangerate;
    }

    public void setExchangerate(String exchangerate) {
        this.exchangerate = exchangerate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAttendeddemo() {
        return attendeddemo;
    }

    public void setAttendeddemo(String attendeddemo) {
        this.attendeddemo = attendeddemo;
    }

    public String getLearnerowner() {
        return learnerowner;
    }

    public void setLearnerowner(String learnerowner) {
        this.learnerowner = learnerowner;
    }

    public String getLearnerstage() {
        return learnerstage;
    }

    public void setLearnerstage(String learnerstage) {
        this.learnerstage = learnerstage;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLeadcreatedtime() {
        return leadcreatedtime;
    }

    public void setLeadcreatedtime(String leadcreatedtime) {
        this.leadcreatedtime = leadcreatedtime;
    }

    public String getCounsellingdoneby() {
        return counsellingdoneby;
    }

    public void setCounsellingdoneby(String counsellingdoneby) {
        this.counsellingdoneby = counsellingdoneby;
    }

    public String getRegisteredcourse() {
        return registeredcourse;
    }

    public void setRegisteredcourse(String registeredcourse) {
        this.registeredcourse = registeredcourse;
    }

    public String getPreferabletime() {
        return preferabletime;
    }

    public void setPreferabletime(String preferabletime) {
        this.preferabletime = preferabletime;
    }

    public String getTechstack() {
        return techstack;
    }

    public void setTechstack(String techstack) {
        this.techstack = techstack;
    }

    public String getBatchtiming() {
        return batchtiming;
    }

    public void setBatchtiming(String batchtiming) {
        this.batchtiming = batchtiming;
    }

    public String getCoursecomments() {
        return coursecomments;
    }

    public void setCoursecomments(String coursecomments) {
        this.coursecomments = coursecomments;
    }

    public String getModeofclass() {
        return modeofclass;
    }

    public void setModeofclass(String modeofclass) {
        this.modeofclass = modeofclass;
    }

    public String getSlackaccess() {
        return slackaccess;
    }

    public void setSlackaccess(String slackaccess) {
        this.slackaccess = slackaccess;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLmsaccess() {
        return lmsaccess;
    }

    public void setLmsaccess(String lmsaccess) {
        this.lmsaccess = lmsaccess;
    }
}
