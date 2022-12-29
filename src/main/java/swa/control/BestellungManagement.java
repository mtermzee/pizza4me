package swa.control;

import java.util.List;

import swa.entity.Bestellposten;
import swa.entity.Bestellung;

public interface BestellungManagement {
    public List<Bestellung> showOrders(int customerId);

    public Bestellung createOrder(int customerId);

    public Bestellposten orderPizza(int orderId, int pizzaId);

    public Bestellposten updateOrder(int orderId, int itemId, int amount);

    public Bestellposten deleteOrderItem(int orderId, int itemId);

    public Bestellung completeOrder(int orderId);

    public List<Bestellposten> showitem(int orderId);
}
