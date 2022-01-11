package org.restadapter;

import businesslogic.Customer;
import businesslogic.Merchant;
import businesslogic.NotFoundException;
import businesslogic.PaymentRegister;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;
import java.util.UUID;

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
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/registration")
    public String register(Merchant merchant)
    {
        // Add merchant
        merchant.setMerchantId(UUID.randomUUID().toString());
        service.addMerchant(merchant);

        return merchant.getMerchantId();
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
    @Path("/{mid}/balance")
    public int getBalance(@PathParam("mid") String merchantId) {
        Merchant m = service.getMerchant(merchantId);
        return service.getBalance(m.getBankAccount());
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hej Hej Merchant!";
    }
}
