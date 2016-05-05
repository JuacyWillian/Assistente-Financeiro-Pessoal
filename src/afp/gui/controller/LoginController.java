package afp.gui.controller;

import afp.gui.view.Navigator;
import afp.util.NavigateEnum;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class LoginController implements Initializable {

    @FXML
    private TextField txUsername;
    @FXML
    private PasswordField txPassword;
    @FXML
    private CheckBox chbRemember;
    @FXML
    private Label lbError;
    @FXML
    private Pane myPane;

    private ResourceBundle bundle;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bundle = rb;
        Navigator.getInstance().setContentParent(myPane);
    }

    @FXML
    private void actionButtonOk(ActionEvent event) {
        String username = txUsername.getText();
        String password = txPassword.getText();
        if ("admin".equals(username) && "root".equals(password)) {
            if (chbRemember.isSelected()) {
//                todo: remember action
            }
            Navigator.getInstance().navigateTo(NavigateEnum.PRINCIPAL, bundle);

        } else {
            lbError.setVisible(true);
        }
    }

    @FXML
    private void actionButtonCancel(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void onLinkRegister(ActionEvent event) {
        Navigator.getInstance().navigateTo(NavigateEnum.REGISTRA_USUARIO, bundle);
    }

    @FXML
    private void onLinkResetPassword(ActionEvent event) {
        Navigator.getInstance().navigateTo(NavigateEnum.RECUPERA_SENHA, bundle);
    }
}
