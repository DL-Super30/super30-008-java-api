package dto.com;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LearnerDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("idproof")
    private String idproof;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("dateofbirth")
    private String dateofbirth;

    @JsonProperty("email")
    private String email;

    @JsonProperty("registereddate")
    private String registereddate;

    @JsonProperty("location")
    private String location;

    @JsonProperty("batchids")
    private String batchids;

    @JsonProperty("alternatephone")
    private String alternatephone;

    @JsonProperty("description")
    private String description;

    @JsonProperty("exchangerate")
    private String exchangerate;

    @JsonProperty("source")
    private String source;

    @JsonProperty("attendeddemo")
    private String attendeddemo;

    @JsonProperty("learnerowner")
    private String learnerowner;

    @JsonProperty("learnerstage")
    private String learnerstage;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("batches")
    private String batches;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
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

    public String getBatches() {
        return batches;
    }

    public void setBatches(String batches) {
        this.batches = batches;
    }
}
