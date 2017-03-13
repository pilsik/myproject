package by.IvkoS.db.entity.order;

import by.IvkoS.db.entity.foods.Food;

import javax.persistence.*;
import java.util.HashSet;

import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @OneToMany
    private Set<Food> foodSet = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_ID")
    private int id;

    @Column(name = "order_description")
    private String descriptionOrder;

    public Order() {
    }

    public Order(Set<Food> foodSet, String descriptionOrder) {
        this.foodSet = foodSet;
        this.descriptionOrder = descriptionOrder;
    }

    public Set<Food> getFoodSet() {
        return foodSet;
    }

    public void setFoodSet(Set<Food> foodSet) {
        this.foodSet = foodSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriptionOrder() {
        return descriptionOrder;
    }

    public void setDescriptionOrder(String descriptionOrder) {
        this.descriptionOrder = descriptionOrder;
    }

    public double getPrice() {
        double fullPrice = 0;
        for (Food food : foodSet) {
            fullPrice+=food.getPrice();
        }
        return fullPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "foodSet=" + foodSet +
                ", id=" + id +
                ", descriptionOrder='" + descriptionOrder + '\'' +
                '}';
    }
}
