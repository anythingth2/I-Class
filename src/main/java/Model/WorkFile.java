package Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
public class WorkFile {
    String filePath;
    Student owner;
    Date submitDate;
}