package rest.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by geoffrey on 26/04/17.
 */
public class ClassDAO {
    protected Connection connection;
    private String url = "jdbc:postgresql://ec2-23-21-227-73.compute-1.amazonaws.com:5432/dak7mg7v6mbi88";
    private String user = "rumzrhungsqeaj";
    private String password = "b9d4e9d460f900c95cac91f1e10a38cdd8f2c91e71db0e86216c6e04450476b7";

    public ClassDAO() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection =  DriverManager.getConnection(url, user, password);
    }
}
