package model.Stats;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * Created by geoffrey on 27/04/17.
 */
@XmlRootElement
public class TransactionStats {
    private BigDecimal nbOfTransaction = BigDecimal.ZERO;
    private BigDecimal totalAmount = BigDecimal.ZERO;

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public BigDecimal getNbOfTransaction() {
        return nbOfTransaction;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setNbOfTransaction(BigDecimal nbOfTransaction) {
        this.nbOfTransaction = nbOfTransaction;
    }
}
