
package br.com.ado.web.ADO_DevWeb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

/**
 *
 * @author victor
 */
@Entity
public class Produto implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (length = 100, nullable = false)
    private String nome;
    @Column (length = 250, nullable = false)
    private String descricao;
    @Column (precision = 6, scale = 2, nullable = false)
    private BigDecimal precoCompra;
    @Column (precision = 6, scale = 2, nullable = false)
    private BigDecimal precoVenda;
    @Column (precision = 6, nullable = false)
    private int quantidade;
    @Column (nullable = false)
    private boolean disponivel;
    @Column (nullable = false, insertable = true, updatable = false)
    private LocalDateTime dataCadastro;
    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable(
            name = "PRODUTO_CATEGORIA",
            joinColumns = @JoinColumn(name = "ID_PRODUTO"),
            inverseJoinColumns = @JoinColumn(name = "ID_CATEGORIA")
    )
    private Set<Categoria> categorias;
    @Transient
    private Set<Integer> idsCategorias;
    @Transient
    private String observacoes;

    public Produto() {
    }

    public Produto(Long id, String nome, String descricao, BigDecimal preco_compra, BigDecimal preco_venda, int quantidade, boolean disponivel, LocalDateTime data_cadastro, Set<Categoria> categoria, Set<Integer> idsCategoria, String observacoes) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoCompra = preco_compra;
        this.precoVenda = preco_venda;
        this.quantidade = quantidade;
        this.disponivel = disponivel;
        this.dataCadastro = data_cadastro;
        this.categorias = categoria;
        this.idsCategorias = idsCategoria;
        this.observacoes = observacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(BigDecimal precoCompra) {
        this.precoCompra = precoCompra;
    }

    public BigDecimal getPreco_venda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public LocalDateTime getData_cadastro() {
        return dataCadastro;
    }

    public void setData_cadastro(LocalDateTime data_cadastro) {
        this.dataCadastro = data_cadastro;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Set<Integer> getIdsCategorias() {
        return idsCategorias;
    }

    public void setIdsCategorias(Set<Integer> idsCategorias) {
        this.idsCategorias = idsCategorias;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", precoCompra=" + precoCompra + ", precoVenda=" + 
                precoVenda + ", quantidade=" + quantidade + ", dtCadastro=" + dataCadastro + ", categorias=" + categorias + ", idsCategorias=" + 
                idsCategorias + ", observacoes=" + observacoes + '}';
    }
}
