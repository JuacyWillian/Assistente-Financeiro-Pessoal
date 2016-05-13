package afp.gui.view;

import afp.modelo.Categoria;
import afp.modelo.Conta;
import afp.modelo.dao.CategoriaDAO;
import afp.util.ContaTipo;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
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

    private DialogFactor() {}
    
    public static Dialog getCategoriaDialog(Categoria c, ResourceBundle rb){
        String title;
        
        TextField txTitulo = new TextField();
        TextArea txDescricao = new TextArea();
        
        if(c!=null){
            title = rb.getString("categoria.dialog.tituloeditar");
            txTitulo.setText(c.getTitulo());
            txDescricao.setText(c.getDescricao());
        }else{
            title = rb.getString("categoria.dialog.titulonova");
        }
        
        
        Dialog<Categoria> dialog = new Dialog<>();
        dialog.setTitle(title);
        dialog.setResizable(false);

        Label lbTitulo = new Label(rb.getString("categoria.dialog.titulo"));
        Label lbDescricao = new Label(rb.getString("categoria.dialog.descricao"));
        txDescricao.setMaxHeight(200.0);

        GridPane grid = new GridPane();
        grid.add(lbTitulo, 1, 1);
        grid.add(txTitulo, 2, 1);
        grid.add(lbDescricao, 1, 2);
        grid.add(txDescricao, 2, 2);
        dialog.getDialogPane().setContent(grid);

        ButtonType btnOK = new ButtonType(rb.getString("categoria.dialog.ok"), ButtonBar.ButtonData.OK_DONE);
        ButtonType btnCancel = new ButtonType(rb.getString("categoria.dialog.cancelar"), ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().add(btnOK);
        dialog.getDialogPane().getButtonTypes().add(btnCancel);
        

        dialog.setResultConverter((ButtonType b) -> {
            if (c!=null){
                c.setTitulo(txTitulo.getText());
                c.setDescricao(txDescricao.getText(0, 140));
                if (b == btnOK) return c;
            }else{
                if (b == btnOK) return new Categoria(txTitulo.getText(), txDescricao.getText());
            }
            return null;
        });

        return dialog;
    }

    public static Dialog getContaDialog(Conta c, ContaTipo ct, ResourceBundle rb){
        String title;
        
        TextField txTitulo = new TextField();
        TextArea txDescricao = new TextArea();
        ComboBox<Categoria> cbbCategoria = new ComboBox<>();
        ComboBox<ContaTipo> cbbtipo = new ComboBox<>();
        TextField txValor = new TextField();
        DatePicker dtCriacao = new DatePicker(LocalDate.now());
        DatePicker dtVencimento = new DatePicker();
        CheckBox cbQuitado = new CheckBox("Quitado");
        
        
        if(c!=null){
            title = rb.getString("categoria.dialog.tituloeditar");
            txTitulo.setText(c.getTitulo());
            txDescricao.setText(c.getDescricao());
            List<Categoria> cats = new CategoriaDAO().findAll();
            cbbCategoria.getItems().addAll(cats);
        }else{
            title = rb.getString("categoria.dialog.titulonova");
        }
        
        
        Dialog<Conta> dialog = new Dialog<>();
        dialog.setTitle(title);
        dialog.setResizable(false);

        Label lbTitulo = new Label(rb.getString("categoria.dialog.titulo"));
        Label lbDescricao = new Label(rb.getString("categoria.dialog.descricao"));
        Label lbTipo = new Label(rb.getString("categoria.dialog.descricao"));
        Label lbCategoria = new Label(rb.getString("categoria.dialog.descricao"));
        Label lbValor = new Label(rb.getString("categoria.dialog.descricao"));
        Label lbCriacao = new Label(rb.getString("categoria.dialog.descricao"));
        Label lbVencimento = new Label(rb.getString("categoria.dialog.descricao"));
        Label lbQuitado = new Label(rb.getString("categoria.dialog.descricao"));
        txDescricao.setMaxHeight(200.0);

        GridPane grid = new GridPane();
        grid.add(lbTitulo, 1, 1);
        grid.add(txTitulo, 2, 1);
        grid.add(lbDescricao, 1, 2);
        grid.add(txDescricao, 2, 2);
        dialog.getDialogPane().setContent(grid);

        ButtonType btnOK = new ButtonType(rb.getString("categoria.dialog.ok"), ButtonBar.ButtonData.OK_DONE);
        ButtonType btnCancel = new ButtonType(rb.getString("categoria.dialog.cancelar"), ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().add(btnOK);
        dialog.getDialogPane().getButtonTypes().add(btnCancel);
        

        dialog.setResultConverter((ButtonType b) -> {
            
            if (c != null){
                c.setTitulo(txTitulo.getText());
                c.setDescricao(txDescricao.getText());
                c.setTipo(cbbtipo.getValue());
                c.setCategoria(cbbCategoria.getValue());
                c.setValor(Long.parseLong(txValor.getText()));
                c.setDtCriacao(dtCriacao.getValue());
                c.setDtVencimento(dtVencimento.getValue());
                c.setQuitado(cbQuitado.isSelected());
                
                if (b == btnOK) return c;
                
            }else{
                
                Conta conta = new Conta();
                conta.setTitulo(txTitulo.getText());
                conta.setDescricao(txDescricao.getText());
                conta.setTipo(cbbtipo.getValue());
                conta.setCategoria(cbbCategoria.getValue());
                conta.setValor(Long.parseLong(txValor.getText()));
                conta.setDtCriacao(dtCriacao.getValue());
                conta.setDtVencimento(dtVencimento.getValue());
                conta.setQuitado(cbQuitado.isSelected());
                
                if (b == btnOK) return conta;
            }
            return null;
        });

        return dialog;
    }
}
