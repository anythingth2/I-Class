package Model;


import javax.persistence.*;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {

    @Id
    @GeneratedValue

    int id;
    String fullName;
    String pin;

    public User() {
    }

    public User(String fullName) {
        this.fullName = fullName;
    }
}
