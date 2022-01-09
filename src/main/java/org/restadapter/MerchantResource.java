package org.restadapter;

import businesslogic.Customer;
import businesslogic.Merchant;
import businesslogic.NotFoundException;
import businesslogic.PaymentRegister;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;

@Path("/merchant")
public class MerchantResource {

    PaymentRegister service = PaymentRegister.getRegister();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{mid}")
    public Merchant getMerchant(@PathParam("mid") String merchantId){
        return service.getMerchant(merchantId);
    }

    // workaround example
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/validation/{mid}")
    public Response validateMerchant(@PathParam("mid") String merchantId){
        if (service.getMerchant(merchantId) != null) {
            return Response.fromResponse(Response.status(Response.Status.OK).build()).build();
        } else {
            return Response.fromResponse(Response.status(Response.Status.NOT_FOUND).build()).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{mid}/{name}/{cpr}/{account}")
    public String register(@PathParam("mid") String merchantId,
                             @PathParam("name") String name,
                             @PathParam("cpr") String cpr,
                             @PathParam("account") String account)
    {
        // Create merchant model
        Merchant newMerchant = new Merchant();
        newMerchant.setMerchantId(merchantId);
        newMerchant.setName(name);
        newMerchant.setCpr(cpr);
        newMerchant.setBankAccount(account);

        // Add merchant
        service.addMerchant(newMerchant);

        return merchantId;
    }

    @DELETE
    @Path("/{mid}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteMerchant(@PathParam("mid") String merchantId){
        service.removeMerchant(merchantId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/account/list")
    public Set<Merchant> getList() {
        return service.getMerchantRegs();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hej Hej Merchant!";
    }
}
