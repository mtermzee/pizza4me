package swa.control;

import java.util.List;

import swa.entity.Adresse;
import swa.entity.Kunde;

public interface KundenService {
    // Customer
    public Kunde getCustomer(int customerId);

    public List<Kunde> getCustomers();

    public Kunde addCustomer(String firstname, String lastname);

    public Kunde deleteCustomer(int id);

    // Address
    public Adresse getAddress(int customerId);

    public Adresse addAddress(int customerId, Adresse address);

    public Adresse updateAddress(int customerId, Adresse address);

    public Adresse deleteAddress(int customerId);
}
