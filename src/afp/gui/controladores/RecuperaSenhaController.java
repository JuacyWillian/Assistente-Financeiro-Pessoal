package afp.gui.controladores;

import afp.gui.view.Navegagor;
import afp.util.TelasEnum;
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
    private Label lbErro;
    private ResourceBundle bundle;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bundle = rb;
    }

    @FXML
    private void actionCancelar(ActionEvent event) {
        Navegagor.getInstance().navigateTo(TelasEnum.LOGIN, bundle);
    }

    @FXML
    private void actionEnviar(ActionEvent event) {

        String email = txEmail.getText();
        String resposta = txResposta.getText();
        String senha1 = txSenha1.getText();
        String senha2 = txSenha2.getText();

        if (email.isEmpty() || resposta.isEmpty() || senha1.isEmpty() || senha2.isEmpty()) {
            lbErro.setText(bundle.getString("erro.campovazio"));
        } else if (true) {
//            todo
        }
    }

}
