package afp.gui.controladores;

import afp.gui.view.Navegagor;
import afp.util.TelasEnum;
import afp.util.Validador;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

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
    private Button btnCancelar;
    @FXML
    private Button btnCadastrar;

    private ResourceBundle bundle;
    @FXML
    private ComboBox<?> cbbPerguntas;
    @FXML
    private TextField txResposta;
    @FXML
    private Label lbErro;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bundle = rb;

        ObservableList perguntas = FXCollections.observableArrayList(
                "O nome do seu melhor amigo?",
                "Qual o nome do seu primeiro(a) namorado(a)?"
        );
        cbbPerguntas.getItems().addAll(perguntas);
    }

    @FXML
    private void actionCancelar(ActionEvent event) {
        Navegagor.getInstance().navigateTo(TelasEnum.LOGIN, bundle);
    }

    @FXML
    private void actionCadastrar(ActionEvent event) {

        String nome = txNome.getText();
        String email = txEmail.getText();
        String senha = txSenha.getText();
        String resenha = txReSenha.getText();
        int pergunta = cbbPerguntas.getSelectionModel().getSelectedIndex();
        String resposta = txResposta.getText();

        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || resenha.isEmpty() || resposta.isEmpty() || pergunta >= 1) {
            lbErro.setText(bundle.getString("error.fieldempty"));
        } else if (!Validador.validateEmail(email)) {
            lbErro.setText(bundle.getString("error.invalidemail"));
        } else if (!senha.equals(resenha)) {
            lbErro.setText(bundle.getString("error.incomplatiblepasswords"));
        } else {
            Navegagor.getInstance().navigateTo(TelasEnum.PRINCIPAL, bundle);
        }

    }
}
