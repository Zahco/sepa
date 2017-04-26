package rest.DAO;

import model.sepa.RootType;

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

    public List<RootType> getAll() throws SQLException, JAXBException {
        List<RootType> result = new ArrayList<RootType>();
        PreparedStatement preparedStatement = connection.prepareStatement("select data from transaction");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            result.add(unmarshalling(resultSet.getString("data")));
        }
        return result;
    }
    public void insert(RootType transaction) throws SQLException, JAXBException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into transaction(data) values (XML(?))");
        preparedStatement.setString(1, marshalling(transaction));
        preparedStatement.executeUpdate();
    }

    private String marshalling(RootType transaction) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(RootType.class);
        OutputStream os = new ByteArrayOutputStream();
        context.createMarshaller().marshal(exampleTransaction(), os);
        return os.toString();
    }

    private RootType unmarshalling(String transaction) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(RootType.class);
        System.out.println(transaction);
        return (RootType)context.createUnmarshaller().unmarshal(new ByteArrayInputStream(transaction.getBytes()));
    }
}
