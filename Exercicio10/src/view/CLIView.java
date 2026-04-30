package view;

import exception.RegraNegocioException;
import controller.EcommerceController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class CLIView {
    private EcommerceController controller;
    private Scanner scanner;

    public CLIView(EcommerceController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean rodando = true;
        while (rodando) {
            System.out.println("\n--- E-COMMERCE CLI ---");
            System.out.println("1. Adicionar Produto | 2. Adicionar Cliente");
            System.out.println("3. Criar Pedido      | 4. Reservar Estoque");
            System.out.println("5. Pagar Pedido      | 6. Cancelar Pedido");
            System.out.println("7. Relatórios        | 0. Sair");
            System.out.print("Escolha: ");

            String opcao = scanner.nextLine();

            try {
                switch (opcao) {
                    case "1" -> {
                        System.out.println("\n-- Novo Produto --");
                        System.out.print("Nome: ");
                        String nomeProduto = scanner.nextLine();
                        System.out.print("Categoria: ");
                        String categoria = scanner.nextLine();
                        System.out.print("Preço (ex: 1500.50): ");
                        BigDecimal preco = new BigDecimal(scanner.nextLine());
                        System.out.print("Quantidade em Estoque: ");
                        int estoque = Integer.parseInt(scanner.nextLine());

                        String skuGerado = controller.adicionarProduto(nomeProduto, categoria, preco, estoque);
                        System.out.println("Produto '" + nomeProduto + "' adicionado com sucesso! SKU gerado: " + skuGerado);
                    }
                    case "2" -> {
                        System.out.println("\n-- Novo Cliente --");
                        System.out.print("Nome: ");
                        String nomeCliente = scanner.nextLine();

                        String idClienteGerado = controller.adicionarCliente(nomeCliente);
                        System.out.println("Cliente '" + nomeCliente + "' adicionado com sucesso! ID gerado: " + idClienteGerado);
                    }
                    case "3" -> {
                        System.out.println("\n-- Novo Pedido --");
                        System.out.print("ID do Cliente Comprador (ex: CLI-1): ");
                        String idComprador = scanner.nextLine();

                        Map<String, Integer> itens = new HashMap<>();
                        String continuarItem = "S";

                        while ("S".equalsIgnoreCase(continuarItem)) {
                            System.out.print("SKU do Produto (ex: PROD-1): ");
                            String skuItem = scanner.nextLine();
                            System.out.print("Quantidade: ");
                            int qtd = Integer.parseInt(scanner.nextLine());

                            itens.put(skuItem, itens.getOrDefault(skuItem, 0) + qtd);

                            System.out.print("Adicionar outro item a este pedido? (S/N): ");
                            continuarItem = scanner.nextLine();
                        }

                        String pId = controller.criarPedido(idComprador, itens);
                        System.out.println("Pedido ID: " + pId + " criado com sucesso para o cliente: " + idComprador);
                    }
                    case "4" -> {
                        System.out.print("Digite o ID do pedido para reservar estoque (ex: PED-1): ");
                        String idReserva = scanner.nextLine();
                        controller.reservarEstoque(idReserva);
                        System.out.println("Estoque do pedido ID: " + idReserva + " reservado com sucesso.");
                    }
                    case "5" -> {
                        System.out.print("Digite o ID do pedido para pagamento (ex: PED-1): ");
                        String idPago = scanner.nextLine();
                        controller.pagarPedido(idPago, true);
                        System.out.println("Pagamento do pedido ID: " + idPago + " processado e aprovado.");
                    }
                    case "6" -> {
                        System.out.print("Digite o ID do pedido para cancelar (ex: PED-1): ");
                        String idCancelado = scanner.nextLine();
                        controller.cancelarPedido(idCancelado);
                        System.out.println("Pedido ID: " + idCancelado + " cancelado com sucesso e estoque liberado.");
                    }
                    case "7" -> {
                        System.out.println("\n--- RELATÓRIOS ---");
                        System.out.println("Faturamento Total (PAID): R$ " + controller.getFaturamentoTotal());
                        System.out.println("\nTop 3 Produtos mais vendidos:");
                        controller.getTop3Produtos();
                    }
                    case "0" -> {
                        rodando = false;
                        System.out.println("Encerrando o sistema...");
                    }
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERRO DE ENTRADA] Você digitou letras onde deveria ser um número.");
            } catch (RegraNegocioException e) {
                System.out.println("[ERRO DE NEGÓCIO] " + e.getMessage());
            } catch (Exception e) {
                System.out.println("[ERRO CRÍTICO] " + e.getMessage());
            }
        }
    }
}