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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;

import swa.control.bestellung.BestellungService;

@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(value = TxType.REQUIRES_NEW)
@RequestScoped
public class BestellungResource {
    @Inject
    BestellungService bestellungService;

    @GET
    @Path("{customerId}")
    @Operation(summary = "Get all orders of a customer")
    @RolesAllowed("user")
    public Response showOrders(@PathParam("customerId") int customerId) {
        return Response.ok(bestellungService.showOrders(customerId)).build();
    }

    @POST
    @Path("{customerId}")
    @Operation(summary = "Create a new")
    @RolesAllowed("user")
    public Response createOrder(@PathParam("customerId") int customerId) {
        return Response.ok(bestellungService.createOrder(customerId)).build();
    }

    @POST
    @Path("{orderId}/{pizzaId}")
    @Operation(summary = "Order a pizza")
    @RolesAllowed("user")
    public Response orderPizza(@PathParam("orderId") int orderId, @PathParam("pizzaId") int pizzaId) {
        return Response.ok(bestellungService.orderPizza(orderId, pizzaId)).build();
    }

    @POST
    @Path("/complete/{orderId}")
    @Operation(summary = "Complete an order")
    @RolesAllowed("user")
    public Response completeOrder(@PathParam("orderId") int orderId) {
        return Response.ok(bestellungService.completeOrder(orderId)).build();
    }

    @PUT
    @Path("{orderId}/{itemId}/{amount}")
    @Operation(summary = "Update an order item")
    @RolesAllowed("user")
    public Response updateOrder(@PathParam("orderId") int orderId, @PathParam("itemId") int itemId,
            @PathParam("amount") int amount) {
        return Response.ok(bestellungService.updateOrder(orderId, itemId, amount)).build();
    }

    @DELETE
    @Path("{orderId}/{itemId}/")
    @Operation(summary = "Delete an order item")
    @RolesAllowed("user")
    public Response deleteOrderItem(@PathParam("orderId") int orderId, @PathParam("itemId") int itemId) {
        return Response.ok(bestellungService.deleteOrderItem(orderId, itemId)).build();
    }

}
