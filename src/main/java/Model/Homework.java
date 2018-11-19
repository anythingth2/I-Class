package Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
public class Homework {
    String filePath;
    Student owner;
    Date submitDate;
}