package swa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Vetoed;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PizzaOrder")
@Vetoed
@Cacheable
public class Bestellung {
    @Id
    @SequenceGenerator(name = "pizzaOrderSeq", sequenceName = "pizzaOrder_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "pizzaOrderSeq")
    private int id;
    private boolean ordered;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Bestellposten> orderItems;

    public Bestellung() {
        this.ordered = false;
        this.orderItems = new ArrayList<Bestellposten>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    public List<Bestellposten> getOrderItems() {
        return orderItems;
    }

    public void addOrderItem(Bestellposten orderItem) {
        if (orderItem != null)
            this.orderItems.add(orderItem);
    }

    public Bestellposten searchItemInOrder(int itemId) {
        for (Bestellposten orderItem : orderItems) {
            if (orderItem.getId() == itemId) {
                return orderItem;
            }
        }
        return null;
    }

    public void removeOrderItem(Bestellposten orderItem) {
        if (orderItem != null)
            this.orderItems.remove(orderItem);
    }

}
