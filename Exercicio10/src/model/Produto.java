package model;

import exception.EstoqueInsuficienteException;

import java.math.BigDecimal;

public class Produto {
    private String sku;
    private String nome;
    private String categoria;
    private BigDecimal preco;
    private int estoque;

    public Produto(String sku, String nome, String categoria, BigDecimal preco, int estoque) {
        this.sku = sku; this.nome = nome; this.categoria = categoria;
        this.preco = preco; this.estoque = estoque;
    }

    public void reduzirEstoque(int qtd) {
        if (this.estoque < qtd) throw new EstoqueInsuficienteException(this.sku);
        this.estoque -= qtd;
    }

    public void reporEstoque(int qtd) { this.estoque += qtd; }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}