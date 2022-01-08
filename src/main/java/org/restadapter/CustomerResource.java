package org.restadapter;

import businesslogic.Customer;
import java.util.Set;
import businesslogic.PaymentRegister;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{cid}/{name}/{cpr}/{account}")
    public Response register(@PathParam("cid") String customerId,
                             @PathParam("name") String name,
                             @PathParam("cpr") String cpr,
                             @PathParam("account") String account)
    {
        // Create customer model
        Customer newCustomer = new Customer();
        newCustomer.setCustomerId(customerId);
        newCustomer.setName(name);
        newCustomer.setCpr(cpr);
        newCustomer.setBankAccount(account);

        // Add customer
        service.addCustomer(newCustomer);

        return Response.fromResponse(Response.status(Response.Status.OK).build()).build();
    }

    @DELETE
    @Path("/{cid}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCustomer(@QueryParam(value = "cid") String customerId){
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
    public String hello() {
        return "Hej Hej Customer!";
    }
}