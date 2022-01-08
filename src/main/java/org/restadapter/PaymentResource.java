package org.restadapter;

import businesslogic.NotFoundException;
import businesslogic.Payment;
import businesslogic.PaymentRegister;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/payment")
public class PaymentResource {
    PaymentRegister service = PaymentRegister.getRegister();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public List<Payment> getList() {
        return service.getPayments();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public Payment get(@QueryParam(value = "cid") final String customerId, @QueryParam(value = "mid") final String merchantId, @QueryParam(value = "amount") String amount) {
        return service.getPayment(customerId, merchantId, amount);
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Payment payment) {
        try {
            service.addPayment(payment);
            return Response.status(Response.Status.OK).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @DELETE
    public void deletePayment(@QueryParam(value = "cid") String customerId,
                              @QueryParam(value = "mid") String merchantId,
                              @QueryParam(value = "amount") String amount){
        service.removePayment(customerId, merchantId, amount);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Payments";
    }


}