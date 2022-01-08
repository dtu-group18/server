package businesslogic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * class that represents a register of multiple payment objects
 */
public class PaymentRegister {
    //--------Singleton pattern-----------------------------
    private static PaymentRegister register = new PaymentRegister();

    private final List<Payment> payments = new ArrayList<>();
    final Set<String> customers = new HashSet<>();
    final Set<String> merchants = new HashSet<>();

    private PaymentRegister(){

    //-----------------------------------------------------

    /**
     * method for getting the instance of the class
     * @return the instance of the class
     */
    public static PaymentRegister getRegister(){return register;}

    //can be implemented if we want a list of persons---------------
    /**
     * Method for adding a person to the list (register)
     * @param payment the person to add
     */
    public void addPayment(Payment payment) throws NotFoundException {
        //check for unknown costumer and merchant
        if(!customers.contains(payment.getCostumerId())) throw new NotFoundException(String.format("customer with id %s is unknown", payment.getCostumerId()));
        if(!merchants.contains(payment.getCostumerId())) throw new NotFoundException(String.format("merchant with id %s is unknown", payment.getMerchantId()));

        payments.add(payment);
    }
    //------------------------------------------------------------

    public Customer getCustomer(String customerId) {
        // Get customer, if any
        for (Customer c: customerReg) {
            if (c.getCustomerId().equals(customerId)) {
                return c;
            }
        }
        return null;
    }

    public Merchant getMerchant(String merchantId){
        // Get merchant, if any
        for (Merchant m: merchantReg) {
            if (m.getMerchantId().equals(merchantId)) {
                return m;
            }
        }
        return null;
    }


    public List<Payment> getPayments(){return payments;}


    public Payment getPayment(String customerId, String merchantId, String amount) {
        // Get payment, if any
        for (Payment a: payments) {
            if (a.getCostumerId().equals(customerId) && a.getMerchantId().equals(merchantId) && a.getAmount().equals(amount)) {
                return a;
            }
        }
        return null;
    }

    public void removePayment(String customerId, String merchantId, String amount) {
        try {
            for (Payment p: payments) {
                if (p.getCostumerId().equals(customerId) && p.getMerchantId().equals(merchantId) && p.getAmount().equals(amount)) {
                    payments.remove(p);
                    break;
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void addCostumerAndMerchant(String customerId, String merchantId) {
        customers.add(customerId);
        merchants.add(merchantId);
    }


}
