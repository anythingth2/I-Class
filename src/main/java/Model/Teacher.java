package Model;

import Main.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.*;
import java.util.List;
@Entity
public class Teacher extends User {

    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(columnDefinition="integer",nullable = true)
    private List<Course> ownCourses;

    public Teacher() {
    }

    public Teacher(String fullName) {
        super(fullName);
    }

    public Teacher(String fullName, List<Course> ownCourses) {
        super(fullName);
        this.ownCourses = ownCourses;
    }

    public Teacher(String fullName, String userid, String pin, List<Course> ownCourses) {
        super(fullName, userid, pin);
        this.ownCourses = ownCourses;
    }


    @Override
    public List<Course> getUserCourse() {
        return this.ownCourses;
    }

    public List<Course> getOwnCourses() {
        return this.ownCourses;
    }

    public void setOwnCourses(List<Course> ownCourses) {
        this.ownCourses = ownCourses;
    }


    // Begin ORM methods
    public static User findByUserID(String userid){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Teacher.class);
            User user = (Teacher) criteria.add(Restrictions.eq("userid", userid)).uniqueResult();

        } catch (Exception e) {
            return null;
        }

        return null;
    }
}
