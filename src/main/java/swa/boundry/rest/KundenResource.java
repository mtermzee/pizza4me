package swa.boundry.rest;

import javax.enterprise.context.RequestScoped;
import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
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

import org.eclipse.microprofile.openapi.annotations.Operation;

import swa.control.KundenService;
import swa.entity.Adresse;

@Path("/kunden")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(value = TxType.REQUIRES_NEW)
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
    @Operation(summary = "Get all customers")
    @RolesAllowed("customer")
    public Response getCustomers() {
        return Response.ok(kundenService.getCustomers()).build();
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Get a customer by id")
    @RolesAllowed("admin")
    public Response getCustomer(@PathParam("id") int id) {
        return Response.ok(kundenService.getCustomer(id)).build();
    }

    @POST
    @Operation(summary = "Add a customer")
    public Response addCustomer(@QueryParam("firstname") String firstname, @QueryParam("lastname") String lastname) {
        return Response.ok(kundenService.addCustomer(firstname, lastname)).build();
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete a customer")
    public Response deleteCustomer(@PathParam("id") int id) {
        return Response.ok(kundenService.deleteCustomer(id)).build();
    }

    @GET
    @Path("{id}/address")
    @Operation(summary = "Get a customer's address by id")
    public Response getAddress(@PathParam("id") int id) {
        return Response.ok(kundenService.getAddress(id)).build();
    }

    @POST
    @Path("{id}/address")
    @Operation(summary = "Add a customer's address")
    public Response addAddress(@PathParam("id") int id, Adresse address) {
        return Response.ok(kundenService.addAddress(id, address)).build();
    }

    @PUT
    @Path("{id}/address")
    @Operation(summary = "Update a customer's address")
    public Response updateAddress(@PathParam("id") int id, Adresse address) {
        return Response.ok(kundenService.updateAddress(id, address)).build();
    }

    @DELETE
    @Path("{id}/address")
    @Operation(summary = "Delete a customer's address")
    public Response deleteAddress(@PathParam("id") int id) {
        return Response.ok(kundenService.deleteAddress(id)).build();
    }
}
