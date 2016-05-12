package afp.gui.controladores;

import afp.modelo.Categoria;
import afp.modelo.Conta;
import afp.modelo.dao.ContaDAO;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import static javafx.print.Paper.C;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafx.scene.input.KeyCode.C;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class PrincipalController implements Initializable {

    @FXML
    private BorderPane myPane;
    @FXML
    private TableView tbvContas;
    @FXML
    private TableColumn<Conta, LocalDate> tbcData;
    @FXML
    private TableColumn<Conta, String> tbcTitulo;
    @FXML
    private TableColumn<Conta, Long> tbcValor;
    @FXML
    private TableColumn<Categoria, String> tbcCategoria;
    @FXML
    private TableColumn<Conta, LocalDate> tbcVencimento;
    @FXML
    private FlowPane detail;
    @FXML
    private Label lbTitulo;
    @FXML
    private Label lbDescricao;
    @FXML
    private Label lbData;
    @FXML
    private Label lbCategoria;
    @FXML
    private Label lbTipo;
    @FXML
    private Label lbValor;
    @FXML
    private Label lbVencimento;
    @FXML
    private Label lbQuitado;
    private ContaDAO dao;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        popularTabela(new ContaDAO().findAll());
    }

    @FXML
    private void actionSelecionar(MouseEvent event) {
        TableView.TableViewSelectionModel selectionModel = tbvContas.getSelectionModel();
        Conta conta = (Conta) selectionModel.getSelectedItem();
        
        lbTitulo.setText(conta.getTitulo());
        lbDescricao.setText(conta.getDescricao());
        lbData.setText(conta.getDtCriacao().toString());
        lbCategoria.setText(conta.getCategoria().getTitulo());
        lbTipo.setText(conta.getTipo().name());
        lbValor.setText(""+conta.getValor());
        lbVencimento.setText(conta.getDtVencimento().toString());
        lbQuitado.setText(conta.isQuitado()?"Quitado":"Pendente");
    }
    
    private void popularTabela(List<Conta> lista){
        lista.stream().forEach((c) -> {
            tbcData.setCellValueFactory(new PropertyValueFactory<>("dtCriacao"));
            tbcTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
            tbcValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
            tbcCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
            tbcVencimento.setCellValueFactory(new PropertyValueFactory<>("dtVencimento"));
        });
        tbvContas.getItems().clear();
        tbvContas.getItems().addAll(lista);
    }

    @FXML
    private void actionVerTodas(ActionEvent event) {
        popularTabela(new ContaDAO().findAll());
    }

    @FXML
    private void actionVerQuitadas(ActionEvent event) {
        popularTabela(new ContaDAO().findQuitadas());
    }

    @FXML
    private void actionVerPendentes(ActionEvent event) {
        popularTabela(new ContaDAO().findPendentes());
    }

    @FXML
    private void actionVerVencidas(ActionEvent event) {
        popularTabela(new ContaDAO().findVencidas());
    }

    @FXML
    private void actionVerPendentesVencidas(ActionEvent event) {
        popularTabela(new ContaDAO().findPendentesVencidas());
    }
}
