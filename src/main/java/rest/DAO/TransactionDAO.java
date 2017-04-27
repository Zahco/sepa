package rest.DAO;

import model.ParseXML;
import model.sepa.RootType;
import model.sepa.TransactionEntity;
import org.springframework.web.context.support.ServletContextResource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static model.TransactionFactory.exampleTransaction;

/**
 * Created by geoffrey on 26/04/17.
 */
public class TransactionDAO extends ClassDAO {

    public TransactionDAO() throws ClassNotFoundException, SQLException {}

    public void reset() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("drop table if exists transaction");
        preparedStatement.executeUpdate();
        preparedStatement = connection.prepareStatement("create table transaction(id serial primary key, data xml)");
        preparedStatement.executeUpdate();
    }

    public List<TransactionEntity> getAll() throws SQLException, JAXBException {
        List<TransactionEntity> result = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from transaction");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            result.add(new TransactionEntity(
                    resultSet.getInt("id"),
                    unmarshalling(resultSet.getString("data"))
            ));
        }
        return result;
    }

    public List<RootType> getTransaction(int num) throws SQLException, JAXBException {
        List<RootType> result = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select data from transaction where id = ?");
        preparedStatement.setInt(1, num);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            result.add(unmarshalling(resultSet.getString("data")));
        }
        return result;
    }
    public void insert(RootType transaction) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into transaction(data) values (XML(?))");
        preparedStatement.setString(1, marshalling(transaction));
        preparedStatement.executeUpdate();
    }

    private String marshalling(RootType transaction) throws Exception {
        JAXBContext context = JAXBContext.newInstance(RootType.class);
        OutputStream os = new ByteArrayOutputStream();
        context.createMarshaller().marshal(transaction, os);

        //Check if good xml
        System.out.println("test");
        ClassLoader classLoader = getClass().getClassLoader();
        String xsdPath = classLoader.getResource("tp1.sepa.01.xsd").getPath();
        ParseXML.getXML(xsdPath, os.toString());
        System.out.println("after");

        return os.toString();
    }

    private RootType unmarshalling(String transaction) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(RootType.class);
        System.out.println(transaction);
        return (RootType)context.createUnmarshaller().unmarshal(new ByteArrayInputStream(transaction.getBytes()));
    }
}
