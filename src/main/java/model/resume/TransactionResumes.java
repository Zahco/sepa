package model.resume;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by kittypwa on 27/04/17.
 */
@XmlRootElement
public class TransactionResumes {
    private List<TransactionResume> transactionResume;

    public List<TransactionResume> getTransactionResume() {
        return transactionResume;
    }

    public void setTransactionResume(List<TransactionResume> transactionResume) {
        this.transactionResume = transactionResume;
    }
}
