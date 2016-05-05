package afp.gui.controller;

import afp.gui.view.Navigator;
import afp.util.NavigateEnum;
import afp.util.Validator;
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
    private Label lbError;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnCadastrar;

    private ResourceBundle bundle;
    @FXML
    private ComboBox<?> cbbPerguntas;
    @FXML
    private TextField txResposta;

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
        Navigator.getInstance().navigateTo(NavigateEnum.LOGIN, bundle);
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
