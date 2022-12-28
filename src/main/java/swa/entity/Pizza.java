package swa.entity;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Vetoed;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Pizza")
@Vetoed
@Cacheable
@Dependent
public class Pizza {
    @Id
    @SequenceGenerator(name = "pizzaSeq", sequenceName = "pizza_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "pizzaSeq")
    private int id;
    private String name;
    private String description;
    private double price;

    public Pizza() {
    }

    public Pizza(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pizza [name=" + name + ", description=" + description + ", price=" + price + "]";
    }

}
