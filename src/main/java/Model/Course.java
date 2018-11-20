package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course extends Model{
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String alias;
    private String codenumber;
    private String description;
    private String announcement;

//    @ManyToOne
//    @JoinColumn(columnDefinition="integer",nullable = true)
//    private Teacher user;
//
//    @ManyToOne
//    @JoinColumn(columnDefinition="integer",nullable = true)
//    private Student student;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TeachingClass> teachingClasses;

    @OneToOne
    private Chat chat;

    public Course() {
    }

    public Course(String name, String alias, String codenumber, String description, String announcement) {
        this.name = name;
        this.alias = alias;
        this.codenumber = codenumber;
        this.description = description;
        this.announcement = announcement;
    }

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
