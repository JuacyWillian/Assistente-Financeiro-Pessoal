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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        popularTabela(new ContaDAO().findAll());
    }

    @FXML
    private void actionSelecionar(MouseEvent event) {
        popularDetalhes((Conta) tbvContas.getSelectionModel().getSelectedItem());
    }

    private void popularDetalhes(Conta c) {

        lbTitulo.setText(c.getTitulo());
        lbDescricao.setText(c.getDescricao());
        lbData.setText(c.getDtCriacao().toString());
        lbCategoria.setText(c.getCategoria().getTitulo());
        lbTipo.setText(c.getTipo().name());
        lbValor.setText("" + c.getValor());
        lbVencimento.setText(c.getDtVencimento().toString());
        lbQuitado.setText(c.isQuitado() ? "Quitado" : "Pendente");
    }

    private void popularTabela(List<Conta> lista) {
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
    private void actionVerReceitas(ActionEvent event) {
        popularTabela(new ContaDAO().findAllReceitas());
    }

    @FXML
    private void actionVerDespesas(ActionEvent event) {
        popularTabela(new ContaDAO().findAllDespesas());
    }

    @FXML
    private void actionVerDespesasQuitadas(ActionEvent event) {
        popularTabela(new ContaDAO().findDespesasQuitadas());
    }

    @FXML
    private void actionVerDespesasPendentes(ActionEvent event) {
        popularTabela(new ContaDAO().findDespesasPendentes());
    }

    @FXML
    private void actionVerDespesasVencidas(ActionEvent event) {
        popularTabela(new ContaDAO().findDespesasVencidas());
    }

    @FXML
    private void actionVerDespesasPendentesVencidas(ActionEvent event) {
        popularTabela(new ContaDAO().findDespesasPendentesVencidas());
    }

    @FXML
    private void actionNovaReceita(ActionEvent event) {
//        todo nova receita
    }

    @FXML
    private void actionNovaDespesa(ActionEvent event) {
//        todo nova despesa
    }

    @FXML
    private void actionNovaCategoria(ActionEvent event) {
//        todo nova categoria
    }

    @FXML
    private void actionSobre(ActionEvent event) {
//        todo sobre
    }

    @FXML
    private void actionSair(ActionEvent event) {
        System.exit(0);
    }
}
