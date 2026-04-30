import controller.AnimalController;
import model.Animal;
import model.Dog;
import model.Gato;
import view.AnimalView;
/**
 * @author Lucas Larry
 *
 */
public class Main {
    public static void main(String[] args) {
        AnimalView view = new AnimalView();

        Animal meuGato = new Gato("Frajola", 3);
        Animal meuDog = new Dog("Rex", 5);

        AnimalController controllerGato = new AnimalController(meuGato, view);
        AnimalController controllerDog = new AnimalController(meuDog, view);

        controllerGato.fazerSom();
        controllerDog.fazerSom();
    }
}