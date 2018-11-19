package Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Homework {
    @Id
    @GeneratedValue
    private int id;
    String filePath;
    @OneToOne
    Student owner;
    Date submitDate;
}