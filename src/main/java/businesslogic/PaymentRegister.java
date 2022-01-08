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

    final Set<Customer> customerReg = new HashSet<>();
    final Set<Merchant> merchantReg = new HashSet<>();

    private PaymentRegister(){

        //The application knows a customer with id cid1 and a merchant with id mid1. No other customers and merchants are known.
        final String customer = "cid1";
        final String merchant = "mid1";

        // Add the resources and functions to Simple DTU Pay that allows
        // to register a customer and a merchant with their respective names, CPR numbers, and bank account
        // numbers. Note that customer and merchant have to have a bank account before they register with DTU Pay

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
    public Set<Customer> getCustomerRegs(){return customerReg;}
    public Set<Merchant> getMerchantRegs(){return merchantReg;}


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

    /**
     * Register customers
     *
     * @param customer
     */
    public void addCustomer(Customer customer) {
        customerReg.add(customer);
    }

    /**
     * Register merchants
     *
     * @param merchant
     */
    public void addMerchant(Merchant merchant) {
        merchantReg.add(merchant);
    }

    /**
     * Remove customer from registration list
     * @param customerId
     */
    public void removeCustomer(String customerId) {
        try {
            for (Customer c: customerReg) {
                if (c.getCustomerId().equals(customerId)) {
                    customerReg.remove(c);

                    break;
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Remove merchant from registration list
     * @param merchantId
     */
    public void removeMerchant(String merchantId) {
        try {
            for (Merchant m: merchantReg) {
                if (m.getMerchantId().equals(merchantId)) {
                    merchantReg.remove(m);

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
