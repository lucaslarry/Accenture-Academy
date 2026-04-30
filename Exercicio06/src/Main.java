import model.Carro;
/**
 * @author Lucas Larry
 *
 */
public class Main {
    public static void main(String[] args) {
        Carro meuCarro = new Carro("Toyota", "C01-Preto", 25000.50);


        meuCarro.exibir();
        meuCarro.ligar();
        meuCarro.buzinar();
        meuCarro.movimentar();
    }
}