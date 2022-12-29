package swa.gateway;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import swa.control.KundenService;
import swa.entity.Adresse;
import swa.entity.Kunde;

@ApplicationScoped
@Transactional(value = TxType.REQUIRED)
public class KundenRepository implements KundenService {
    @Inject
    EntityManager em;

    @Override
    public Kunde getCustomer(int customerId) {
        return em.find(Kunde.class, customerId);
    }

    @Override
    public List<Kunde> getCustomers() {
        return em.createQuery("SELECT k FROM Kunde k", Kunde.class).getResultList();
    }

    @Override
    public Kunde addCustomer(String firstname, String lastname) {
        if (firstname != "" && lastname != "") {
            Kunde kunde = new Kunde(firstname, lastname, null);
            em.persist(kunde);
            return kunde;
        } else {
            return null;
        }
    }

    @Override
    public Kunde deleteCustomer(int id) {
        Kunde kunde = em.find(Kunde.class, id);
        if (kunde != null) {
            em.remove(kunde);
            return kunde;
        } else {
            return null;
        }
    }

    @Override
    public Adresse getAddress(int customerId) {
        Kunde customer = em.find(Kunde.class, customerId);
        if (customer != null) {
            return customer.getAddress();
        } else {
            return null;
        }
    }

    @Override
    public Adresse addAddress(int customerId, Adresse address) {
        Kunde customer = em.find(Kunde.class, customerId);
        if (customer != null) {
            customer.setAddress(address);
            em.persist(customer);
            return address;
        } else {
            return null;
        }
    }

    @Override
    public Adresse updateAddress(int customerId, Adresse address) {
        Kunde customer = em.find(Kunde.class, customerId);
        if (customer != null) {
            Adresse tempAdresse = customer.getAddress();
            if (tempAdresse != null) {
                if (address.getZip() != null)
                    tempAdresse.setZip(address.getZip());
                if (address.getCity() != null)
                    tempAdresse.setCity(address.getCity());
                if (address.getStreet() != null)
                    tempAdresse.setStreet(address.getStreet());
                if (address.getHouseNumber() != null)
                    tempAdresse.setHouseNumber(address.getHouseNumber());
                em.merge(tempAdresse);
                return tempAdresse;
            }
            return address;
        }
        return null;
    }

    @Override
    public Adresse deleteAddress(int customerId) {
        Kunde customer = em.find(Kunde.class, customerId);
        if (customer != null) {
            Adresse address = customer.getAddress();
            customer.setAddress(null);
            em.merge(customer);
            return address;
        } else {
            return null;
        }
    }

}
