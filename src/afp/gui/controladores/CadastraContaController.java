package afp.gui.controladores;

import afp.modelo.Categoria;
import afp.modelo.Conta;
import afp.modelo.dao.ContaDao;
import afp.util.ContaTipo;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CadastraContaController implements Initializable {

    @FXML
    private TextField txTitulo;
    @FXML
    private TextArea txDescricao;
    @FXML
    private ComboBox<ContaTipo> cbbTipo;
    @FXML
    private ComboBox<Categoria> cbbCategoria;
    @FXML
    private TextField txValor;
    @FXML
    private TextField txParcelas;
    @FXML
    private DatePicker dtCriacao;
    @FXML
    private DatePicker dtVencimento;
    @FXML
    private CheckBox chbQuitado;
    private ResourceBundle bundle;
//    List<String> categorias;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bundle = rb;

        cbbTipo.getItems().addAll(ContaTipo.values());
        ObservableList<?> categorias = FXCollections.observableArrayList("Alimentação", "Serviços");
        cbbCategoria.getItems().addAll();

        dtCriacao.setValue(LocalDate.now());

    }

    @FXML
    private void actionCancelar(ActionEvent event) {
//        todo
    }

    @FXML
    private void actionEnviar(ActionEvent event) {

        String titulo = txTitulo.getText();
        String descricao = txDescricao.getText();
        ContaTipo tipo = cbbTipo.getValue();
        Categoria categoria = cbbCategoria.getValue();
        long valor = Long.parseLong(txValor.getText());
        int parcelas = Integer.parseInt(txParcelas.getText());
        LocalDate criacao = dtCriacao.getValue();
        LocalDate vencimento = dtVencimento.getValue();
        boolean quitado = chbQuitado.isSelected();

        Conta c = new Conta(titulo, descricao, categoria, tipo, valor, parcelas, criacao, vencimento, quitado);
        ContaDao.getInstance().insert(c);

//        todo
    }

//    private List<Categoria> getCategorias() {
////        List<Categoria> cats = new ArrayList<>();
////        
////        return cats;
//    }
}
