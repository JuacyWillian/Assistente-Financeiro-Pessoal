package afp.gui.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class PrincipalController implements Initializable {

    @FXML
    private BorderPane myPane;
    @FXML
    private TableView<?> tbvContas;
    @FXML
    private TableColumn<?, ?> tbcData;
    @FXML
    private TableColumn<?, ?> tcbTitulo;
    @FXML
    private TableColumn<?, ?> tcbValor;
    @FXML
    private TableColumn<?, ?> tcbCategoria;
    @FXML
    private TableColumn<?, ?> tcbVencimento;
    @FXML
    private FlowPane fpDetail;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
