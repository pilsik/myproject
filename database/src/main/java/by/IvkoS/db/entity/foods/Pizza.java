package by.IvkoS.db.entity.foods;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Pizza")
public class Pizza extends Food {

    @Column
    private int size;

    @Column
    private String box;


    public Pizza() {
    }

    public Pizza(double price, String description, String name, String producer, byte[] image, double weight, int size, String box) {
        super(price, description, name, producer, image, weight);
        this.size = size;
        this.box = box;
    }
}
