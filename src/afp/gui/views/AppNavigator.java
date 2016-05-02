package afp.gui.views;

import afp.AssistenteFinanceiroPessoal;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AppNavigator {

    public enum ScreenEnum {
        LOGIN("afp/gui/views/LoginScreen.fxml"),
        PRINCIPAL("afp/gui/views/MainScreen.fxml"),
        REGISTRA_USUARIO("afp/gui/views/RegistraUserScreen.fxml"),
        REGISTRA_CATEGORIA("afp/gui/views/RegistraCategoriaScreen.fxml"),
        REGISTRA_CONTA("afp/gui/views/RegistraContaScreen.fxml");

        private String screenPath;

        ScreenEnum(String path) {
            screenPath = path;
        }

        String getScreenPath() {
            return screenPath;
        }
    }

    private AssistenteFinanceiroPessoal app;

    public AppNavigator(AssistenteFinanceiroPessoal app) {
        this.app = app;
    }

    public Application getApp() {
        return this.app;
    }

    public void setApp(AssistenteFinanceiroPessoal app) {
        this.app = app;
    }

    public void navigateTo(ScreenEnum screen) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource(screen.getScreenPath()), app.getBundle());
            Scene scene = new Scene(p);
            app.setScene(scene);

        } catch (IOException ex) {
            Logger.getLogger(AppNavigator.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ocorreu um erro durante a navegação!");
        }
    }
}
