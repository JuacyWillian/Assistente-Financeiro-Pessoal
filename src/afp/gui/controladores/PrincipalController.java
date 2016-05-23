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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class PrincipalController implements Initializable {

    private ResourceBundle bundle;
    private DateTimeFormatter dateFormat;
    private NumberFormat moedaFormat;
    private Conta contaDetalhada;
    long totalDeDespesas = 0;
    long totalDeReceitas = 0;
    long saldoTotal = 0;

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
    private Label lbSituacao;
    @FXML
    private Label lbDespesas;
    @FXML
    private Label lbReceitas;
    @FXML
    private Label lbSaldo;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnExcluir;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bundle = rb;
        dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy", bundle.getLocale());
        moedaFormat = NumberFormat.getCurrencyInstance(bundle.getLocale());

        popularTabela(new ContaDAO().findAll());
        calcularValores();

        btnEditar.setDisable(true);
        btnExcluir.setDisable(true);

        tbcData.setStyle("-fx-alignment: CENTER;");
        tbcTitulo.setStyle("-fx-alignment: CENTER-LEFT;");
        tbcValor.setStyle("-fx-alignment: CENTER-RIGHT;");
        tbcCategoria.setStyle("-fx-alignment: CENTER;");
        tbcVencimento.setStyle("-fx-alignment: CENTER;");
    }

    @FXML
    private void actionSelecionar(MouseEvent event) {
        contaDetalhada = (Conta) tbvContas.getSelectionModel().getSelectedItem();

        if (contaDetalhada != null) {
            popularDetalhes(contaDetalhada);
            btnEditar.setDisable(false);
            btnExcluir.setDisable(false);
        } else {
            btnEditar.setDisable(true);
            btnExcluir.setDisable(true);
        }
    }

    /**
     * finaliza o aplicativo
     *
     * @param event
     */
    @FXML
    private void actionSair(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void actionNovaConta(ActionEvent event) {
        novaConta();
    }

    @FXML
    private void actionEditarConta(ActionEvent event) {
        if (contaDetalhada != null) {
            editarConta(contaDetalhada);
            limparDetalhes();
        }
    }

    @FXML
    private void actionExcluirConta(ActionEvent event) {
        if (contaDetalhada != null) {
            excluirConta(contaDetalhada);
            limparDetalhes();
        }
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
    private void actionVerReceitasPagas(ActionEvent event) {
        popularTabela(new ContaDAO().findReceitasQuitadas());
    }

    @FXML
    private void actionVerReceitasPendentes(ActionEvent event) {
        popularTabela(new ContaDAO().findReceitasPendentes());
    }

    @FXML
    private void actionVerReceitasVencidas(ActionEvent event) {
        popularTabela(new ContaDAO().findReceitasVencidas());
    }

    @FXML
    private void actionVerReceitasFuturas(ActionEvent event) {
        popularTabela(new ContaDAO().findReceitasFuturas());
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
    private void actionVerDespesasFuturas(ActionEvent event) {
        popularTabela(new ContaDAO().findDespesasFuturas());
    }

    @FXML
    private void actionGerenciarCategorias(ActionEvent event) {
        Dialog dialog = DialogFactor.getGerenciadorDeCategoriasDialog();
        dialog.showAndWait();
    }

    /**
     * Abre o dialogo Sobre, que exibe informações do aplicativo, bem como
     * website, desenvolvedores e licença.
     *
     * @param event
     */
    @FXML
    private void actionSobre(ActionEvent event) {
        Dialog dialog = DialogFactor.getAboutDialog();
        dialog.showAndWait();
    }

    /**
     * Dialogo de Nova Conta
     *
     * @param tipo DESPESA ou RECEITA
     */
    private void novaConta() {
        if (!new CategoriaDAO().findAll().isEmpty()) {
            Dialog dialog = DialogFactor.getContaDialog(null);
            Optional<List<Conta>> result = (Optional<List<Conta>>) dialog.showAndWait();

            if (!result.isPresent()) {
            } else {
                List<Conta> list = result.get();
                ContaDAO dao = new ContaDAO();
                list.stream().forEach((c) -> {
                    dao.insert(c);
                });
            }
            actionVerTodas(null);
            calcularValores();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Informação");
            alert.setContentText("Antes de Criar uma Conta é preciso criar uma categoria.\n Você pode fazer isso clicando em 'Editar > Gerenciar Categorias'.");
            alert.getDialogPane().setPrefSize(400, 200);

            alert.showAndWait();
        }
    }

    /**
     * Exibe um dialogo para edição da conta.
     *
     * @param conta
     */
    private void editarConta(Conta conta) {
        Dialog dialog = DialogFactor.getContaDialog(conta);
        Optional<List<Conta>> result = (Optional<List<Conta>>) dialog.showAndWait();

        if (result.isPresent()) {
            List<Conta> contas = result.get();
            contas.stream().forEach((c) -> {
                new ContaDAO().update(c);
            });
        }
        actionVerTodas(null);
        calcularValores();
    }

    /**
     * exclui a conta passada como paramero do banco de dados.
     *
     * @param conta
     */
    private void excluirConta(Conta conta) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("Você tem certeza que deseja excluir esta conta?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            new ContaDAO().delete(conta);
        }
        actionVerTodas(null);
        calcularValores();
    }

    /**
     * Popula o painel de detalhes com as informações da conta.
     *
     * @param c
     */
    private void popularDetalhes(Conta c) {
        lbTitulo.setText(c.getTitulo());
        lbDescricao.setText(c.getDescricao());
        lbData.setText(dateFormat.format(c.getDtCriacao()));
        lbCategoria.setText(c.getCategoria().getTitulo());
        lbTipo.setText(c.getTipo().name());
        lbValor.setText("RS " + moedaFormat.format(c.getValor()));
        lbVencimento.setText(dateFormat.format(c.getDtVencimento()));
        lbSituacao.setText(c.isQuitado() ? "pago" : "pendente");
    }

    /**
     * Limpa as informações do painel de detalhes.
     *
     * @param c
     */
    private void limparDetalhes() {
        contaDetalhada = null;

        lbTitulo.setText("");
        lbDescricao.setText("");
        lbData.setText("");
        lbCategoria.setText("");
        lbTipo.setText("");
        lbValor.setText("");
        lbVencimento.setText("");
        lbSituacao.setText("");
    }

    /**
     * Popula a tabela com as informações da lista
     *
     * @param lista
     */
    private void popularTabela(List<Conta> lista) {

        lista.stream().forEach((c) -> {
            tbcData.setCellValueFactory(new PropertyValueFactory<>("dtCriacao"));
            tbcData.setCellFactory(column -> {
                return new TableCell<Conta, LocalDate>() {
                    @Override
                    protected void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                            setStyle("");
                        } else {
                            // Format date.
                            setText(dateFormat.format(item));
                        }
                    }
                };
            });

            tbcTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
            tbcValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
            tbcValor.setCellFactory(column -> {
                return new TableCell<Conta, Long>() {
                    @Override
                    protected void updateItem(Long item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                            setStyle("");
                        } else {
                            // Format date.
                            setText(moedaFormat.format(item));
                        }
                    }
                };
            });
            tbcCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
            tbcVencimento.setCellValueFactory(new PropertyValueFactory<>("dtVencimento"));
            tbcVencimento.setCellFactory(column -> {
                return new TableCell<Conta, LocalDate>() {
                    @Override
                    protected void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                            setStyle("");
                        } else {
                            // Format date.
                            setText(dateFormat.format(item));
                        }
                    }
                };
            });
        });
        tbvContas.getItems().clear();
        tbvContas.getItems().addAll(lista);

    }

    /**
     * Calcula os valores de Despesas, Receitas e Saldos e apresenta para o
     * usuário, não levando em consideração despesas ou receitas futuras.
     */
    private void calcularValores() {
        List<Conta> list = new ContaDAO().findAll();
        totalDeDespesas = 0;
        totalDeReceitas = 0;
        list.stream().forEach((c) -> {
            if (c.getDtVencimento().getMonth().compareTo(LocalDate.now().getMonth()) <= 0) {

                if (c.getTipo() == ContaTipo.DESPESA) {
                    totalDeDespesas += c.getValor();
                } else if (c.getTipo() == ContaTipo.RECEITA) {
                    totalDeReceitas += c.getValor();
                }

            }
        });

        lbDespesas.setText("R$ " + moedaFormat.format(totalDeDespesas));
        lbReceitas.setText("R$ " + moedaFormat.format(totalDeReceitas));
        lbSaldo.setText("R$ " + moedaFormat.format(totalDeReceitas - totalDeDespesas));
    }
}
