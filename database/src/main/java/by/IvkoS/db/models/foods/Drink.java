package by.IvkoS.db.models.foods;

import javax.persistence.*;

@Entity
@Table(name = "drink")
public class Drink extends Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Boolean alcohol;

}
