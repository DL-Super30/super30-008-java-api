package dto.com;



import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LeadDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("cc")
    private String cc;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("email")
    private String email;

    @JsonProperty("feequoted")
    private String feequoted;

    @JsonProperty("leadstatus")
    private String leadstatus;

    @JsonProperty("leadsource")
    private String leadsource;

    @JsonProperty("stack")
    private String stack;

    @JsonProperty("course")
    private String course;

    @JsonProperty("classmode")
    private String classmode;

    @JsonProperty("nextfollowup")
    private String nextfollowup;

    @JsonProperty("description")
    private String description;

    @JsonProperty("batchtiming")
    private String batchtiming;

    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeequoted() {
        return feequoted;
    }

    public void setFeequoted(String feequoted) {
        this.feequoted = feequoted;
    }

    public String getLeadstatus() {
        return leadstatus;
    }

    public void setLeadstatus(String leadstatus) {
        this.leadstatus = leadstatus;
    }

    public String getLeadsource() {
        return leadsource;
    }

    public void setLeadsource(String leadsource) {
        this.leadsource = leadsource;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getClassmode() {
        return classmode;
    }

    public void setClassmode(String classmode) {
        this.classmode = classmode;
    }

    public String getNextfollowup() {
        return nextfollowup;
    }

    public void setNextfollowup(String nextfollowup) {
        this.nextfollowup = nextfollowup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBatchtiming() {
        return batchtiming;
    }

    public void setBatchtiming(String batchtiming) {
        this.batchtiming = batchtiming;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
