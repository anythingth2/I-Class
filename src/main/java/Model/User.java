package Model;


import Main.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User extends Model {
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


    public static User findByUserID(String userid){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(User.class);
            User user = (User) criteria.add(Restrictions.eq("userid", userid)).uniqueResult();
            return user;
        } catch (Exception e) {
            return null;
        }
    }







}
