package swa.control;

import java.util.List;

import swa.entity.Pizza;

public interface PizzaService {
    public Pizza getPizza(int pizzaId);

    public List<Pizza> getAllPizza();

    public Pizza addPizza(Pizza pizza);

    public Pizza deletePizza(int pizzaId);

}
