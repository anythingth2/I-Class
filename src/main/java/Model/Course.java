package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String alias;
    private String codenumber;
    private String description;
    private String announcement;
    private List<TeachingClass> teachingClasses;

    private Chat chat;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCodenumber() {
        return this.codenumber;
    }

    public void setCodenumber(String codenumber) {
        this.codenumber = codenumber;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TeachingClass> getTeachingClasses() {
        return this.teachingClasses;
    }

    public void setTeachingClasses(List<TeachingClass> teachingClasses) {
        this.teachingClasses = teachingClasses;
    }

    public String getAnnouncement() {
        return this.announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public Course(List<TeachingClass> teachingClasses) {
        this.teachingClasses = teachingClasses;
    }

    public Course(String name, String alias, String codenumber, String description, String announcement, List<TeachingClass> teachingClasses) {
        this.name = name;
        this.alias = alias;
        this.codenumber = codenumber;
        this.description = description;
        this.announcement = announcement;
        this.teachingClasses = teachingClasses;
    }

}
