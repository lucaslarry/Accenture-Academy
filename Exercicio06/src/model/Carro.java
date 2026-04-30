package model;

public class Carro {

    private String marca;
    private String codigoCor;
    private double preco;

    public Carro(String marca, String codigoCor, double preco) {
        this.marca = marca;
        this.codigoCor = codigoCor;
        this.preco = preco;
    }

    public void exibir() {
        System.out.println("Marca: " + marca);
        System.out.println("Código da Cor: " + codigoCor);
        System.out.println("Preço: " + preco);
    }

    public void ligar() {
        System.out.println("O carro está ligado.");
    }

    public void buzinar() {
        System.out.println("emitir som");
    }

    public void movimentar() {
        System.out.println("O carro está a movimentar-se.");
    }
}
