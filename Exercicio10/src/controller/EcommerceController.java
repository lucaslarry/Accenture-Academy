package controller;

import enums.StatusPedido;
import exception.EntidadeNaoEncontradaException;
import exception.EstoqueInsuficienteException;
import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.Produto;

import java.math.BigDecimal;
import java.util.*;

public class EcommerceController {
    private Map<String, Produto> produtos = new HashMap<>();
    private Map<String, Cliente> clientes = new HashMap<>();
    private Map<String, Pedido> pedidos = new HashMap<>();

    private int produtoCounter = 1;
    private int clienteCounter = 1;
    private int pedidoCounter = 1;

    public String adicionarProduto(String nome, String cat, BigDecimal preco, int estoque) {
        String skuGerado = "PROD-" + (produtoCounter++);
        produtos.put(skuGerado, new Produto(skuGerado, nome, cat, preco, estoque));
        return skuGerado;
    }

    public List<Produto> listarProdutosOrdenadosPorPreco() {
        List<Produto> lista = new ArrayList<>(produtos.values());
        lista.sort(Comparator.comparing(Produto::getPreco));
        return lista;
    }

    public String adicionarCliente(String nome) {
        String idGerado = "CLI-" + (clienteCounter++);
        clientes.put(idGerado, new Cliente(idGerado, nome));
        return idGerado;
    }

    public String criarPedido(String clienteId, Map<String, Integer> itensSkuQtd) {
        Cliente cliente = clientes.get(clienteId);
        if (cliente == null) throw new EntidadeNaoEncontradaException("Cliente ID: " + clienteId);

        String pedidoId = "PED-" + (pedidoCounter++);
        Pedido pedido = new Pedido(pedidoId, cliente);

        for (Map.Entry<String, Integer> entry : itensSkuQtd.entrySet()) {
            Produto p = produtos.get(entry.getKey());
            if (p == null) throw new EntidadeNaoEncontradaException("Produto SKU: " + entry.getKey());
            pedido.adicionarItem(new ItemPedido(p, entry.getValue()));
        }

        pedidos.put(pedidoId, pedido);
        return pedidoId;
    }

    public void reservarEstoque(String pedidoId) {
        Pedido pedido = getPedido(pedidoId);
        for (ItemPedido item : pedido.getItens()) {
            if (item.getProduto().getEstoque() < item.getQuantidade()) {
                throw new EstoqueInsuficienteException(item.getProduto().getSku());
            }
        }
        for (ItemPedido item : pedido.getItens()) {
            item.getProduto().reduzirEstoque(item.getQuantidade());
        }
        pedido.reservar();
    }

    public void pagarPedido(String pedidoId, boolean simularSucesso) {
        Pedido pedido = getPedido(pedidoId);
        pedido.pagar(simularSucesso);
    }

    public void cancelarPedido(String pedidoId) {
        Pedido pedido = getPedido(pedidoId);
        if (pedido.getStatus() == StatusPedido.RESERVED) {
            for (ItemPedido item : pedido.getItens()) {
                item.getProduto().reporEstoque(item.getQuantidade());
            }
        }
        pedido.cancelar();
    }

    private Pedido getPedido(String id) {
        Pedido p = pedidos.get(id);
        if (p == null) throw new EntidadeNaoEncontradaException("Pedido ID: " + id);
        return p;
    }

    public BigDecimal getFaturamentoTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Pedido p : pedidos.values()) {
            if (p.getStatus() == StatusPedido.PAID) {
                total = total.add(p.getTotal());
            }
        }
        return total;
    }

    public void getTop3Produtos() {
        Map<String, Integer> vendasPorProduto = new HashMap<>();
        for (Pedido p : pedidos.values()) {
            if (p.getStatus() == StatusPedido.PAID) {
                for (ItemPedido item : p.getItens()) {
                    String nome = item.getProduto().getNome();
                    int qtd = item.getQuantidade();
                    vendasPorProduto.put(nome, vendasPorProduto.getOrDefault(nome, 0) + qtd);
                }
            }
        }

        List<Map.Entry<String, Integer>> listaVendas = new ArrayList<>(vendasPorProduto.entrySet());
        listaVendas.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        int count = 0;
        for (Map.Entry<String, Integer> entry : listaVendas) {
            if (count >= 3) break;
            System.out.println(entry.getKey() + " - " + entry.getValue() + " unidades");
            count++;
        }
    }
}