package rest;

import model.Stats.TransactionStats;
import model.resume.TransactionResume;
import model.resume.TransactionResumes;
import model.sepa.DdtiType;
import model.sepa.ObjectFactory;
import model.sepa.RootType;
import model.sepa.TransactionEntity;
import rest.DAO.TransactionDAO;
import welcome.WelcomeXML;

import javax.ws.rs.*;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static model.TransactionFactory.exampleRootType;


public class MyServiceTP {
    private TransactionDAO transactionDAO;

    public MyServiceTP() throws SQLException, ClassNotFoundException {
        transactionDAO = new TransactionDAO();
    }


    /**
     * GET method bound to calls on /animals/{something}
     */
    @GET
    @Path("/accueil")
    public WelcomeXML accueil() throws Exception {
        WelcomeXML welcome = new WelcomeXML("Geoffrey SPAUR, Camille LEPLUMEY", "30/04/2017");
        return welcome;
    }

    /**
     * GET method bound to calls on /animals/{something}
     */
    @GET
    @Path("/stats")
    @Produces("application/xml")
    public TransactionStats stats() throws Exception {
        TransactionStats stats = new TransactionStats();
        stats.setNbOfTransaction(getTotalTransac());
        stats.setTotalAmount(getTotalTransacAmount());
        return stats;
    }

    private BigDecimal getTotalTransac() throws SQLException, JAXBException {
        List<TransactionEntity> trans = transactionDAO.getAll();
        BigDecimal montant = BigDecimal.ZERO;
        List<DdtiType> temps;
        for (int i = 0; i < trans.size(); i++) {
            temps = trans.get(i).getRt().getDrctDbtTxInf();
            for (int j = 0; j < temps.size(); j++) {
                montant = montant.add(BigDecimal.ONE);
            }
        }
        return montant;
    }

    private BigDecimal getTotalTransacAmount() throws JAXBException, SQLException {
        List<TransactionEntity> trans = transactionDAO.getAll();
        BigDecimal montant = BigDecimal.ZERO;
        List<DdtiType> temps;
        for (int i = 0; i < trans.size(); i++) {
            temps = trans.get(i).getRt().getDrctDbtTxInf();
            for (int j = 0; j < temps.size(); j++) {
                montant = montant.add(temps.get(j).getInstdAmt().getValue());
            }
        }
        return montant;
    }

    /**
     * GET method bound to calls on /animals/{something}
     */
    @GET
    @Path("/resume")
    @Produces("application/xml")
    public TransactionResumes resume() throws Exception {
        List<TransactionResume> resumeList = new ArrayList<>();
        List<TransactionEntity> trans = transactionDAO.getAll();
        List<DdtiType> temps;
        for (int i = 0; i < trans.size(); i++) {
            temps = trans.get(i).getRt().getDrctDbtTxInf();
            for (int j = 0; j < temps.size(); j++) {
                resumeList.add(new TransactionResume(
                        makeNum(trans.get(i).getIdent()),
                        temps.get(j).getPmtId().toString(),
                        temps.get(j).getInstdAmt().getValue(),
                        temps.get(j).getDrctDbtTx().getDtOfSgntr().toString()
                ));
            }
        }
        TransactionResumes placeholder = new TransactionResumes();
        placeholder.setTransactionResume(resumeList);
        return placeholder;
    }

    @GET
    @Path("/trx/{n}/")
    @Produces("application/xml")
    public RootType getTransaction(@PathParam("n") int num) throws JAXBException, SQLException {
        return transactionDAO.getTransaction(num).get(0);
    }

    private String makeNum(int num) {
        StringBuilder result = new StringBuilder();
        result.append("SL");
        DecimalFormat df = new DecimalFormat("#0000");
        result.append(df.format(num));
        return result.toString();
    }

    @POST
    @Path("/depot")
    @Produces("application/xml")
    public JAXBElement<RootType> depot(RootType sepa) throws JAXBException, SQLException {
        transactionDAO.insert(sepa);
        return new ObjectFactory().createCstmrDrctDbtInitn(sepa);
    }



    @GET
    @Path("/test")
    @Produces("application/xml")
    public JAXBElement<RootType> test() throws Exception {
        transactionDAO.insert(exampleRootType());
        RootType trans = transactionDAO.getAll().get(0).getRt();
        return new ObjectFactory().createCstmrDrctDbtInitn(trans);
    }

}
