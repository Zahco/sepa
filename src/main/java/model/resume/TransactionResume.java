package model.resume;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * Created by kittypwa on 27/04/17.
 */
public class TransactionResume {

    private String num;
    private String ident;
    private BigDecimal montant;
    private String date;

    public TransactionResume(String num, String ident, BigDecimal montant, String date) {
        this.num = num;
        this.ident = ident;
        this.montant = montant;
        this.date = date;
    }

    public String getNum() {
        return num;
    }

    public String getIdent() {
        return ident;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public String getDate() {
        return date;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
