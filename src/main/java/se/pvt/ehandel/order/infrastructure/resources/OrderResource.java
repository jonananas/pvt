package se.pvt.ehandel.order.infrastructure.resources;

import se.pvt.ehandel.order.domain.Order;
import se.pvt.ehandel.order.domain.OrderRepository;
import se.pvt.ehandel.produkt.domain.Produkt;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("orders")
public class OrderResource {

    OrderRepository orders;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String postOrder(Order order) {
        orders.läggTill(order);
        return "OK";
    }

}
