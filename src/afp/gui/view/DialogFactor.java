package afp.gui.view;

import afp.modelo.Categoria;
import afp.modelo.Conta;
import afp.modelo.dao.CategoriaDAO;
import afp.util.ContaTipo;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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

        TextField txTitulo = new TextField();
        TextArea txDescricao = new TextArea();
        Label lbErro = new Label();

        if (c != null) {
            title = "Editar Categoria";
            txTitulo.setText(c.getTitulo());
            txDescricao.setText(c.getDescricao());

        } else {
            title = "Nova Categoria";
        }

        Dialog<Categoria> dialog = new Dialog<>();
        dialog.setTitle(title);
        dialog.setResizable(false);

        Label lbTitulo = new Label("Titulo*:");
        Label lbDescricao = new Label("Descrição:");
        txDescricao.setMaxHeight(200.0);

        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(5);

        grid.add(lbTitulo, 1, 1);
        grid.add(txTitulo, 2, 1);
        grid.add(lbDescricao, 1, 2);
        grid.add(txDescricao, 2, 2);
        grid.add(lbErro, 2, 3);

        dialog.getDialogPane().setContent(grid);

        ButtonType btnOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType BtnCancel = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().add(btnOK);
        dialog.getDialogPane().getButtonTypes().add(BtnCancel);

        // Validador dos dados inseridos, verifica se o campo Titulo está vazio
        // Caso esteja, ele anula o evento do botao OK
        // Como o campo descricao não é obrigatório, ele não é verificado!
        Button btn = (Button) dialog.getDialogPane().lookupButton(btnOK);
        btn.addEventFilter(ActionEvent.ACTION, event -> {
            if (txTitulo.getText().isEmpty()) {
                lbErro.setText("Insira um Título.");
                event.consume();
            }
        });

        // Converte o retorno do dialogo no momento que o Botao OK é pressionado
        // para retornar uma Categoria
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
    public static Dialog getContaDialog(Conta c, ContaTipo ct, ResourceBundle rb) {
        String title;

        TextField txTitulo = new TextField();
        TextArea txDescricao = new TextArea();
        ComboBox<Categoria> cbbCategoria = new ComboBox<>();
        ComboBox<ContaTipo> cbbtipo = new ComboBox<>();
        TextField txValor = new TextField() {
            @Override
            public void replaceText(int start, int end, String text) {
                // If the replaced text would end up being invalid, then simply
                // ignore this call!
                if (!text.matches("[a-z]")) {
                    super.replaceText(start, end, text);
                }
            }

            @Override
            public void replaceSelection(String text) {
                if (!text.matches("[a-z]")) {
                    super.replaceSelection(text);
                }
            }
        };

        DatePicker dtCriacao = new DatePicker(LocalDate.now());
        DatePicker dtVencimento = new DatePicker();
        CheckBox cbQuitado = new CheckBox();
        List<Categoria> cats = new CategoriaDAO().findAll();
        cbbCategoria.getItems().addAll(cats);
        cbbtipo.getItems().addAll(ContaTipo.values());

        cbbCategoria.setPromptText("Selecione uma categoria...");
        cbbtipo.setPromptText("Selecione um tipo...");

        if (c != null) {
            title = "Editar Conta";
            txTitulo.setText(c.getTitulo());
            txDescricao.setText(c.getDescricao());
            cbbCategoria.setValue(c.getCategoria());
            txValor.setText("" + c.getValor());
            dtCriacao.setValue(c.getDtCriacao());
            dtVencimento.setValue(c.getDtVencimento());
            cbQuitado.setSelected(c.isQuitado());
        } else {
            title = "Nova Conta";
        }
        cbbtipo.setValue(ct);
        cbbtipo.setDisable(true);

        Dialog<Conta> dialog = new Dialog<>();
        dialog.setTitle(title);
        dialog.setResizable(false);

        Label lbTitulo = new Label("Título*:");
        Label lbDescricao = new Label("Descricao");
        Label lbTipo = new Label("Tipo*:");
        Label lbCategoria = new Label("Categoria*:");
        Label lbValor = new Label("Valor*:");
        Label lbCriacao = new Label("Data da Conta*:");
        Label lbVencimento = new Label("Data do Vencimento*:");
        Label lbQuitado = new Label("Situação da Conta:");
        Label lbErro = new Label();

        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(5);
//        grid.setPadding(new Insets(5));

        grid.add(lbTitulo, 1, 1);
        grid.add(txTitulo, 2, 1);

        grid.add(lbDescricao, 1, 2);
        grid.add(txDescricao, 2, 2);

        grid.add(lbTipo, 1, 3);
        grid.add(cbbtipo, 2, 3);

        grid.add(lbCategoria, 1, 4);
        grid.add(cbbCategoria, 2, 4);

        grid.add(lbValor, 1, 5);
        grid.add(txValor, 2, 5);

        grid.add(lbCriacao, 1, 6);
        grid.add(dtCriacao, 2, 6);

        grid.add(lbVencimento, 1, 7);
        grid.add(dtVencimento, 2, 7);

        grid.add(lbQuitado, 1, 8);
        grid.add(cbQuitado, 2, 8);

        grid.add(lbErro, 1, 9, 2, 1);

        dialog.getDialogPane().setContent(grid);

        ButtonType btnOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType BtnCancel = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().add(btnOK);
        dialog.getDialogPane().getButtonTypes().add(BtnCancel);

        Button btn = (Button) dialog.getDialogPane().lookupButton(btnOK);
        btn.addEventFilter(ActionEvent.ACTION, (ActionEvent event) -> {
            if (dtCriacao.getValue() == null
                    || txTitulo.getText().isEmpty()
                    || cbbtipo.getSelectionModel().getSelectedItem() == null
                    || cbbCategoria.getSelectionModel().getSelectedItem() == null
                    || dtVencimento.getValue() == null
                    || txValor.getText().isEmpty()) {
                lbErro.setText("Preencha todos os campor obrigatórios!");
                event.consume();
            }
        });

        dialog.setResultConverter((ButtonType b) -> {

            if (c != null) {
                c.setTitulo(txTitulo.getText());
                c.setDescricao(txDescricao.getText());
                c.setTipo(cbbtipo.getValue());
                c.setCategoria(cbbCategoria.getValue());
                c.setValor(Long.parseLong(txValor.getText()));
                c.setDtCriacao(dtCriacao.getValue());
                c.setDtVencimento(dtVencimento.getValue());
                c.setQuitado(cbQuitado.isSelected());

                if (b == btnOK) {
                    return c;
                }

            } else {

                Conta conta = new Conta();
                conta.setTitulo(txTitulo.getText());
                conta.setDescricao(txDescricao.getText());
                conta.setTipo(cbbtipo.getValue());
                conta.setCategoria(cbbCategoria.getValue());
                conta.setValor(Long.parseLong(txValor.getText()));
                conta.setDtCriacao(dtCriacao.getValue());
                conta.setDtVencimento(dtVencimento.getValue());
                conta.setQuitado(cbQuitado.isSelected());

                if (b == btnOK) {
                    return conta;
                }
            }
            return null;
        });

        return dialog;
    }

    private DialogFactor() {
    }
}
