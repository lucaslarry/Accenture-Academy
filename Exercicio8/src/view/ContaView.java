package view;

public class ContaView {

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void mostrarErro(String erro) {
        System.err.println("[ERRO] " + erro);
    }

    public void mostrarSaldo(int numeroConta, double saldo) {
        System.out.printf(">>> Saldo atualizado da Conta %d: R$ %.2f\n", numeroConta, saldo);
    }

    public void mostrarExtrato(int numeroConta, String nomeCliente, double saldo, String data) {
        System.out.println("\n=== EXTRATO BANCÁRIO ===");
        System.out.println("Conta: " + numeroConta);
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Data de Abertura: " + data);
        System.out.printf("Saldo Atual: R$ %.2f\n", saldo);
        System.out.println("========================\n");
    }
}
