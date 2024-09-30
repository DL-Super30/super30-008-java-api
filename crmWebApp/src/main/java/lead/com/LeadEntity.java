package lead.com;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
;

@Entity
@Table(name = "lead")

public class LeadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
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

    @Column(name = "lead_status")
    @JsonProperty("Lead Status")
    private String leadStatus;
    
    @Column(name = "lead_source")
    @JsonProperty("Lead Source")
    private String leadSource;

    @Column(name = "stack")
    @JsonProperty("Stack")
    private String stack;

    @Column(name = "course")
    @JsonProperty("Course")
    private String course;

    @Column(name = "class_mode")
    @JsonProperty("Class Mode")
    private String classMode;
    
    @Column(name = "next_follow_up")
    @JsonProperty("Next FollowUp")
    private String nextFollowUp;

    @Column(name = "description")
    @JsonProperty("Description")
    private String description;
    
    @Column(name = "batchtiming")
    @JsonProperty("Batch Timing")
    private String batchtiming;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getClassMode() {
        return classMode;
    }

    public void setClassMode(String classMode) {
        this.classMode = classMode;
    }

    public String getNextFollowUp() {
        return nextFollowUp;
    }

    public void setNextFollowUp(String nextFollowUp) {
        this.nextFollowUp = nextFollowUp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//	public String getbatchtiming() {
	//	return batchtiming;
	//}

	//public void setbatchTiming(String batchtiming) {
	//	this.batchtiming = batchtiming;
	//}

	//public void setbatchtiming(String getbatchtiming) {
		
		
	//}


    public String getbatchtiming() {
        return batchtiming;
    }

    public void setbatchtiming(String batchtiming) {
        this.batchtiming = batchtiming;
    }
		
	}

	

