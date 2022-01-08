package org.restadapter;

import businesslogic.Customer;
import businesslogic.Merchant;
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{mid}/{name}/{cpr}/{account}")
    public Response register(@PathParam("mid") String mid,
                             @PathParam("name") String name,
                             @PathParam("cpr") String cpr,
                             @PathParam("account") String account)
    {
        // Create merchant model
        Merchant newMerchant = new Merchant();
        newMerchant.setMerchantId(mid);
        newMerchant.setName(name);
        newMerchant.setCpr(cpr);
        newMerchant.setBankAccount(account);

        // Add merchant
        service.addMerchant(newMerchant);

        return Response.fromResponse(Response.status(Response.Status.OK).build()).build();
    }

    @DELETE
    @Path("/{mid}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteMerchant(@QueryParam(value = "mid") String merchantId){
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
