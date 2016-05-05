package afp.util;

import afp.model.Usuario;
import java.util.Objects;

public class Sessao {

    private Sessao instance;
    private int sessaoId;
    private Usuario usuario;

    private Sessao() {
    }

    public Sessao getInstance() {
        if (this.instance == null) {
            this.instance = new Sessao();
        }
        return this.instance;
    }

    public int getSessaoId() {
        return sessaoId;
    }

    public void setSessaoId(int sessaoId) {
        this.sessaoId = sessaoId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.sessaoId;
        hash = 97 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sessao other = (Sessao) obj;
        if (this.sessaoId != other.sessaoId) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sessao{" + "sessaoId=" + sessaoId + '}';
    }
}
