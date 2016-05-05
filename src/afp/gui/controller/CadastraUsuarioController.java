package afp.gui.controller;

import afp.gui.view.Navigator;
import afp.util.NavigateEnum;
import afp.util.Validator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class CadastraUsuarioController implements Initializable {

    @FXML
    private FlowPane myPane;
    @FXML
    private TextField txNome;
    @FXML
    private TextField txEmail;
    @FXML
    private PasswordField txSenha;
    @FXML
    private PasswordField txReSenha;
    @FXML
    private Label lbError;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnCadastrar;

    private ResourceBundle bundle;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bundle = rb;
        Navigator.getInstance().setContentParent(myPane);
    }

    @FXML
    private void actionCancelar(ActionEvent event) {
        Stage stg = (Stage) myPane.getScene().getWindow();
        stg.close();
    }

    @FXML
    private void actionCadastrar(ActionEvent event) {

        String nome = txNome.getText();
        String email = txEmail.getText();
        String senha = txSenha.getText();
        String resenha = txReSenha.getText();

        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || resenha.isEmpty()) {
            lbError.setText(bundle.getString("error.fieldempty"));
        } else if (!Validator.validateEmail(email)) {
            lbError.setText(bundle.getString("error.invalidemail"));
        } else if (!senha.equals(resenha)) {
            lbError.setText(bundle.getString("error.incomplatiblepasswords"));
        } else {
            Navigator.getInstance().navigateTo(NavigateEnum.PRINCIPAL, bundle);
        }
    }
}
