package user.com;

import com.fasterxml.jackson.annotation.JsonProperty;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "login")
public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id", unique = true, nullable = false)
    @JsonProperty("id")
 
    private long id;

    @Column(name = "username", nullable = false)
    @JsonProperty("User Name")
  
    private String username;

    @Column(name = "password", nullable = false)
    @JsonProperty("Password")
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    @JsonProperty("Email")

    private String email;

    // No-argument constructor
    public User() {
    }

    // Getters and setters
    public Long getid() {
        return id;
    }

    public void setid(long currentId) {
        this.id = currentId;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

	

	
	
}
