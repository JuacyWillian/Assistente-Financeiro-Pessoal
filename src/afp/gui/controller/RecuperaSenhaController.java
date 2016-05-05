package afp.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RecuperaSenhaController implements Initializable {

    @FXML
    private TextField txEmail;
    @FXML
    private TextField txResposta;
    @FXML
    private PasswordField txSenha1;
    @FXML
    private PasswordField txSenha2;
    @FXML
    private Label lbError;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void actionCancelar(ActionEvent event) {
    }

    @FXML
    private void actionEnviar(ActionEvent event) {
    }

}
