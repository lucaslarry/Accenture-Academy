package model;

import exeception.SaldoInsuficienteException;

import java.time.LocalDate;

public class ContaCorrente {
    private int numero;
    private Cliente cliente;
    private double saldo;
    private LocalDate data;

    public ContaCorrente(int numero, Cliente cliente, double saldoInicial, LocalDate data) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = saldoInicial;
        this.data = data;
    }

    public int getNumero() { return numero; }
    public Cliente getCliente() { return cliente; }
    public double getSaldo() { return saldo; }
    public LocalDate getData() { return data; }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > this.saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente na conta " + numero + ". Saldo atual: R$ " + this.saldo);
        }
        this.saldo -= valor;
    }

    public void transferir(ContaCorrente destino, double valor) throws SaldoInsuficienteException {
        this.sacar(valor);
        destino.depositar(valor);
    }
}
