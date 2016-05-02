package afp.gui.views;

import afp.AssistenteFinanceiroPessoal;
import afp.utils.NavigateEnum;
import javafx.application.Application;

public class AppNavigator {

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

    public void navigateTo(NavigateEnum screen) {
        app.setScene(screen);
    }
}
