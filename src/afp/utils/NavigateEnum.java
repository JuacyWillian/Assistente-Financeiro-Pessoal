package afp.utils;

public enum NavigateEnum {
    LOGIN("afp/gui/view/Login.fxml"),
    PRINCIPAL("afp/gui/view/Main.fxml"),
    REGISTRA_USUARIO("afp/gui/view/RegistraUser.fxml"),
    REGISTRA_CATEGORIA("afp/gui/view/RegistraCategoria.fxml"),
    REGISTRA_CONTA("afp/gui/view/RegistraConta.fxml"),
    RECUPERA_SENHA("afp/gui/view/RecuperaSenha.fxml");

    public final String path;

    private NavigateEnum(String path) {
        this.path = path;
    }
}
