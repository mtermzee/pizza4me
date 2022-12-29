package swa.control;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import swa.entity.Bestellposten;
import swa.entity.Bestellung;

@Singleton
public class BestellungService {
    public int currentOrderID;

    @Inject
    BestellungManagement bManagement;

    public List<Bestellung> showOrders(int customerId) {
        return bManagement.showOrders(customerId);
    }

    public Bestellung createOrder(int customerId) {
        Bestellung order = bManagement.createOrder(customerId);
        currentOrderID = order.getId();
        return order;
    }

    public Bestellposten orderPizza(int orderId, int pizzaId) {
        return bManagement.orderPizza(orderId, pizzaId);
    }

    public Bestellposten updateOrder(int orderId, int itemId, int amount) {
        return bManagement.updateOrder(orderId, itemId, amount);
    }

    public Bestellposten deleteOrderItem(int orderId, int itemId) {
        return bManagement.deleteOrderItem(orderId, itemId);
    }

    public Bestellung completeOrder(int orderId) {
        return bManagement.completeOrder(orderId);
    }

    public List<Bestellposten> showitem() {
        return bManagement.showitem(currentOrderID);
    }
}
