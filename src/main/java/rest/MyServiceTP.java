package rest;

import model.sepa.DdtiType;
import model.sepa.ObjectFactory;
import model.sepa.RootType;
import rest.DAO.TransactionDAO;

import javax.ws.rs.*;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.math.BigDecimal;
import java.sql.SQLException;
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
    public String accueil() throws Exception {
        return "Bienvenu au rendu final du projet de Langage Web 2 pour le 30/04/2017 par Camille LEPLUMEY, Geoffrey SPAUR";
    }

    /**
     * GET method bound to calls on /animals/{something}
     */
    @GET
    @Path("/stats")
    public String stats() throws Exception {
        StringBuilder result = new StringBuilder();
        result.append("Nombre total de transactions : ");
        result.append(getTotalTransac());
        result.append(" Montant total des transactions : ");
        result.append(getTotalTransacAmount());
        return result.toString();
    }

    private BigDecimal getTotalTransac() throws SQLException, JAXBException {
        List<RootType> trans = transactionDAO.getAll();
        BigDecimal montant = BigDecimal.ZERO;
        List<DdtiType> temps;
        for (int i = 0; i < trans.size(); i++) {
            temps = trans.get(i).getDrctDbtTxInf();
            for (int j = 0; j < temps.size(); j++) {
                montant = montant.add(BigDecimal.ONE);
            }
        }
        return montant;
    }

    private BigDecimal getTotalTransacAmount() throws JAXBException, SQLException {
        List<RootType> trans = transactionDAO.getAll();
        BigDecimal montant = BigDecimal.ZERO;
        List<DdtiType> temps;
        for (int i = 0; i < trans.size(); i++) {
            temps = trans.get(i).getDrctDbtTxInf();
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
    public String resume() throws Exception {
        return "hello world !";
    }


    @POST
    @Path("/echo")
    @Consumes("application/xml")
    public JAXBElement<RootType> echo(RootType sepa) {
//        return sepa.getDrctDbtTxInf().stream().findFirst().get().getDbtrAgt().getBIC();
        return new ObjectFactory().createCstmrDrctDbtInitn(sepa);
    }

    @GET
    @Path("/test")
    @Produces("application/xml")
    public JAXBElement<RootType> test() throws Exception {
        transactionDAO.insert(exampleRootType());
        List<RootType> trans = transactionDAO.getAll();
        BigDecimal montant = BigDecimal.ZERO;
        List<DdtiType> temps;
        for (int i = 0; i < trans.size(); i++) {
            temps = trans.get(i).getDrctDbtTxInf();
            for (int j = 0; j < temps.size(); j++) {
                montant.add(temps.get(i).getInstdAmt().getValue());
            }
        }
        return new ObjectFactory().createCstmrDrctDbtInitn(trans.get(0));
    }

}
