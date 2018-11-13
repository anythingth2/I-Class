package Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "homeworks")
public class Homework {
    private String title;

    private String description;

    private Date startDate;
    private Date dueDate;

    private Material material;
    private List<WorkFile> workFiles;

    private TeachingClass teachingClass;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public List<WorkFile> getWorkFiles() {
        return workFiles;
    }

    public void setWorkFiles(List<WorkFile> workFiles) {
        this.workFiles = workFiles;
    }

    public TeachingClass getTeachingClass() {
        return teachingClass;
    }

    public void setTeachingClass(TeachingClass teachingClass) {
        this.teachingClass = teachingClass;
    }

    public Homework(String title) {
        this.title = title;
    }

    public Homework(TeachingClass teachingClass) {
        this.teachingClass = teachingClass;
    }
}
