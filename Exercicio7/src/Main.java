import controller.MundoController;
import model.Arvore;
import model.Carro;
import model.Casa;
import model.Pessoa;
import view.MundoView;
/**
 * @author Lucas Larry
 *
 */
public class Main {
    public static void main(String[] args) {
        Pessoa joao = new Pessoa("João");
        Casa casa = new Casa();
        Carro carro = new Carro();
        Arvore arvore = new Arvore();
        MundoView view = new MundoView();

        MundoController controller = new MundoController(joao, casa, carro, arvore, view);

        controller.exibirEstadoAtual();

        controller.entrarEmCasa();
        controller.destrancarCasa();
        controller.entrarEmCasa();

        controller.exibirEstadoAtual();

        System.out.println();

        controller.acaoRegar();
        controller.irParaArvore();
        controller.acaoRegar();

        controller.exibirEstadoAtual();

        System.out.println();

        controller.ligarCarro();
        controller.usarCarro();
        controller.acaoBuzinar();

        controller.exibirEstadoAtual();
    }
}