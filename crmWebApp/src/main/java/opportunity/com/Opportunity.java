package opportunity.com;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "opportunities")
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name")
    @JsonProperty("Name") 
    private String name;
    
    @Column(name = "cc")
    @JsonProperty("CC") 
    private String cc;
    
    @Column(name = "phone")
    @JsonProperty("Phone") 
    private String phone;
    
    @Column(name = "email")
    @JsonProperty("Email") 
    private String email;
    
    @Column(name = "fee_quoted")
    @JsonProperty("Fee Quoted") 
    private String feeQuoted;
    
    @Column(name = "opportunity_status")
    @JsonProperty("Opportunity Status") 
    private String opportunityStatus;
    
    @Column(name = "opportunity_stage")
    @JsonProperty("Opportunity Stage") 
    private String opportunityStage;
    
    @Column(name = "visited_stage")
    @JsonProperty("Visited Stage") 
    private String visitedStage;
    
    @Column(name = "lost_opportunity_reason")
    @JsonProperty("Lost Opportunity Reason") 
    private String lostOpportunityReason;
    
    @Column(name = "next_follow_up")
    @JsonProperty("Next FollowUp") 
    private String nextFollowUp;
    
    @Column(name = "lead_status")
    @JsonProperty("Lead Status")
    private String leadStatus;
    
    @Column(name = "lead_source")
    @JsonProperty("Lead Source")
    private String leadSource;
    
    @Column(name = "course")
    @JsonProperty("Course")
    private String course;
    
    @Column(name = "description")
    @JsonProperty("Description")
    private String description;
    
    @Column(name = "classmode")
    @JsonProperty("Class Mode")
    private String classmode;
    
    @Column(name = "demoattendedstage")
    @JsonProperty("Demo Attended Stage")
    private String demoattendedstage;
    
    @Column(name = "stack")
    @JsonProperty("Stack")
    private String stack;
    
    @Column(name = "batchtiming")
    @JsonProperty("Batch Timing")
    private String batchtiming;

    // Getters and setters
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

    public String getFeeQuoted() {
        return feeQuoted;
    }

    public void setFeeQuoted(String feeQuoted) {
        this.feeQuoted = feeQuoted;
    }

    public String getOpportunityStatus() {
        return opportunityStatus;
    }

    public void setOpportunityStatus(String opportunityStatus) {
        this.opportunityStatus = opportunityStatus;
    }

    public String getOpportunityStage() {
        return opportunityStage;
    }

    public void setOpportunityStage(String opportunityStage) {
        this.opportunityStage = opportunityStage;
    }

    public String getVisitedStage() {
        return visitedStage;
    }

    public void setVisitedStage(String visitedStage) {
        this.visitedStage = visitedStage;
    }

    public String getLostOpportunityReason() {
        return lostOpportunityReason;
    }

    public void setLostOpportunityReason(String lostOpportunityReason) {
        this.lostOpportunityReason = lostOpportunityReason;
    }

    public String getNextFollowUp() {
        return nextFollowUp;
    }

    public void setNextFollowUp(String nextFollowUp) {
        this.nextFollowUp = nextFollowUp;
    }

    public String getLeadStatus() {
        return leadStatus;
    }

    public void setLeadStatus(String leadStatus) {
        this.leadStatus = leadStatus;
    }

    public String getLeadSource() {
        return leadSource;
    }

    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
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

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public String getbatchtiming() {
        return batchtiming;
    }

    public void setbatchtiming(String batchtiming) {
        this.batchtiming = batchtiming;
    }

    public String getdemoattendedstage() {
        return demoattendedstage;
    }

    public void setdemoattendedstage(String demoattendedstage) {
        this.demoattendedstage = demoattendedstage;
    }
}
