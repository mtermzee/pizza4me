package swa.entity;

import javax.enterprise.inject.Vetoed;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
@Vetoed
@Cacheable
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

    public Kunde() {
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

    @Override
    public String toString() {
        return "Kunde [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address + "]";
    }

}
