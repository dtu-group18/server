package org.restadapter;

import businesslogic.Customer;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

import businesslogic.NotFoundException;
import businesslogic.PaymentRegister;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
// Test comment (delete after)
@Path("/customer")
public class CustomerResource {
    PaymentRegister service = PaymentRegister.getRegister();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{cid}")
    public Customer getCustomer(@PathParam("cid") String customerId){
        return service.getCustomer(customerId);
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/registration")
    public String register(Customer customer)
    {
        // Add customer
        customer.setCustomerId(UUID.randomUUID().toString());
        service.addCustomer(customer);

        return customer.getCustomerId();
    }

    @DELETE
    @Path("/{cid}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCustomer(@PathParam("cid") String customerId){
        service.removeCustomer(customerId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/account/list")
    public Set<Customer> getList() {
        return service.getCustomerRegs();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{cid}/balance")
    public int getBalance(@PathParam("cid") String customerId) {
        Customer c = service.getCustomer(customerId);
        return service.getBalance(c.getBankAccount());
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hej Hej Customer!";
    }
}