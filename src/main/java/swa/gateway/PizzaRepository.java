package swa.gateway;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import swa.control.PizzaService;
import swa.entity.Pizza;

@ApplicationScoped
@Transactional(value = TxType.REQUIRED)
public class PizzaRepository implements PizzaService {
    @Inject
    EntityManager em;

    @Override
    public Pizza getPizza(int pizzaId) {
        return em.find(Pizza.class, pizzaId);
    }

    @Override
    public List<Pizza> getAllPizza() {
        return em.createQuery("SELECT p FROM Pizza p", Pizza.class).getResultList();
    }

    @Override
    public Pizza addPizza(Pizza pizza) {
        if (pizza != null)
            em.persist(pizza);
        return pizza;
    }

    @Override
    public Pizza deletePizza(int pizzaId) {
        Pizza pizza = em.find(Pizza.class, pizzaId);
        if (pizza != null) {
            em.remove(pizza);
            return pizza;
        } else {
            return null;
        }
    }

}
