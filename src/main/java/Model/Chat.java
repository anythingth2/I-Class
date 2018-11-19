package Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Chat {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Message> messages;

    @OneToOne
    private Course course;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

}
