package afp.gui.controladores;

import afp.modelo.Categoria;
import afp.modelo.Conta;
import afp.modelo.dao.ContaDAO;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
        ObservableList obsList = FXCollections.observableArrayList(dao.findAll());
        
        tbcData.setCellValueFactory(new PropertyValueFactory<>("dtCriacao"));
        tbcTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        tbcCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tbcValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        tbcVencimento.setCellValueFactory(new PropertyValueFactory<>("dtVencimento"));
        
        tbvContas.setItems(obsList);
    }

}
