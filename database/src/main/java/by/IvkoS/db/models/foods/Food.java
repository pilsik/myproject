package by.IvkoS.db.models.foods;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="food")
public abstract class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private double price;
    @Column
    private String description;
    @Column
    private String name;
    @Column
    private String producer;
    @Column
    private byte[] image;
    @Column
    private double weight;
}
