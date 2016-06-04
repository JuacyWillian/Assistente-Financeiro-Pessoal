package afp.gui.view;

import afp.modelo.Categoria;
import afp.modelo.Conta;
import afp.modelo.dao.CategoriaDAO;
import afp.modelo.dao.ContaDAO;
import afp.util.ContaTipo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class DialogFactor {

    private static final String DEVELOPPERS = "Juacy Willian, Adolpho Santos, Rafael Oliveira";
    private static final String VERSION = "1.0b";
    private static final String LICENCA = "GNU General Public License v3";

    /**
     *
     * @param c null para criar nova Conta, ou uma conta caso deseje editar uma
     * já existente
     * @param ct Tipo de conta, RECEITA ou DESPESA, não pode ser null
     * @param rb no caso de Internacionalização, pode ser null
     * @return Conta nova ou editada
     */
    public static Dialog getContaDialog(Conta c) {

        double column1size = 150.0;
        double column2size = 300.0;

        Dialog<List<Conta>> dialog = new Dialog();

        TextField txTitulo = new TextField();
        txTitulo.setMaxWidth(column2size);

        TextArea txDescricao = new TextArea();
        txDescricao.setMaxWidth(column2size);

        TextField txValor = new TextField();
        txValor.setMaxWidth(column2size);
        txValor.setText("" + 0);

        TextField txParcelas = new TextField();
        txParcelas.setMaxWidth(column2size);
        txParcelas.setText("" + 1);

        ComboBox<Categoria> cbbCategoria = new ComboBox<>();
        cbbCategoria.setMaxWidth(column2size);
        cbbCategoria.setPromptText("Selecione uma categoria...");
        cbbCategoria.getItems().addAll(new CategoriaDAO().findAll());

        ComboBox<ContaTipo> cbbTipo = new ComboBox<>();
        cbbTipo.setMaxWidth(column2size);
        cbbTipo.setPromptText("Selecione um tipo...");
        cbbTipo.getItems().addAll(ContaTipo.values());

        DatePicker dtData = new DatePicker(LocalDate.now());
        dtData.setMaxWidth(column2size);

        DatePicker dtVencimento = new DatePicker();
        dtVencimento.setMaxWidth(column2size);

        CheckBox chQuitado = new CheckBox("Pago!");
        chQuitado.setMaxWidth(column2size);

        ButtonType btnOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType btnCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);

        Label lbTitulo = new Label("Título*:");
        lbTitulo.setMinWidth(column1size);
        lbTitulo.setAlignment(Pos.TOP_RIGHT);

        Label lbDescricao = new Label("Descricao");
        lbDescricao.setMinWidth(column1size);
        lbDescricao.setAlignment(Pos.TOP_RIGHT);

        Label lbTipo = new Label("Tipo*:");
        lbTipo.setMinWidth(column1size);
        lbTipo.setAlignment(Pos.TOP_RIGHT);

        Label lbCategoria = new Label("Categoria*:");
        lbCategoria.setMinWidth(column1size);
        lbCategoria.setAlignment(Pos.TOP_RIGHT);

        Label lbValor = new Label("Valor*:");
        lbValor.setMinWidth(column1size);
        lbValor.setAlignment(Pos.TOP_RIGHT);

        Label lbParcelas = new Label("Parcelas*:");
        lbParcelas.setMinWidth(column1size);
        lbParcelas.setAlignment(Pos.TOP_RIGHT);

        Label lbData = new Label("Data da Conta*:");
        lbData.setMinWidth(column1size);
        lbData.setAlignment(Pos.TOP_RIGHT);

        Label lbVencimento = new Label("Data do Vencimento*:");
        lbVencimento.setMinWidth(column1size);
        lbVencimento.setAlignment(Pos.TOP_RIGHT);

        Label lbQuitado = new Label("Situação da Conta:");
        lbQuitado.setMinWidth(column1size);
        lbQuitado.setAlignment(Pos.TOP_RIGHT);

        Label lbErro = new Label();
        lbErro.setMinWidth(column1size + column2size);
        lbErro.setAlignment(Pos.CENTER);
        lbErro.setStyle("-fx-text-fill: RED;");

        if (c != null) {
            dialog.setTitle("Editar Conta");

            txTitulo.setText(c.getTitulo());
            txDescricao.setText(c.getDescricao());
            cbbCategoria.setValue(c.getCategoria());
            cbbTipo.setValue(c.getTipo());
            cbbTipo.setDisable(false);
            txValor.setText("" + c.getValor());
            dtData.setValue(c.getDtCriacao());
            dtVencimento.setValue(c.getDtVencimento());
            chQuitado.setSelected(c.isQuitado());

            txParcelas.setVisible(false);
        } else {
            dialog.setTitle("Nova Conta");
        }

        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(5);

        grid.add(lbTitulo, 1, 1);
        grid.add(txTitulo, 2, 1);

        grid.add(lbDescricao, 1, 2);
        grid.add(txDescricao, 2, 2);

        grid.add(lbTipo, 1, 3);
        grid.add(cbbTipo, 2, 3);

        grid.add(lbCategoria, 1, 4);
        grid.add(cbbCategoria, 2, 4);

        grid.add(lbValor, 1, 5);
        grid.add(txValor, 2, 5);

        grid.add(lbParcelas, 1, 6);
        grid.add(txParcelas, 2, 6);

        grid.add(lbData, 1, 7);
        grid.add(dtData, 2, 7);

        grid.add(lbVencimento, 1, 8);
        grid.add(dtVencimento, 2, 8);

        grid.add(lbQuitado, 1, 9);
        grid.add(chQuitado, 2, 9);

        grid.add(lbErro, 1, 10, 2, 1);

        dialog.getDialogPane().setContent(grid);

        dialog.getDialogPane().getButtonTypes().add(btnOK);
        dialog.getDialogPane().getButtonTypes().add(btnCancelar);

////        Validando os Campos do Dialog
        Button btn = (Button) dialog.getDialogPane().lookupButton(btnOK);
        btn.addEventFilter(ActionEvent.ACTION, (ActionEvent event) -> {

            if (dtData.getValue() == null
                    || txTitulo.getText().isEmpty()
                    || cbbTipo.getSelectionModel().getSelectedItem() == null
                    || cbbCategoria.getSelectionModel().getSelectedItem() == null
                    || dtVencimento.getValue() == null
                    || txValor.getText().isEmpty()) {

                lbErro.setText("Preencha todos os campor obrigatórios!");
                event.consume();

            } else if (dtData.getValue().isAfter(dtVencimento.getValue())) {

                lbErro.setText("A data da compra não pode ser depois da data de vencimento!");
                event.consume();

            } else if ((Double.parseDouble(txValor.getText())) < 0) {

                lbErro.setText("A conta não pode ter um valor negativo");
                event.consume();

            }
        });

//        Convertendo o Retorno do Dialog
        dialog.setResultConverter((ButtonType b) -> {

            List<Conta> list = new ArrayList<>();
            int parcelas = Integer.parseInt(txParcelas.getText());

            if (b == btnOK) {
                if (c != null) {

                    c.setTitulo(txTitulo.getText());
                    c.setDescricao(txDescricao.getText());
                    c.setTipo(cbbTipo.getValue());
                    c.setCategoria(cbbCategoria.getValue());
                    c.setValor(Double.parseDouble(txValor.getText()));
                    c.setDtCriacao(dtData.getValue());
                    c.setDtVencimento(dtVencimento.getValue());
                    c.setQuitado(chQuitado.isSelected());
                    list.add(c);

                } else {
                    for (int i = 0; i < parcelas; i++) {

                        Conta conta = new Conta();
                        if (parcelas == 1) {
                            conta.setTitulo(txTitulo.getText());
                        } else {
                            conta.setTitulo(txTitulo.getText() + " (" + (i + 1) + "/" + parcelas + ")");
                        }
                        conta.setDescricao(txDescricao.getText());
                        conta.setTipo(cbbTipo.getValue());
                        conta.setCategoria(cbbCategoria.getValue());
                        if (parcelas > 1) {
                            double valor = (Double.parseDouble(txValor.getText()));
                            double valorDaParcela = valor / parcelas;
                            double excedente = valor - (valorDaParcela * parcelas);
                            
                            if (i==0){
                                conta.setValor(valorDaParcela+excedente);
                            }else{
                                conta.setValor(valorDaParcela);
                            }
                        } else {
                            conta.setValor(Double.parseDouble(txValor.getText()));
                        }
                        conta.setDtCriacao(dtData.getValue());
                        conta.setDtVencimento(dtVencimento.getValue().plusMonths(i));
                        conta.setQuitado(chQuitado.isSelected());

                        if (b == btnOK) {
                            list.add(conta);
                        } else if (b == btnCancelar) {
                            dialog.close();
                        }
                    }
                }
            } else if (b == btnCancelar) {
                dialog.setResult(list);
                dialog.close();
            }

            return list;
        });
        return dialog;
    }

    /**
     * @return Retorna o Dialogo de Gerenciamento de Categorias
     */
    public static Dialog getGerenciadorDeCategoriasDialog() {
        Dialog dialog = new Dialog();
        String erro_message = "O titulo deve ser preenchido.";

        List<Categoria> categorias = new CategoriaDAO().findAll();
        ObservableList<Categoria> data = FXCollections.observableArrayList(categorias);

        ListView view = new ListView(data);

        Label lbTitulo = new Label("Titulo:");
        Label lbDescricao = new Label("Descrição:");
        Label lbErro = new Label("");
        lbErro.setAlignment(Pos.CENTER);
        lbErro.setPrefWidth(400);

        TextField txTitulo = new TextField();
        txTitulo.setPrefWidth(400);
        txTitulo.setDisable(true);

        TextArea txDescricao = new TextArea();
        txDescricao.setPrefWidth(400);
        txDescricao.setDisable(true);

        Button editar = new Button("Editar");
        editar.setDisable(true);

        Button excluir = new Button("Excluir");
        excluir.setDisable(true);

        Button nova = new Button("Nova");

        view.setOnMouseClicked((event) -> {
            Categoria cat = (Categoria) view.getSelectionModel().getSelectedItem();
            if (cat != null) {
                txTitulo.setText(cat.getTitulo());
                txDescricao.setText(cat.getDescricao());

                txTitulo.setDisable(true);
                txDescricao.setDisable(true);

                editar.setDisable(false);
                excluir.setDisable(false);
            } else {
                editar.setDisable(true);
                excluir.setDisable(true);
            }
        });

        excluir.setOnAction((e) -> {

            if ("Excluir".equals(excluir.getText())) {

                Categoria cat = (Categoria) view.getSelectionModel().getSelectedItem();
                if (cat != null) {
                    if (new ContaDAO().findByCategoria(cat).size() <= 0) {

                        new CategoriaDAO().delete(cat);

                        view.getItems().clear();
                        view.getItems().addAll(new CategoriaDAO().findAll());
                        view.getSelectionModel().select(null);

                    } else {

                        e.consume();

                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText("Informação");
                        alert.setContentText("Você não pode excluir esta categoria, pois tem contas associadas à ela!");
                        alert.getDialogPane().setPrefSize(400, 200);

                        alert.showAndWait();
                    }
                }

            } else if ("Cancelar".equals(excluir.getText())) {

                txTitulo.setText("");
                txDescricao.setText("");

                txTitulo.setDisable(true);
                txDescricao.setDisable(true);

                nova.setText("Nova");
                excluir.setText("Excluir");
                editar.setText("Editar");

                nova.setDisable(false);
                editar.setDisable(true);
                excluir.setDisable(true);

                view.getItems().clear();
                view.getItems().addAll(new CategoriaDAO().findAll());
                view.getSelectionModel().select(null);

            }
        });

        editar.setOnAction((e) -> {
            if ("Salvar".equals(editar.getText())) {
                if (!txTitulo.getText().isEmpty()) {

                    Categoria cat = (Categoria) view.getSelectionModel().getSelectedItem();
                    cat.setTitulo(txTitulo.getText());
                    cat.setDescricao(txDescricao.getText());

                    new CategoriaDAO().update(cat);

                    txTitulo.setDisable(true);
                    txDescricao.setDisable(true);

                    editar.setText("Editar");
                    excluir.setText("Excluir");
                    nova.setDisable(false);

                    view.getItems().clear();
                    view.getItems().addAll(new CategoriaDAO().findAll());
                    view.getSelectionModel().select(null);

                } else {
                    lbErro.setText(erro_message);
                }

            } else if ("Editar".equals(editar.getText())) {

                txTitulo.setDisable(false);
                txDescricao.setDisable(false);

                editar.setText("Salvar");
                excluir.setText("Cancelar");

                nova.setDisable(true);
                excluir.setDisable(true);

            }

        });
        nova.setOnAction((e) -> {
            if ("Salvar".equals(nova.getText())) {

                if (!txTitulo.getText().isEmpty()) {
                    Categoria cat = new Categoria();
                    cat.setTitulo(txTitulo.getText());
                    cat.setDescricao(txDescricao.getText());

                    new CategoriaDAO().insert(cat);

                    view.getItems().clear();
                    view.getItems().addAll(new CategoriaDAO().findAll());
                    view.getSelectionModel().select(null);

                    excluir.setText("Excluir");
                    nova.setText("Nova");

                    editar.setDisable(false);
                    excluir.setDisable(false);
                    nova.setDisable(false);

                    txTitulo.setDisable(true);
                    txDescricao.setDisable(true);
                } else {
                    lbErro.setText(erro_message);
                }

            } else if ("Nova".equals(nova.getText())) {

                txTitulo.setDisable(false);
                txTitulo.setText("");

                txDescricao.setDisable(false);
                txDescricao.setText("");

                editar.setDisable(true);
                excluir.setDisable(false);
                excluir.setText("Cancelar");
                nova.setText("Salvar");

                view.getItems().clear();
                view.getItems().addAll(new CategoriaDAO().findAll());
                view.getSelectionModel().select(null);
            }

        });

        ButtonBar bBar = new ButtonBar();
        bBar.getButtons().addAll(excluir, editar, nova);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(view, 0, 0, 1, 5);
        grid.add(lbTitulo, 1, 0);
        grid.add(txTitulo, 1, 1);
        grid.add(lbDescricao, 1, 2);
        grid.add(txDescricao, 1, 3);
        grid.add(lbErro, 1, 4);
        grid.add(bBar, 1, 5);

        ButtonType btnCancelar = new ButtonType("Fechar", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().setContent(grid);
        dialog.getDialogPane().getButtonTypes().add(btnCancelar);

        return dialog;
    }

    /**
     * @return Retorna o Dialogo sobre
     */
    public static Dialog getAboutDialog() {
        Dialog dialog = new Dialog();

        ImageView imgv = new ImageView(new Image("res/logo.jpg"));

        StringBuilder info = new StringBuilder();

        String descricao = "O Assistente Financeiro Pessoal tem como principal objetivo "
                + "ajudar o usuário a fazer um uso adequado do seu dinheiro, "
                + "permitindo a satisfação de suas necessidades de acordo "
                + "com as suas prioridades.";

        Label lbDescricao = new Label(descricao);
        lbDescricao.setStyle("-fx-text-alignment: JUSTIFY;");
        lbDescricao.setPadding(new Insets(10));
        lbDescricao.setPrefWidth(400);
        lbDescricao.setWrapText(true);

        Label lbVersao = new Label("Versão: \n" + VERSION);
        lbVersao.setStyle("-fx-text-alignment: JUSTIFY;");
        lbVersao.setPadding(new Insets(3));
        lbVersao.setWrapText(true);

        Label lbDesenvolvedores = new Label("Desenvolvedores: \n" + DEVELOPPERS);
        lbDesenvolvedores.setStyle("-fx-text-alignment: JUSTIFY;");
        lbDesenvolvedores.setPadding(new Insets(3));
        lbDesenvolvedores.setWrapText(false);

        Label lbLicensa = new Label("Licença: \n" + LICENCA);
        lbLicensa.setStyle("-fx-text-alignment: JUSTIFY;");
        lbLicensa.setPadding(new Insets(3));
        lbLicensa.setWrapText(false);

        GridPane grid = new GridPane();
        grid.add(imgv, 0, 0, 2, 1);
        grid.add(lbDescricao, 0, 1, 2, 1);
        grid.add(lbVersao, 0, 2, 2, 1);
        grid.add(lbDesenvolvedores, 0, 3, 2, 1);
        grid.add(lbLicensa, 0, 4, 2, 1);

        ButtonType btnFechar = new ButtonType("Fechar", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().setContent(grid);
        dialog.getDialogPane().getButtonTypes().add(btnFechar);
        dialog.setResizable(false);

        return dialog;
    }

    private DialogFactor() {
    }
}
