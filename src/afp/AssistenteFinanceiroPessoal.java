package afp;

import afp.gui.view.Navigator;
import afp.util.NavigateEnum;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AssistenteFinanceiroPessoal extends Application {

    private ResourceBundle bundle;
    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        bundle = ResourceBundle.getBundle("afp/i18n/messages", new Locale("pt", "BR"));
        Navigator.getInstance().setStage(primaryStage);
        setScene(NavigateEnum.LOGIN);
    }

    public void setScene(NavigateEnum screen) {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(screen.getPath()), bundle);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        } catch (Exception ex) {
            Logger.getLogger(AssistenteFinanceiroPessoal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
