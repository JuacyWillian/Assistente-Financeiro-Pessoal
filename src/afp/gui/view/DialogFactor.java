package afp.gui.view;

import afp.modelo.Categoria;
import afp.modelo.Conta;
import afp.modelo.dao.CategoriaDAO;
import afp.util.ContaTipo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class DialogFactor {

    /**
     *
     * @param c no caso de edição de categoria, caso deseje criar uma nova este
     * campo deve ser null
     * @param rb no caso de Internacionalização
     * @return Categoria editada caso o o parametro c seja diferente de null, ou
     * uma nova caso ele seja null
     */
    public static Dialog getCategoriaDialog(Categoria c, ResourceBundle rb) {

        String title;
        double column1size = 100;
        double column2size = 200;

        Dialog<Categoria> dialog = new Dialog<>();

        TextField txTitulo = new TextField();
        txTitulo.setPrefWidth(column2size);

        Label lbTitulo = new Label("Titulo*:");
        lbTitulo.setMinWidth(column1size);
        lbTitulo.setAlignment(Pos.TOP_RIGHT);

        TextArea txDescricao = new TextArea();
        txDescricao.setPrefSize(column2size, 150);

        Label lbDescricao = new Label("Descrição:");
        lbDescricao.setMinWidth(column1size);
        lbDescricao.setAlignment(Pos.TOP_RIGHT);

        Label lbErro = new Label();
        lbErro.setMinWidth(column1size + column2size);
        lbErro.setStyle("paint: red");

        if (c != null) {
            title = "Editar Categoria";
            txTitulo.setText(c.getTitulo());
            txDescricao.setText(c.getDescricao());
        } else {
            title = "Nova Categoria:";
        }

        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(5);

        grid.add(lbTitulo, 1, 1);
        grid.add(txTitulo, 2, 1);
        grid.add(lbDescricao, 1, 2);
        grid.add(txDescricao, 2, 2);
        grid.add(lbErro, 1, 3, 2, 1);

        ButtonType btnOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType BtnCancel = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);

        dialog.getDialogPane().setContent(grid);
        dialog.getDialogPane().getButtonTypes().add(btnOK);
        dialog.getDialogPane().getButtonTypes().add(BtnCancel);

        Button btn = (Button) dialog.getDialogPane().lookupButton(btnOK);
        btn.addEventFilter(ActionEvent.ACTION, event -> {
            if (txTitulo.getText().isEmpty()) {
                lbErro.setText("Preencha todos os campos obrigatórios!");
                event.consume();
            }
        });

        dialog.setResultConverter((ButtonType b) -> {
            if (c != null) {
                c.setTitulo(txTitulo.getText());
                c.setDescricao(txDescricao.getText(0, 140));
                if (b == btnOK) {
                    return c;
                }
            } else if (b == btnOK) {
                return new Categoria(txTitulo.getText(), txDescricao.getText());
            }
            return null;
        });

        return dialog;
    }

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
            }
        });

//        Convertendo o Retorno do Dialog
        dialog.setResultConverter((ButtonType b) -> {

            List<Conta> list = new ArrayList<>();

            int parcelas = Integer.parseInt(txParcelas.getText());
            if (c != null) {
                c.setTitulo(txTitulo.getText());
                c.setDescricao(txDescricao.getText());
                c.setTipo(cbbTipo.getValue());
                c.setCategoria(cbbCategoria.getValue());
                c.setValor(Long.parseLong(txValor.getText()));
                c.setDtCriacao(dtData.getValue());
                c.setDtVencimento(dtVencimento.getValue());
                c.setQuitado(chQuitado.isSelected());

                if (b == btnOK) {
                    list.add(c);
                }
            } else {
                for (int i = 0; i < parcelas; i++) {

                    Conta conta = new Conta();
                    conta.setTitulo(txTitulo.getText() + " (" + (i + 1) + "/" + parcelas + ")");
                    conta.setDescricao(txDescricao.getText());
                    conta.setTipo(cbbTipo.getValue());
                    conta.setCategoria(cbbCategoria.getValue());
                    if (parcelas > 1) {
                        conta.setValor((Long.parseLong(txValor.getText()) / parcelas));
                    } else {
                        conta.setValor(Long.parseLong(txValor.getText()));
                    }
                    conta.setDtCriacao(dtData.getValue());
                    conta.setDtVencimento(dtVencimento.getValue().plusMonths(i));
                    conta.setQuitado(chQuitado.isSelected());

                    if (b == btnOK) {
                        list.add(conta);
                    }
                }
            }
            return list;
        });
        return dialog;
    }

    private DialogFactor() {
    }
}
