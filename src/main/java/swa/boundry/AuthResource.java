package swa.boundry;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import swa.control.bestellung.BestellungService;
import swa.control.kunde.KundeService;
import swa.entity.Kunde;

@Path("/login")
@Produces(MediaType.TEXT_HTML)
@Transactional(value = TxType.REQUIRES_NEW)
@RequestScoped
public class AuthResource {

    @CheckedTemplate(requireTypeSafeExpressions = false)
    public static class Templates {
        public static native TemplateInstance login();

        public static native TemplateInstance register();
    }

    @Inject
    HomeResource homeResource;

    @Inject
    KundeService kundenService;

    @Inject
    BestellungService bestellungService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response login() {
        return Response.ok(Templates.register()).build();

    }

    @GET
    @Path("/register")
    @Produces(MediaType.TEXT_HTML)
    public Response register() {
        return Response.ok(Templates.register()).build();
    }

    @POST
    @Path("/register/send")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response addUser(@FormParam("firstname") String firstname, @FormParam("lastname") String lastname) {
        // UserLogin.add(username, passwort, "KundIn");
        int currentCustomerID;
        Kunde customer = kundenService.addCustomer(firstname, lastname);
        currentCustomerID = customer.getId();

        bestellungService.createOrder(currentCustomerID);

        return Response.seeOther(UriBuilder.fromPath("/home/customer").build()).build();
    }
}
