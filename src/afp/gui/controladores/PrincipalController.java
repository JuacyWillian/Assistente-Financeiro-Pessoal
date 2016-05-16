package afp.gui.controladores;

import afp.gui.view.DialogFactor;
import afp.modelo.Categoria;
import afp.modelo.Conta;
import afp.modelo.dao.CategoriaDAO;
import afp.modelo.dao.ContaDAO;
import afp.util.ContaTipo;
import java.net.URL;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Dialog;
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
    private ResourceBundle bundle;
    private NumberFormat moedaFormatter;
    private DateTimeFormatter dateFormatter;
    private DateTimeFormatter dateFormat;
    private NumberFormat moedaFormat;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        bundle = rb;
        popularTabela(new ContaDAO().findAll());
        dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy", bundle.getLocale());
        moedaFormat = NumberFormat.getCurrencyInstance(bundle.getLocale());
    }

    @FXML
    private void actionSelecionar(MouseEvent event) {
        popularDetalhes((Conta) tbvContas.getSelectionModel().getSelectedItem());
    }

    private void popularDetalhes(Conta c) {
        lbTitulo.setText(c.getTitulo());
        lbDescricao.setText(c.getDescricao());
        lbData.setText(c.getDtCriacao().format(dateFormat));
        lbCategoria.setText(c.getCategoria().getTitulo());
        lbTipo.setText(c.getTipo().name());
        lbValor.setText("" + moedaFormat.format(c.getValor()));
        lbVencimento.setText(c.getDtCriacao().format(dateFormat));
        lbQuitado.setText(c.isQuitado() ? bundle.getString("quitado") : bundle.getString("pendente"));
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
        Dialog dialog = DialogFactor.getContaDialog(null, ContaTipo.RECEITA, bundle);
        Optional<Conta> result = (Optional<Conta>) dialog.showAndWait();

        if (result.isPresent()) {
            new ContaDAO().insert(result.get());
        }
    }

    @FXML
    private void actionNovaDespesa(ActionEvent event) {
        Dialog dialog = DialogFactor.getContaDialog(null, ContaTipo.DESPESA, bundle);
        Optional<List<Conta>> result = (Optional<List<Conta>>) dialog.showAndWait();

        if (result.isPresent()) {
            List<Conta> list = result.get();
            int max = list.size();
            
            list.stream().forEach((c)->{
                
            });
        }
        
        
    }

    @FXML
    private void actionNovaCategoria(ActionEvent event) {
        Dialog dialog = DialogFactor.getCategoriaDialog(null, bundle);
        Optional<Categoria> result = (Optional<Categoria>) dialog.showAndWait();

        if (result.isPresent()) {
            new CategoriaDAO().insert(result.get());
        }
    }

    @FXML
    private void actionSobre(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Assistente Financeiro Pessoal");
        alert.setHeaderText("Information Alert");
        String s = "This is an example of JavaFX 8 Dialogs... ";
        alert.setContentText(s);
        alert.show();
//        todo sobre
    }

    @FXML
    private void actionSair(ActionEvent event) {
        System.exit(0);
    }
}
