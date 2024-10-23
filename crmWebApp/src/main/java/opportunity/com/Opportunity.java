package opportunity.com;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "opportunities")
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID of the opportunity

    private String name; // Opportunity name
    private String cc; // Client's contact number
    private String phone; // Opportunity contact number
    private String email; // Opportunity email
    private String feequoted; // Quoted fee for the opportunity
    private String opportunitystatus; // Status of the opportunity
    private String opportunitystage; // Current stage of the opportunity
    private String visitedstage; // Stage visited by the opportunity
    private String lostopportunityreason; // Reason for lost opportunity
    private LocalDateTime nextfollowup; // Date for the next follow-up
    private String leadstatus; // Status of the lead associated with the opportunity
    private String leadsource; // Source of the lead
    private String course; // Course associated with the opportunity
    private String description; // Description of the opportunity
    private String classmode; // Mode of the class
    private String demoattendedstage; // Stage of demo attendance
    private String batchtiming; // Timing for the batch
    private String stack; // Technology stack associated with the opportunity

    // No-argument constructor
    public Opportunity() {
        // Default constructor
    }

    // Getters and setters
    public Long getid() {
        return id; // Get opportunity ID
    }

    public void setid(Long id) {
        this.id = id; // Set opportunity ID
    }

    public String getname() {
        return name; // Get opportunity name
    }

    public void setname(String name) {
        this.name = name; // Set opportunity name
    }

    public String getcc() {
        return cc; // Get client's contact number
    }

    public void setcc(String cc) {
        this.cc = cc; // Set client's contact number
    }

    public String getphone() {
        return phone; // Get opportunity contact number
    }

    public void setphone(String phone) {
        this.phone = phone; // Set opportunity contact number
    }

    public String getemail() {
        return email; // Get opportunity email
    }

    public void setemail(String email) {
        this.email = email; // Set opportunity email
    }

    public String getfeequoted() {
        return feequoted; // Get quoted fee
    }

    public void setfeequoted(String feequoted) {
        this.feequoted = feequoted; // Set quoted fee
    }

    public String getopportunitystatus() {
        return opportunitystatus; // Get opportunity status
    }

    public void setopportunitystatus(String opportunitystatus) {
        this.opportunitystatus = opportunitystatus; // Set opportunity status
    }

    public String getopportunitystage() {
        return opportunitystage; // Get opportunity stage
    }

    public void setopportunitystage(String opportunitystage) {
        this.opportunitystage = opportunitystage; // Set opportunity stage
    }

    public String getvisitedstage() {
        return visitedstage; // Get visited stage
    }

    public void setvisitedstage(String visitedstage) {
        this.visitedstage = visitedstage; // Set visited stage
    }

    public String getlostopportunityreason() {
        return lostopportunityreason; // Get lost opportunity reason
    }

    public void setlostopportunityreason(String lostopportunityreason) {
        this.lostopportunityreason = lostopportunityreason; // Set lost opportunity reason
    }

    public LocalDateTime getnextfollowup() {
        return nextfollowup; // Get next follow-up date
    }

    public void setnextfollowup(LocalDateTime nextfollowup) {
        this.nextfollowup = nextfollowup; // Set next follow-up date
    }

    public String getleadstatus() {
        return leadstatus; // Get lead status
    }

    public void setleadstatus(String leadstatus) {
        this.leadstatus = leadstatus; // Set lead status
    }

    public String getleadsource() {
        return leadsource; // Get lead source
    }

    public void setleadsource(String leadsource) {
        this.leadsource = leadsource; // Set lead source
    }

    public String getcourse() {
        return course; // Get course
    }

    public void setcourse(String course) {
        this.course = course; // Set course
    }

    public String getdescription() {
        return description; // Get description
    }

    public void setdescription(String description) {
        this.description = description; // Set description
    }

    public String getclassmode() {
        return classmode; // Get class mode
    }

    public void setclassmode(String classmode) {
        this.classmode = classmode; // Set class mode
    }

    public String getdemoattendedstage() {
        return demoattendedstage; // Get demo attended stage
    }

    public void setdemoattendedstage(String demoattendedstage) {
        this.demoattendedstage = demoattendedstage; // Set demo attended stage
    }

    public String getbatchtiming() {
        return batchtiming; // Get batch timing
    }

    public void setbatchtiming(String batchtiming) {
        this.batchtiming = batchtiming; // Set batch timing
    }

    public String getstack() {
        return stack; // Get stack
    }

    public void setstack(String stack) {
        this.stack = stack; // Set stack
    }
}
