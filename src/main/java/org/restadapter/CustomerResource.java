package org.restadapter;

import businesslogic.Customer;
import businesslogic.PaymentRegister;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("payment/customer/{cid}")
public class CustomerResource {
    PaymentRegister service = PaymentRegister.getRegister();

    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    public String hello() {
        return "Hej Hej Customer!";
    }
}