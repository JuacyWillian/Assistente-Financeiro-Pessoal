package afp.gui.view;

import afp.util.NavigateEnum;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Navigator {

    private Pane contentParent;
    private static Navigator instance;
    private Stage stage;

    private Navigator() {
    }

    public static Navigator getInstance() {
        if (instance == null) {
            instance = new Navigator();
        }
        return instance;
    }

    public void navigateTo(NavigateEnum s, ResourceBundle rb) {
        try {
            Parent p = FXMLLoader.load(getClass().getClassLoader().getResource(s.getPath()), rb);
            stage.setScene(new Scene(p));
        } catch (IOException ex) {
            Logger.getLogger(Navigator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    public void setStage(Stage stg) {
        this.stage = stg;
    }
}
