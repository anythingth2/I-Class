package Model;

import java.util.List;

public class Chat {
    private List<Message> messages;
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
