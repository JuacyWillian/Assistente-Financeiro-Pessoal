package afp.modelo;

import afp.util.ContaTipo;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String titulo;

    private String descricao;

    private ContaTipo tipo;

    private long valor;

    private LocalDate dtCriacao;

    private LocalDate dtVencimento;

    private boolean quitado;

    private Categoria categoria;

    public Conta() {
    }

    public Conta(String titulo, String descricao, ContaTipo tipo, Categoria categoria, 
            long valor, LocalDate dtCriacao, LocalDate dtVencimento, boolean quitado) {
        setTitulo(titulo);
        setDescricao(descricao);
        setTipo(tipo);
        setCategoria(categoria);
        setValor(valor);
        setDtCriacao(dtCriacao);
        setDtVencimento(dtVencimento);
        setQuitado(quitado);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ContaTipo getTipo() {
        return tipo;
    }

    public void setTipo(ContaTipo tipo) {
        this.tipo = tipo;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        if (valor > 0) {
            this.valor = valor;
        } else {
            this.valor = 0;
        }
    }

    public LocalDate getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDate dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public LocalDate getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(LocalDate dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public boolean isQuitado() {
        return quitado;
    }

    public void setQuitado(boolean quitado) {
        this.quitado = quitado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria id) {
        this.categoria = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.titulo);
        hash = 43 * hash + Objects.hashCode(this.descricao);
        hash = 43 * hash + Objects.hashCode(this.tipo);
        hash = 43 * hash + (int) (this.valor ^ (this.valor >>> 32));
        hash = 43 * hash + Objects.hashCode(this.dtCriacao);
        hash = 43 * hash + Objects.hashCode(this.dtVencimento);
        hash = 43 * hash + (this.quitado ? 1 : 0);
        hash = 43 * hash + Objects.hashCode(this.categoria);
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
        final Conta other = (Conta) obj;
        if (this.valor != other.valor) {
            return false;
        }
        if (this.quitado != other.quitado) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        if (!Objects.equals(this.dtCriacao, other.dtCriacao)) {
            return false;
        }
        if (!Objects.equals(this.dtVencimento, other.dtVencimento)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Conta{" + "titulo=" + titulo + ", descricao=" + descricao + ", tipo=" + tipo + ", valor=" + valor + ", dtCriacao=" + dtCriacao + ", dtVencimento=" + dtVencimento + ", quitado=" + quitado + ", categoria=" + categoria + '}';
    }

}
