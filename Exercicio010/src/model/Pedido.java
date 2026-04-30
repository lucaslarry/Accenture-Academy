package model;

import enums.StatusPedido;
import exception.StatusInvalidoException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String id;
    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();
    private StatusPedido status;

    public Pedido(String id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.status = StatusPedido.CRIADO;
    }

    public void adicionarItem(ItemPedido item) { this.itens.add(item); }

    public BigDecimal getTotal() {
        return itens.stream()
                .map(ItemPedido::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void reservar() {
        if (this.status != StatusPedido.CRIADO) throw new StatusInvalidoException("Apenas pedidos CRIADOS podem ser reservados.");
        this.status = StatusPedido.RESERVED;
    }

    public void pagar(boolean sucesso) {
        if (this.status != StatusPedido.RESERVED) throw new StatusInvalidoException("Apenas pedidos RESERVED podem ser pagos.");
        this.status = sucesso ? StatusPedido.PAID : StatusPedido.FAILED;
    }

    public void cancelar() {
        if (this.status == StatusPedido.PAID) throw new StatusInvalidoException("Pedidos já pagos não podem ser cancelados por esta via.");
        this.status = StatusPedido.CANCELADO;
    }

    public String getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public List<ItemPedido> getItens() { return itens; }
    public StatusPedido getStatus() { return status; }
}