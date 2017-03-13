package by.IvkoS.db.entity.foods;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Drink")
public class Drink extends Food {

    @Column
    private Boolean alcohol;

    public Drink(double price, String description, String name, String producer, byte[] image, double weight, Boolean alcohol) {
        super(price, description, name, producer, image, weight);
        this.alcohol = alcohol;
    }

    public Drink() {
    }
}
