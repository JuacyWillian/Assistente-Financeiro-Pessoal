package afp.gui.view;

import afp.utils.NavigateEnum;
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

            System.out.println(s.path);
            Parent p = FXMLLoader.load(getClass().getClassLoader().getResource(s.path), rb);
            Stage stage = (Stage) contentParent.getScene().getWindow();
            stage.setScene(new Scene(p));

        } catch (Exception ex) {
            Logger.getLogger(Navigator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setContentParent(Pane contentParent) {
        this.contentParent = contentParent;
    }
}
