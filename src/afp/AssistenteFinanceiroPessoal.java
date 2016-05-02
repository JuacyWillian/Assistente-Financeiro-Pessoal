package afp;

import afp.services.UserService;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AssistenteFinanceiroPessoal extends Application {

    private static AssistenteFinanceiroPessoal instance;
    public static AssistenteFinanceiroPessoal getInstance() {
        if (instance == null) {
            instance = new AssistenteFinanceiroPessoal();
        }
        return instance;
    }
    private ResourceBundle bundle;
    private Stage primaryStage;

    private AssistenteFinanceiroPessoal() {
    }


    public UserService createUser(String nome, String email, String password) {
        return null;
    }

    public boolean login(String juacy_Willian, String juacywilliangmailcom, String stella2010) {
        return false;
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        bundle = ResourceBundle.getBundle("afp/i18n/messages", new Locale("pt", "BR"));
        Parent root = FXMLLoader.load(getClass().getResource("afp/gui/views/Login.fxml"), bundle);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    public void setScene(Scene scene) {
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
