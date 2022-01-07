package businesslogic;

import java.util.ArrayList;
import java.util.List;

/**
 * class that represents a register of multiple payment objects
 */
public class PaymentRegister {
    //--------Singleton pattern-----------------------------
    private static PaymentRegister register = new PaymentRegister();
    private PaymentRegister(){
        addPayment(p1);
        addPayment(p2);
        addPayment(p3);
    }
    //-----------------------------------------------------

    private final List<Payment> payments = new ArrayList<>();

    private Payment p1 = new Payment("pid1", "cid1", "mid1", 1);
    private Payment p2 = new Payment("pid2","cid2", "mid2", 2);
    private Payment p3 = new Payment("pid3","cid3", "mid3", 3);


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
    public void addPayment(Payment payment){payments.add(payment);}
    //------------------------------------------------------------


    public Customer getCostumer(String costumerID){
        return new Customer(costumerID);
    }


    public List<Payment> getPayments(){return payments;}


    public Payment getPayment(String customerId, String merchantId) {
        // Get payment, if any
        for (Payment a: payments) {
            if (a.getCostumerId().equals(customerId) && a.getMerchantId().equals(merchantId)) {
                return a;
            }
        }

        return null;
    }
}
