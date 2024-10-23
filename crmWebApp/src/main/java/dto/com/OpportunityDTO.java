package dto.com;



import com.fasterxml.jackson.annotation.JsonProperty;
//import java.time.LocalDateTime;

public class OpportunityDTO {

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

    @JsonProperty("opportunitystatus")
    private String opportunitystatus;

    @JsonProperty("opportunitystage")
    private String opportunitystage;

    @JsonProperty("visitedstage")
    private String visitedstage;

    @JsonProperty("lostopportunityreason")
    private String lostopportunityreason;

    @JsonProperty("nextfollowup")
    private String nextfollowup;

    @JsonProperty("leadstatus")
    private String leadstatus;

    @JsonProperty("leadsource")
    private String leadsource;

    @JsonProperty("course")
    private String course;

    @JsonProperty("description")
    private String description;

    @JsonProperty("classmode")
    private String classmode;

    @JsonProperty("demoattendedstage")
    private String demoattendedstage;

    @JsonProperty("batchtiming")
    private String batchtiming;

    @JsonProperty("stack")
    private String stack;

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

    public String getOpportunitystatus() {
        return opportunitystatus;
    }

    public void setOpportunitystatus(String opportunitystatus) {
        this.opportunitystatus = opportunitystatus;
    }

    public String getOpportunitystage() {
        return opportunitystage;
    }

    public void setOpportunitystage(String opportunitystage) {
        this.opportunitystage = opportunitystage;
    }

    public String getVisitedstage() {
        return visitedstage;
    }

    public void setVisitedstage(String visitedstage) {
        this.visitedstage = visitedstage;
    }

    public String getLostopportunityreason() {
        return lostopportunityreason;
    }

    public void setLostopportunityreason(String lostopportunityreason) {
        this.lostopportunityreason = lostopportunityreason;
    }

    public String getNextfollowup() {
        return nextfollowup;
    }

    public void setNextfollowup(String string) {
        this.nextfollowup = string;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClassmode() {
        return classmode;
    }

    public void setClassmode(String classmode) {
        this.classmode = classmode;
    }

    public String getDemoattendedstage() {
        return demoattendedstage;
    }

    public void setDemoattendedstage(String demoattendedstage) {
        this.demoattendedstage = demoattendedstage;
    }

    public String getBatchtiming() {
        return batchtiming;
    }

    public void setBatchtiming(String batchtiming) {
        this.batchtiming = batchtiming;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }
}
