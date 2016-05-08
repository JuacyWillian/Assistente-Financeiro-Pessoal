package afp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static String password;
    private static String user;
    private static String url;

    public ConnectionFactory() {
        url = "jdbc:mysql://localhost:3306/assistentefinanceiropessoal";
        user = "aluno";
        password = "unicarioca";
    }

    public Connection createConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
