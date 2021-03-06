package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class AssignmentMaterial extends Material {

    private Date startDate;
    private Date dueDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Homework> homework;

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }


    public List<Homework> getHomework() {
        return this.homework;
    }

    public void setHomework(List<Homework> homework) {
        this.homework = homework;
    }


    public AssignmentMaterial() {
    }
    public AssignmentMaterial(Date startDate, Date dueDate) {
        this.startDate = startDate;
        this.dueDate = dueDate;
    }
    public AssignmentMaterial(TeachingClass teachingClass) {
        super(teachingClass);
    }

    public void addHomework(Homework homework) {
        if (this.homework == null) this.homework = new ArrayList<>();
        this.homework.add(homework);
    }

    public boolean isSubmitted(Student student) {
        for (Homework homework : this.homework) {
            if (homework.owner.equals(student))
                return true;
        }
        return false;
    }






}