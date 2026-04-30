package controller;

import exeception.SaldoInsuficienteException;
import model.ContaCorrente;
import view.ContaView;

public class ContaController {
    private ContaView view;

    public ContaController(ContaView view) {
        this.view = view;
    }

    public void depositar(ContaCorrente conta, double valor) {
        conta.depositar(valor);
        view.mostrarMensagem("\n[DEPÓSITO] R$ " + valor + " na conta " + conta.getNumero());
        view.mostrarSaldo(conta.getNumero(), conta.getSaldo());
    }

    public void sacar(ContaCorrente conta, double valor) {
        try {
            conta.sacar(valor);
            view.mostrarMensagem("\n[SAQUE] R$ " + valor + " na conta " + conta.getNumero());
            view.mostrarSaldo(conta.getNumero(), conta.getSaldo());
        } catch (SaldoInsuficienteException e) {
            view.mostrarErro("Saque cancelado. " + e.getMessage());
        }
    }

    public void transferir(ContaCorrente origem, ContaCorrente destino, double valor) throws SaldoInsuficienteException {
        try {
            view.mostrarMensagem("\n[TRANSFERÊNCIA] Iniciando transferência de R$ " + valor + " (Conta " + origem.getNumero() + " -> Conta " + destino.getNumero() + ")");
            origem.transferir(destino, valor);
            view.mostrarMensagem("Transferência realizada com sucesso!");

            view.mostrarSaldo(origem.getNumero(), origem.getSaldo());
            view.mostrarSaldo(destino.getNumero(), destino.getSaldo());
        } catch (SaldoInsuficienteException e) {
            view.mostrarErro("Transferência cancelada. " + e.getMessage());
        }
    }

    public void exibirExtrato(ContaCorrente conta) {
        String nomeCompleto = conta.getCliente().getNome() + " " + conta.getCliente().getSobrenome();
        view.mostrarExtrato(conta.getNumero(), nomeCompleto, conta.getSaldo(), conta.getData().toString());
    }

    public void exibirNomeCliente(ContaCorrente conta) {
        view.mostrarMensagem("\n-> O titular da conta " + conta.getNumero() + " é: " +
                conta.getCliente().getNome() + " " + conta.getCliente().getSobrenome());
    }

    public void exibirSaldo(ContaCorrente conta) {
        view.mostrarSaldo(conta.getNumero(), conta.getSaldo());
    }
}
