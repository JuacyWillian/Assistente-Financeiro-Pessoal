package afp.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Conta {

    private int id;

    private String titulo;
    private String descricao;

    private Categoria categoria;

    private BigDecimal valor;
    private int parcelas;

    private LocalDate dataCriacao;
    private LocalDate dataVencimento;

    private boolean quitado;

    private ContaTipo tipo;

    public enum ContaTipo {
        RECEITA, DESPESA
    }

    public Conta() {
    }

    public Conta(
            String titulo, String descricao, Categoria categoria, ContaTipo tipo, BigDecimal valor,
            int parcelas, LocalDate dataCriacao, LocalDate dataVencimento, boolean quitado) {

        this.titulo = titulo;
        this.descricao = descricao;

        this.tipo = tipo;
        this.categoria = categoria;

        this.valor = valor;
        this.parcelas = parcelas;

        this.dataCriacao = dataCriacao;
        this.dataVencimento = dataVencimento;

        this.quitado = quitado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean isQuitado() {
        return quitado;
    }

    public void setQuitado(boolean quitado) {
        this.quitado = quitado;
    }

    public ContaTipo getTipo() {
        return tipo;
    }

    public void setTipo(ContaTipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.titulo);
        hash = 79 * hash + Objects.hashCode(this.categoria);
        hash = 79 * hash + Objects.hashCode(this.valor);
        hash = 79 * hash + Objects.hashCode(this.dataCriacao);
        hash = 79 * hash + Objects.hashCode(this.dataVencimento);
        hash = 79 * hash + Objects.hashCode(this.tipo);
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
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        if (!Objects.equals(this.dataVencimento, other.dataVencimento)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Conta{" + "titulo=" + titulo + ", valor=" + valor + ", dataVencimento=" + dataVencimento + '}';
    }
}
