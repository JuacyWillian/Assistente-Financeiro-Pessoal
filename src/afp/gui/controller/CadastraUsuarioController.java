/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afp.gui.controller;

import afp.gui.view.Navigator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class CadastraUsuarioController implements Initializable {

    @FXML
    private FlowPane myPane;
    @FXML
    private TextField txNome;
    @FXML
    private TextField txEmail;
    @FXML
    private PasswordField txSenha;
    @FXML
    private PasswordField txReSenha;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnCadastrar;
    private ResourceBundle bundle;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bundle = rb;
        Navigator.getInstance().setContentParent(myPane);
    }

    @FXML
    private void actionCancelar(ActionEvent event) {
        Stage stg = (Stage) myPane.getScene().getWindow();
        stg.close();
    }

    @FXML
    private void actionCadastrar(ActionEvent event) {
    }

}
