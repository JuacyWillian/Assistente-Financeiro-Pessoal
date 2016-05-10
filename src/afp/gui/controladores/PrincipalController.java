package afp.gui.controladores;

import afp.modelo.Conta;
import afp.modelo.dao.ContaDAO;
import java.net.URL;
import java.util.List;
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
    private TableView tbvContas;
    @FXML
    private TableColumn tbcData;
    @FXML
    private TableColumn tbcTitulo;
    @FXML
    private TableColumn tbcValor;
    @FXML
    private TableColumn tbcCategoria;
    @FXML
    private TableColumn tbcVencimento;
    @FXML
    private FlowPane fpDetail;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ContaDAO dao = new ContaDAO();
        List<Conta> list = dao.findAll();
//        list.toString();
        System.out.println(list.toString());
    }

}
