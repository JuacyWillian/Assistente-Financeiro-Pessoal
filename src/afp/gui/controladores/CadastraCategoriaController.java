package afp.gui.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class CadastraCategoriaController implements Initializable {

    @FXML
    private FlowPane myPane;
    @FXML
    private TextField txNome;
    @FXML
    private TextArea txDescricao;
    @FXML
    private Label lbErro;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void actionCancelar(ActionEvent event) {
    }

    @FXML
    private void actionCriar(ActionEvent event) {
    }
}
