import controller.SistemaController;
import view.SistemaView;

public class Main {
    public static void main(String[] args) {
        // Instancia a View
        SistemaView view = new SistemaView();

        // Instancia o Controller passando a View
        SistemaController controller = new SistemaController(view);

        // Inicia o sistema
        controller.iniciarCadastro();

        // Finaliza recursos
        view.fechar();
    }
}