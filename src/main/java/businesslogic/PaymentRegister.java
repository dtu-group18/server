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

        //The application knows a customer with id cid1 and a merchant with id mid1. No other customers and merchants are known.
        final String customer = "cid1";
        final String merchant = "mid1";

        //add costumers
        customers.add(customer);
        //add merchants
        merchants.add(merchant);
    }
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
        if(!merchants.contains(payment.getMerchantId())) throw new NotFoundException(String.format("merchant with id %s is unknown", payment.getMerchantId()));

        payments.add(payment);
    }
    //------------------------------------------------------------

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


}
