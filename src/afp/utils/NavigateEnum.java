package afp.utils;

public enum NavigateEnum {
    LOGIN("afp/gui/views/LoginScreen.fxml"),
    PRINCIPAL("afp/gui/views/MainScreen.fxml"),
    REGISTRA_USUARIO("afp/gui/views/RegistraUserScreen.fxml"),
    REGISTRA_CATEGORIA("afp/gui/views/RegistraCategoriaScreen.fxml"),
    REGISTRA_CONTA("afp/gui/views/RegistraContaScreen.fxml");

    private final String screenPath;

    NavigateEnum(String path) {
        screenPath = path;
    }

    String getScreenPath() {
        return screenPath;
    }
}
