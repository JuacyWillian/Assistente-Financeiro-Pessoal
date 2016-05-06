package afp.util;

public enum TelasEnum {
    LOGIN("afp/gui/view/Login.fxml"),
    PRINCIPAL("afp/gui/view/Principal.fxml"),
    REGISTRA_USUARIO("afp/gui/view/CadastraUsuario.fxml"),
    REGISTRA_CATEGORIA("afp/gui/view/CadastraCategoria.fxml"),
    REGISTRA_CONTA("afp/gui/view/CadastraConta.fxml"),
    EDITA_CONTA("afp/gui/view/EditaConta.fxml"),
    RECUPERA_SENHA("afp/gui/view/RecuperaSenha.fxml");

    private final String path;

    private TelasEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
