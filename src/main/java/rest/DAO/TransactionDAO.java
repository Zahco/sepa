package rest.DAO;

import model.ParseXML;
import model.sepa.RootType;
import model.sepa.TransactionEntity;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static model.TransactionFactory.exampleTransaction;

/**
 * Created by geoffrey on 26/04/17.
 */
public class TransactionDAO extends ClassDAO {

    public TransactionDAO() throws ClassNotFoundException, SQLException {}

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

    public void deleteTransaction(int num) throws SQLException, JAXBException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from transaction where id = ?");
        preparedStatement.setInt(1, num);
        preparedStatement.executeQuery();
    }

    public void insert(RootType transaction) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into transaction(data) values (XML(?))");
        preparedStatement.setString(1, marshalling(transaction));
        preparedStatement.executeUpdate();
    }

    private String marshalling(RootType transaction) throws Exception {
        JAXBContext context = JAXBContext.newInstance(RootType.class);
        OutputStream os = new ByteArrayOutputStream();
        ParseXML.getXML("/WEB-INF/tp1.sepa.01.xsd", os.toString());
        context.createMarshaller().marshal(transaction, os);
        return os.toString();
    }

    private RootType unmarshalling(String transaction) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(RootType.class);
        System.out.println(transaction);
        return (RootType)context.createUnmarshaller().unmarshal(new ByteArrayInputStream(transaction.getBytes()));
    }
}
