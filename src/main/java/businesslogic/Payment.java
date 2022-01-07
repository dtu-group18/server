package businesslogic;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

/**
 * Simple class representing a payment
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
   private String paymentId, costumerId, merchantId;
   private double amount;
}
