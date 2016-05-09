/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afp.modelo;

import afp.util.ContaTipo;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jw
 */
@MappedSuperclass
@Table(name = "contas")
@XmlRootElement
public class Contas implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Basic(optional = false)
    @Column(name = "tipo")
    private ContaTipo tipo;
    
    @Basic(optional = false)
    @Column(name = "valor")
    private float valor;
    
    @Basic(optional = false)
    @Column(name = "dt_criacao")
    @Temporal(TemporalType.DATE)
    private LocalDate dtCriacao;
    
    @Basic(optional = false)
    @Column(name = "dt_vencimento")
    @Temporal(TemporalType.DATE)
    private LocalDate dtVencimento;
    
    @Basic(optional = false)
    @Column(name = "quitado")
    private boolean quitado;
    
    @JoinColumn(name = "cat_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categorias categoria;

    public Contas() {
    }

    public Contas(String titulo, ContaTipo tipo, float valor, LocalDate dtCriacao, LocalDate dtVencimento, boolean quitado) {
        setTitulo(titulo);
        setTipo(tipo);
        setValor(valor);
        setDtCriacao(dtCriacao);
        setDtVencimento(dtVencimento);
        setQuitado(quitado);
    }

    public Contas(String titulo, String descricao, ContaTipo tipo, Categorias categoria, float valor, LocalDate dtCriacao, LocalDate dtVencimento, boolean quitado) {
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
    
    public void setTipo(ContaTipo tipo){
        this.tipo = tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        if (valor > 0){
            this.valor = valor;
        }else {
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

    public Categorias getCatId() {
        return categoria;
    }

    public void setCatId(Categorias catId) {
        this.categoria = catId;
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
        if (!(object instanceof Contas)) {
            return false;
        }
        Contas other = (Contas) object;
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
