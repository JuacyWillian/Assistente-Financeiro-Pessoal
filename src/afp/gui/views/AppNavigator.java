package afp.gui.views;

import java.util.ResourceBundle;

public class AppNavigator {

    private final String LOGIN_SCREEN = "afp/gui/views/LoginScreen.fxml";
    private final String PRINCIPAL = "afp/gui/views/MainScreen.fxml";
    private final String REGISTRA_URUARIO = "afp/gui/views/RegistraUserScreen.fxml";
    private final String REGISTRA_CATEGORIA = "afp/gui/views/RegistraCategoriaScreen.fxml";
    private final String REGISTRA_CONTA = "afp/gui/views/RegistraContaScreen.fxml";

    public AppNavigator() {
        ResourceBundle resource = ResourceBundle.getBundle("afp/config/properties.config");
    }
}
