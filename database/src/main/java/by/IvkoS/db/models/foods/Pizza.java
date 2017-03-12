package by.IvkoS.db.models.foods;

import javax.persistence.*;

@Entity
@Table(name = "Pizza")
public class Pizza extends Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column
    private int size;

    @Column
    private String box;


}
