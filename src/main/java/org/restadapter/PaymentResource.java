package org.restadapter;

import businesslogic.Customer;
import businesslogic.Payment;
import businesslogic.PaymentRegister;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/payment")
public class PaymentResource {
    PaymentRegister service = PaymentRegister.getRegister();

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Customer getCustomer(@PathParam("cid") String customerId){
//        return service.getCostumer(customerId);
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public List<Payment> getList() {
        return service.getPayments();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public Payment get(@QueryParam(value = "cid") final String customerId, @QueryParam(value = "mid") final String merchantId) {
        return service.getPayment(customerId, merchantId);
    }

    @POST
    @Path("/add/{cid}/{mid}")
    @Produces(MediaType.APPLICATION_JSON)
    public void add(@PathParam("cid") String customerId, @PathParam("mid") String merchantId) {
        service.addPayment(new Payment("pid4", customerId, merchantId, 10));
    }

    @DELETE
    public void deletePayment(@QueryParam(value = "cid") String customerId,
                             @QueryParam(value = "mid") String merchantId){
        service.removePayment(customerId, merchantId);
    }

// @QueryParam(value = "cid") final String customerId

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Payments";
    }
}