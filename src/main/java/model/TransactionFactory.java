package model;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import model.sepa.*;

import javax.xml.bind.JAXBElement;
import java.math.BigDecimal;

/**
 * Created by spaurgeo on 28/03/17.
 */
public class TransactionFactory {
    public static RootType exampleRootType() {
        DdtiType transaction = new DdtiType();
        // ID
        transaction.setPmtId("Example");

        InstdAmtType iat = new InstdAmtType();
        iat.setCcy("EUR");
        iat.setValue(new BigDecimal(12322.3));
        transaction.setInstdAmt(iat);

        DdtType ddtt = new DdtType();
        ddtt.setMndtId("FF-57-E7");
        XMLGregorianCalendarImpl date = new XMLGregorianCalendarImpl();
        date.setDay(5);
        date.setMonth(3);
        date.setYear(1992);
        ddtt.setDtOfSgntr(date);
        transaction.setDrctDbtTx(ddtt);

        DAgentType dat = new DAgentType();
        dat.setBIC("DAEOFRPPCCT");
        transaction.setDbtrAgt(dat);

        DebtorType dt = new DebtorType();
        dt.setNm("Mr Dupont");
        transaction.setDbtr(dt);

        DAccountType dact = new DAccountType();
        dact.setIBAN("FE1405643596877A");
        transaction.setDbtrAcct(dact);

        transaction.getRmtInf().add("Ceci est un commentaire");


        RootType transactions = new RootType();
        transactions.getDrctDbtTxInf().add(transaction);
        return transactions;
    }

    public static JAXBElement<RootType> exampleTransaction() {
        return new ObjectFactory().createCstmrDrctDbtInitn(exampleRootType());
    }
}
