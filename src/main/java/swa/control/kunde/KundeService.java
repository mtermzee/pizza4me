package swa.control.kunde;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import swa.control.bestellung.BestellungManagement;
import swa.entity.Adresse;
import swa.entity.Kunde;

@Singleton
public class KundeService {

    @Inject
    BestellungManagement bManagement;

    public Kunde getCustomer(int customerId) {
        return null;
    }

    public List<Kunde> getCustomers() {
        return null;
    }

    public Kunde addCustomer(String firstname, String lastname) {
        return null;
    }

    public Kunde deleteCustomer(int id) {
        return null;
    }

    // Address
    public Adresse getAddress(int customerId) {
        return null;
    }

    public Adresse addAddress(int customerId, Adresse address) {
        return null;
    }

    public Adresse updateAddress(int customerId, Adresse address) {
        return null;
    }

    public Adresse deleteAddress(int customerId) {
        return null;
    }
}
