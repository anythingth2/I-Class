package Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Homework extends Model {
    @Id
    @GeneratedValue
    private int id;
    String filePath;
    @OneToOne
    Student owner;
    Date submitDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Student getOwner() {
        return owner;
    }

    public void setOwner(Student owner) {
        this.owner = owner;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Homework(String filePath, Student student) {
        this.filePath = filePath;
        this.owner = student;
        this.submitDate = new Date(System.currentTimeMillis());
    }
}