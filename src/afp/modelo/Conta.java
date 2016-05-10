/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afp.modelo;

import afp.util.ContaTipo;
import java.io.Serializable;
import java.time.LocalDate;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jw
 */
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

    public Conta(String titulo, ContaTipo tipo, long valor, LocalDate dtCriacao, LocalDate dtVencimento, boolean quitado) {
        setTitulo(titulo);
        setTipo(tipo);
        setValor(valor);
        setDtCriacao(dtCriacao);
        setDtVencimento(dtVencimento);
        setQuitado(quitado);
    }

    public Conta(String titulo, String descricao, ContaTipo tipo, Categoria categoria, long valor, LocalDate dtCriacao, LocalDate dtVencimento, boolean quitado) {
        setTitulo(titulo);
        setDescricao(descricao);
        setTipo(tipo);
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

    public boolean getQuitado() {
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
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conta)) {
            return false;
        }
        Conta other = (Conta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "afp.modelo.Contas[ id=" + id + " ]";
    }
}
