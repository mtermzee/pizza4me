package swa.control.kunde;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import swa.entity.Adresse;
import swa.entity.Kunde;

@Singleton
public class KundeService {
    public int currentCustomerID;

    @Inject
    KundenManagement bManagement;

    public Kunde getCustomer(int customerId) {
        return bManagement.getCustomer(customerId);
    }

    public List<Kunde> getCustomers() {
        return bManagement.getCustomers();
    }

    public Kunde addCustomer(String firstname, String lastname) {
        Kunde customer = bManagement.addCustomer(firstname, lastname);
        currentCustomerID = customer.getId();
        return customer;
    }

    public Kunde getCustomer() {
        return bManagement.getCustomer(currentCustomerID);
    }

    public Kunde deleteCustomer(int id) {
        return bManagement.deleteCustomer(id);
    }

    // Address
    public Adresse getAddress(int customerId) {
        return bManagement.getAddress(customerId);
    }

    public Adresse addAddress(int customerId, Adresse address) {
        return bManagement.addAddress(customerId, address);
    }

    public Adresse updateAddress(int customerId, Adresse address) {
        return bManagement.updateAddress(customerId, address);
    }

    public Adresse deleteAddress(int customerId) {
        return bManagement.deleteAddress(customerId);
    }
}
