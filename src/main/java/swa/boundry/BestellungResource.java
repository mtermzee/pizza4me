package swa.boundry;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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

import swa.control.BestellungService;

@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class BestellungResource {
    @Inject
    BestellungService bestellungService;

    @GET
    @Path("{customerId}")
    public Response showOrders(@PathParam("customerId") int customerId) {
        return Response.ok(bestellungService.showOrders(customerId)).build();
    }

    @POST
    @Path("{customerId}")
    public Response createOrder(@PathParam("customerId") int customerId) {
        return Response.ok(bestellungService.createOrder(customerId)).build();
    }

    @POST
    @Path("{orderId}/{pizzaId}")
    public Response orderPizza(@PathParam("orderId") int orderId, @PathParam("pizzaId") int pizzaId) {
        return Response.ok(bestellungService.orderPizza(orderId, pizzaId)).build();
    }

    @PUT
    @Path("{orderId}/{itemId}/{amount}")
    public Response updateOrder(@PathParam("orderId") int orderId, @PathParam("itemId") int itemId,
            @PathParam("amount") int amount) {
        return Response.ok(bestellungService.updateOrder(orderId, itemId, amount)).build();
    }

    @DELETE
    @Path("{orderId}/{itemId}/")
    public Response deleteOrderItem(@PathParam("orderId") int orderId, @PathParam("itemId") int itemId) {
        return Response.ok(bestellungService.deleteOrderItem(orderId, itemId)).build();
    }

}
