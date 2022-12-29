package swa.boundry;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.quarkus.qute.TemplateInstance;
import swa.control.BestellungService;
import swa.control.KundenService;
import swa.control.PizzaService;
import swa.entity.Bestellposten;
import swa.entity.Bestellung;
import swa.entity.Kunde;
import swa.entity.Pizza;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.Template;

@Path("home")
@Produces(MediaType.TEXT_HTML)
@Transactional(value = TxType.REQUIRES_NEW)
@RequestScoped
public class HomeResource {

    @CheckedTemplate(requireTypeSafeExpressions = false)
    public static class Templates {
        public static native TemplateInstance index();

        public static native TemplateInstance customer();
    }

    @Inject
    AuthResource auth;

    @Inject
    @Named("BestellungRepos")
    BestellungService bestellungService;

    @Inject
    @Named("KundenRepos")
    KundenService kundenService;

    @Inject
    @Named("PizzaRepos")
    PizzaService pizzaService;

    /*
     * @GET
     * public TemplateInstance get() {
     * return Templates.index();
     * }
     */

    /*
     * @GET
     * 
     * @Path("customer")
     * public TemplateInstance getCustomer() {
     * return Templates.customer();
     * }
     */

    @GET
    public Response getItems() {
        List<Pizza> pizzas = new ArrayList<>();
        List<Bestellposten> items = new ArrayList<>();
        double totalPrice = 0;
        DecimalFormat f = new DecimalFormat("#0.00");

        pizzas = pizzaService.getAllPizza();
        items = bestellungService.showitem(auth.currentOrderID);

        if (items != null)
            for (Bestellposten item : items) {
                totalPrice += item.totalPrice();
            }

        return Response.ok(Templates.index().data("pizzas", pizzas).data("items", items).data("totalPrice",
                f.format(totalPrice))).build();
    }

    @GET
    @Path("customer")
    public Response getCustomer() {
        List<Kunde> customers = new ArrayList<>();
        customers = kundenService.getCustomers();
        return Response.ok(Templates.customer().data("customers", customers)).build();
    }
}