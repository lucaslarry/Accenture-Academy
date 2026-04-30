import controller.SistemaController;
import view.SistemaView;

public class Main {
    public static void main(String[] args) {
        SistemaView view = new SistemaView();

        SistemaController controller = new SistemaController(view);

        controller.iniciarCadastro();

        view.fechar();
    }
}