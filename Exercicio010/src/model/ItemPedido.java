package model;

import java.math.BigDecimal;

public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private BigDecimal precoCongelado; // O preço no momento da compra

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoCongelado = produto.getPreco();
    }
    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
    public BigDecimal getSubtotal() { return precoCongelado.multiply(new BigDecimal(quantidade)); }
}