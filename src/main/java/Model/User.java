package Model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String fullName;
    private String userid;
    private String pin;

    public User() { }

    public User(String fullName) {
        this.fullName = fullName;
    }

    public User(String fullName, String userid, String pin) {
        this.fullName = fullName;
        this.userid = userid;
        this.pin = pin;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public List<Course> getUserCourse(){
        return null;
    }


}
