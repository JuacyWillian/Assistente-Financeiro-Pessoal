package afp;

import afp.utils.NavigateEnum;
import java.io.IOException;
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

    private static AssistenteFinanceiroPessoal instance;

    public static AssistenteFinanceiroPessoal getInstance() {
        if (instance == null) {
            instance = new AssistenteFinanceiroPessoal();
        }
        return instance;
    }
    private ResourceBundle bundle;
    private Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        bundle = ResourceBundle.getBundle("afp/i18n/messages", new Locale("pt", "BR"));
        setScene(NavigateEnum.LOGIN);
    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    public void setScene(NavigateEnum screen){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(screen.path), bundle);
            
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(AssistenteFinanceiroPessoal.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Deu erro na troca de tela!!");
        }
    }
}
