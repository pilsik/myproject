package by.IvkoS.db.entity.foods;

import by.IvkoS.db.entity.order.Order;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@Table(name = "food")
@DiscriminatorColumn(
        name="FOOD_TYPE",
        discriminatorType=DiscriminatorType.STRING
)
public abstract class Food implements Serializable {



    public Food() {
    }

    public Food(double price, String description, String name, String producer, byte[] image, double weight) {
        this.price = price;
        this.description = description;
        this.name = name;
        this.producer = producer;
        this.image = image;
        this.weight = weight;
    }

    public Food(double price, String description, String name, String producer, byte[] image, double weight, Order order) {
        this.price = price;
        this.description = description;
        this.name = name;
        this.producer = producer;
        this.image = image;
        this.weight = weight;
        this.order = order;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "idfood")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Order_ID", nullable = true) // Убрать на ложь
    private Order order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
