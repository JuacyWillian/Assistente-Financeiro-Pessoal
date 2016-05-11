package afp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FabricaDeConexoes {

    private final String url;
    private final String usuario;
    private final String senha;

    public FabricaDeConexoes() {
        url = "jdbc:mysql://localhost:3306/assistentefinanceiropessoal";
        usuario = "aluno";
        senha = "unicarioca";
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            Logger.getLogger(FabricaDeConexoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FabricaDeConexoes.class.getName()).log(Level.SEVERE, "Driver não encontrado.", ex);
        }
        return null;
    }

}
