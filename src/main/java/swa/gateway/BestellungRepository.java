package swa.gateway;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import swa.control.BestellungService;
import swa.entity.Bestellposten;
import swa.entity.Bestellung;
import swa.entity.Kunde;
import swa.entity.Pizza;

@ApplicationScoped
@Transactional(value = TxType.REQUIRED)
@Named("BestellungRepos")
public class BestellungRepository implements BestellungService {
    @Inject
    EntityManager em;

    @Override
    public List<Bestellung> showOrders(int customerId) {
        Kunde customer = em.find(Kunde.class, customerId);
        if (customer != null) {
            return customer.getOrders();
        } else {
            return null;
        }
    }

    @Override
    public Bestellung createOrder(int customerId) {
        Kunde customer = em.find(Kunde.class, customerId);
        if (customer != null) {
            Bestellung order = new Bestellung();
            customer.addOrder(order);
            em.persist(order);
            return order;
        } else {
            return null;
        }
    }

    @Override
    public Bestellposten orderPizza(int orderId, int pizzaId) {
        Bestellung order = em.find(Bestellung.class, orderId);
        Pizza pizza = em.find(Pizza.class, pizzaId);
        if (order != null && pizza != null) {
            Bestellposten orderItem = new Bestellposten();
            orderItem.setPizza(pizza);
            orderItem.setAmount(1);
            order.addOrderItem(orderItem);
            em.persist(orderItem);
            return orderItem;
        } else {
            return null;
        }
    }

    @Override
    public Bestellposten updateOrder(int orderId, int itemId, int amount) {
        Bestellung order = em.find(Bestellung.class, orderId);
        Bestellposten orderItem;
        if (order != null) {
            orderItem = order.searchItemInOrder(itemId);
            if (orderItem != null) {
                if (amount >= 1)
                    orderItem.setAmount(amount);
                else
                    deleteOrderItem(orderId, itemId);
                em.persist(orderItem);
                return orderItem;
            }
        }
        return null;
    }

    @Override
    public Bestellposten deleteOrderItem(int orderId, int itemId) {
        Bestellung order = em.find(Bestellung.class, orderId);
        Bestellposten orderItem;
        if (order != null) {
            orderItem = order.searchItemInOrder(itemId);
            if (orderItem != null) {
                order.removeOrderItem(orderItem);
                em.remove(orderItem);
                return orderItem;
            }
        }
        return null;
    }

    @Override
    public Bestellung completeOrder(int orderId) {
        Bestellung order = em.find(Bestellung.class, orderId);
        if (order != null) {
            order.setOrdered(true);
            em.merge(order);
            return order;
        } else {
            return null;
        }
    }

    @Override
    public List<Bestellposten> showitem(int orderId) {
        Bestellung order = em.find(Bestellung.class, orderId);
        if (order != null) {
            return order.getOrderItems();
        } else {
            return null;
        }
    }

}
