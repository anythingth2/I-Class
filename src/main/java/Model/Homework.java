package Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Homework extends Model{
    @Id
    @GeneratedValue
    private int id;
    String filePath;
    @OneToOne
    Student owner;
    Date submitDate;
}