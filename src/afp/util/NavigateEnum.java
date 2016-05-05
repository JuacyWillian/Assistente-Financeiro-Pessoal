package afp.util;

public enum NavigateEnum {
    LOGIN("afp/gui/view/Login.fxml"),
    PRINCIPAL("afp/gui/view/Main.fxml"),
    REGISTRA_USUARIO("afp/gui/view/CadastraUsuario.fxml"),
    REGISTRA_CATEGORIA("afp/gui/view/CadastraCategoria.fxml"),
    REGISTRA_CONTA("afp/gui/view/CadastraConta.fxml"),
    EDITA_CONTA("afp/gui/view/EditaConta.fxml"),
    RECUPERA_SENHA("afp/gui/view/RecuperaSenha.fxml");

    private final String path;

    private NavigateEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
