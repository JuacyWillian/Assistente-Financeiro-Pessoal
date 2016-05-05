package afp.gui.controller;

import afp.gui.view.Navigator;
import afp.util.NavigateEnum;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class LoginController implements Initializable {

    @FXML
    private TextField txUsername;
    @FXML
    private PasswordField txPassword;
    @FXML
    private CheckBox chbRemember;
    @FXML
    private Label lbErro;
    @FXML
    private Pane myPane;

    private ResourceBundle bundle;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bundle = rb;
    }

    @FXML
    private void acrionCadastrarUsuario(ActionEvent event) {
        Navigator.getInstance().navigateTo(NavigateEnum.REGISTRA_USUARIO, bundle);
    }

    @FXML
    private void actionRecuperarSenha(ActionEvent event) {
        Navigator.getInstance().navigateTo(NavigateEnum.RECUPERA_SENHA, bundle);
    }

    @FXML
    private void actionCancelar(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void actionLogar(ActionEvent event) {
        String username = txUsername.getText();
        String senha = txPassword.getText();

        if (username.isEmpty() || senha.isEmpty()) {
            lbErro.setText(bundle.getString("erro.campovazio"));
        }

        if ("admin".equals(username) && "root".equals(senha)) {
            if (chbRemember.isSelected()) {
//                todo: remember action
            }
            Navigator.getInstance().navigateTo(NavigateEnum.PRINCIPAL, bundle);

        } else {
            lbErro.setVisible(true);
        }
    }
}
