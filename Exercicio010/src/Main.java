import controller.EcommerceController;
import view.CLIView;

public class Main {
    public static void main(String[] args) {
        EcommerceController controller = new EcommerceController();
        CLIView view = new CLIView(controller);
        view.iniciar();
    }
}