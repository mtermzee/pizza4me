package swa.boundry;

import javax.enterprise.context.RequestScoped;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import swa.control.KundenService;
import swa.entity.Adresse;

@Path("/kunden")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class KundenResource {

    @Inject
    KundenService kundenService;

    @PostConstruct
    public void init() {
        /*
         * this.kundenService.addCustomer("Alex", "Borko");
         * this.kundenService.addCustomer("Mohammad", "Termzee");
         * Adresse address = new Adresse("49090", "Osnabrueck", "Berghoffstr", "49");
         * this.kundenService.addAddress(2, address);
         */
    }

    @GET
    public Response getCustomers() {
        return Response.ok(kundenService.getCustomers()).build();
    }

    @GET
    @Path("{id}")
    public Response getCustomer(@PathParam("id") int id) {
        return Response.ok(kundenService.getCustomer(id)).build();
    }

    @POST
    public Response addCustomer(@QueryParam("firstname") String firstname, @QueryParam("lastname") String lastname) {
        return Response.ok(kundenService.addCustomer(firstname, lastname)).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCustomer(@PathParam("id") int id) {
        return Response.ok(kundenService.deleteCustomer(id)).build();
    }

    @GET
    @Path("{id}/address")
    public Response getAddress(@PathParam("id") int id) {
        return Response.ok(kundenService.getAddress(id)).build();
    }

    @POST
    @Path("{id}/address")
    public Response addAddress(@PathParam("id") int id, Adresse address) {
        return Response.ok(kundenService.addAddress(id, address)).build();
    }

    @PUT
    @Path("{id}/address")
    public Response updateAddress(@PathParam("id") int id, Adresse address) {
        return Response.ok(kundenService.updateAddress(id, address)).build();
    }

    @DELETE
    @Path("{id}/address")
    public Response deleteAddress(@PathParam("id") int id) {
        return Response.ok(kundenService.deleteAddress(id)).build();
    }
}
