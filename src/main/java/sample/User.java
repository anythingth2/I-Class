package sample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class User {
    @Id
    Integer userId;


    String name;

}
