package swa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Vetoed;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
@Vetoed
@Cacheable
@Dependent
public class Kunde {
    @Id
    @SequenceGenerator(name = "customerSeq", sequenceName = "customer_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "customerSeq")
    private int id;
    private String firstname;
    private String lastname;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Adresse address;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Bestellung> orders;

    public Kunde() {
        this.orders = new ArrayList<Bestellung>();
    }

    public Kunde(String firstname, String lastname, Adresse address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Adresse getAddress() {
        return address;
    }

    public void setAddress(Adresse address) {
        this.address = address;
    }

    public List<Bestellung> getOrders() {
        return orders;
    }

    public void addOrder(Bestellung order) {
        if (order != null)
            this.orders.add(order);
    }

    @Override
    public String toString() {
        return "[firstname=" + firstname + ", lastname=" + lastname + ", address=" + address
                + ", orders=" + orders + "]";
    }

}
