package swa.boundry.rest;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;

import swa.control.PizzaService;
import swa.entity.Pizza;

@Path("/pizza")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(value = TxType.REQUIRES_NEW)
@RequestScoped
public class PizzaResource {
    @Inject
    PizzaService pizzaService;

    @GET
    @Operation(summary = "Get all pizzas")
    @RolesAllowed("user")
    public Response getAllPizza() {
        return Response.ok(pizzaService.getAllPizza()).build();
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Get a pizza by id")
    @RolesAllowed("user")
    public Response getPizza(@PathParam("id") int id) {
        return Response.ok(pizzaService.getPizza(id)).build();
    }

    @POST
    @Operation(summary = "Add a pizza")
    @RolesAllowed("user")
    public Response addPizza(Pizza pizza) {
        return Response.ok(pizzaService.addPizza(pizza)).build();
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete a pizza")
    @RolesAllowed("user")
    public Response deletePizza(@PathParam("id") int id) {
        return Response.ok(pizzaService.deletePizza(id)).build();
    }
}
