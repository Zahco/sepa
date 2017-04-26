package rest;

import model.sepa.ObjectFactory;
import model.sepa.RootType;

import javax.ws.rs.*;
import javax.xml.bind.JAXBElement;
import java.sql.*;
import java.util.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class MyServiceTP {

    public final static String dirres = "/home/m1gil/spaurgeo/sepa/src/main/resources/";

    private final static String url = "jdbc:postgres://ec2-23-21-227-73.compute-1.amazonaws.com:5432/dak7mg7v6mbi88";
    private final static String fullurl = "postgres://uscplbkrtdpuyd:5ddb4f67ce0824b0b2788d9584198f031aa849e845731d0e29008f1fb2e66130@ec2-23-21-227-73.compute-1.amazonaws.com:5432/dak7mg7v6mbi88";
    private final static String user = "uscplbkrtdpuyd";
    private final static String password = "5ddb4f67ce0824b0b2788d9584198f031aa849e845731d0e29008f1fb2e66130";

    public MyServiceTP() {
        // Fill our center with some animals

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

    private List<String> getTotalTransac() throws SQLException {
        Connection connection = null;
        try {
            //Class.forName("org.postgresql.Driver").newInstance();
            connection = DriverManager.getConnection(url, user, password);
            Statement stmt = connection.createStatement();
        }catch (Exception e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include it in your library path!");
            e.printStackTrace();
        }
        List<String> strings = new ArrayList<>();
        if (connection == null) {
            strings.add("I am sorry");
            return strings;
        }
        PreparedStatement preparedStatement = connection.prepareStatement("select * from transaction_test");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            strings.add(
                    resultSet.getString("data")
                    );
        }
        return strings;
    }

    private String getTotalTransacAmount() {
        //select sum(amount) from transactions;
        return "lots";
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

}
