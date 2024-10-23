package learners.com;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "learners")
public class Learner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonProperty("first name")
    @Column(name = "firstname")
    private String firstname;

    @JsonProperty("last name")
    @Column(name = "lastname")
    private String lastname;

    @JsonProperty("id proof")
    @Column(name = "idproof")
    private String idproof;

    @JsonProperty("phone")
    @Column(name = "phone")
    private String phone;

    @JsonProperty("date of birth")
    @Column(name = "dateofbirth")
    private String dateofbirth;

    @JsonProperty("email")
    @Column(name = "email")
    private String email;

    @JsonProperty("registered date")
    @Column(name = "registereddate")
    private String registereddate;

    @JsonProperty("location")
    @Column(name = "location")
    private String location;

    @JsonProperty("batch ids")
    @Column(name = "batchids")
    private String batchids;

    @JsonProperty("alternate phone")
    @Column(name = "alternatephone")
    private String alternatephone;

    @JsonProperty("description")
    @Column(name = "description")
    private String description;

    @JsonProperty("exchange rate")
    @Column(name = "exchangerate")
    private String exchangerate;

    @JsonProperty("source")
    @Column(name = "source")
    private String source;

    @JsonProperty("attended demo")
    @Column(name = "attendeddemo")
    private String attendeddemo;

    @JsonProperty("learner owner")
    @Column(name = "learnerowner")
    private String learnerowner;

    @JsonProperty("learner stage")
    @Column(name = "learnerstage")
    private String learnerstage;

    @JsonProperty("currency")
    @Column(name = "currency")
    private String currency;

    @JsonProperty("lead created time")
    @Column(name = "leadcreatedtime")
    private String leadcreatedtime;

    @JsonProperty("counselling done by")
    @Column(name = "counsellingdoneby")
    private String counsellingdoneby;

    @JsonProperty("registered course")
    @Column(name = "registeredcourse")
    private String registeredcourse;

    @JsonProperty("preferable time")
    @Column(name = "preferabletime")
    private String preferabletime;

    @JsonProperty("tech stack")
    @Column(name = "techstack")
    private String techstack;

    @JsonProperty("batch timing")
    @Column(name = "batchtiming")
    private String batchtiming;

    @JsonProperty("course comments")
    @Column(name = "coursecomments")
    private String coursecomments;

    @JsonProperty("mode of class")
    @Column(name = "modeofclass")
    private String modeofclass;

    @JsonProperty("slack access")
    @Column(name = "slackaccess")
    private String slackaccess;

    @JsonProperty("comment")
    @Column(name = "comment")
    private String comment;

    @JsonProperty("lms access")
    @Column(name = "lmsaccess")
    private String lmsaccess;

    // Getters and Setters
    public Long getid() {
        return id;
    }

    public void setid(Long id) {
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

    public String getidproof() {
        return idproof;
    }

    public void setidproof(String idproof) {
        this.idproof = idproof;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public String getdateofbirth() {
        return dateofbirth;
    }

    public void setdateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getregistereddate() {
        return registereddate;
    }

    public void setregistereddate(String registereddate) {
        this.registereddate = registereddate;
    }

    public String getlocation() {
        return location;
    }

    public void setlocation(String location) {
        this.location = location;
    }

    public String getbatchids() {
        return batchids;
    }

    public void setbatchids(String batchids) {
        this.batchids = batchids;
    }

    public String getalternatephone() {
        return alternatephone;
    }

    public void setalternatephone(String alternatephone) {
        this.alternatephone = alternatephone;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public String getexchangerate() {
        return exchangerate;
    }

    public void setexchangerate(String exchangerate) {
        this.exchangerate = exchangerate;
    }

    public String getsource() {
        return source;
    }

    public void setsource(String source) {
        this.source = source;
    }

    public String getattendeddemo() {
        return attendeddemo;
    }

    public void setattendeddemo(String attendeddemo) {
        this.attendeddemo = attendeddemo;
    }

    public String getlearnerowner() {
        return learnerowner;
    }

    public void setlearnerowner(String learnerowner) {
        this.learnerowner = learnerowner;
    }

    public String getlearnerstage() {
        return learnerstage;
    }

    public void setlearnerstage(String learnerstage) {
        this.learnerstage = learnerstage;
    }

    public String getcurrency() {
        return currency;
    }

    public void setcurrency(String currency) {
        this.currency = currency;
    }

    public String getleadcreatedtime() {
        return leadcreatedtime;
    }

    public void setleadcreatedtime(String leadcreatedtime) {
        this.leadcreatedtime = leadcreatedtime;
    }

    public String getcounsellingdoneby() {
        return counsellingdoneby;
    }

    public void setcounsellingdoneby(String counsellingdoneby) {
        this.counsellingdoneby = counsellingdoneby;
    }

    public String getregisteredcourse() {
        return registeredcourse;
    }

    public void setregisteredcourse(String registeredcourse) {
        this.registeredcourse = registeredcourse;
    }

    public String getpreferabletime() {
        return preferabletime;
    }

    public void setpreferabletime(String preferabletime) {
        this.preferabletime = preferabletime;
    }

    public String gettechstack() {
        return techstack;
    }

    public void settechstack(String techstack) {
        this.techstack = techstack;
    }

    public String getbatchtiming() {
        return batchtiming;
    }

    public void setbatchtiming(String batchtiming) {
        this.batchtiming = batchtiming;
    }

    public String getcoursecomments() {
        return coursecomments;
    }

    public void setcoursecomments(String coursecomments) {
        this.coursecomments = coursecomments;
    }

    public String getmodeofclass() {
        return modeofclass;
    }

    public void setmodeofclass(String modeofclass) {
        this.modeofclass = modeofclass;
    }

    public String getslackaccess() {
        return slackaccess;
    }

    public void setslackaccess(String slackaccess) {
        this.slackaccess = slackaccess;
    }

    public String getcomment() {
        return comment;
    }

    public void setcomment(String comment) {
        this.comment = comment;
    }

    public String getlmsaccess() {
        return lmsaccess;
    }

    public void setlmsaccess(String lmsaccess) {
        this.lmsaccess = lmsaccess;
    }
}
