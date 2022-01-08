package org.restadapter;

import businesslogic.Customer;
import businesslogic.PaymentRegister;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("payment/customer/{cid}")
public class CustomerResource {
    PaymentRegister service = PaymentRegister.getRegister();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@PathParam("cid") String customerId){
        return service.getCustomer(customerId);
    }

    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    public String hello() {
        return "Hej Hej Customer!";
    }
}