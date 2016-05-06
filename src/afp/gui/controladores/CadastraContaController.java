/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afp.gui.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author jw
 */
public class CadastraContaController implements Initializable {

    @FXML
    private TextField txTitulo;
    @FXML
    private TextArea txDescricao;
    @FXML
    private ComboBox<?> cbbTipo;
    @FXML
    private ComboBox<?> cbbCategoria;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        todo
    }    
    
}
