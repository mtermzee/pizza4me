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
@Table(name = "Address", schema = "DATA")
@Vetoed
@Cacheable
@Dependent
public class Adresse {
    @Id
    @SequenceGenerator(name = "addressSeq", sequenceName = "address_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "addressSeq")
    private int id;
    private String zip;
    private String city;
    private String street;
    private String houseNumber;

    public Adresse() {
    }

    public Adresse(String zip, String city, String street, String houseNumber) {
        this.zip = zip;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "[zip=" + zip + ", city=" + city + ", street=" + street + ", houseNumber="
                + houseNumber + "]";
    }

}
