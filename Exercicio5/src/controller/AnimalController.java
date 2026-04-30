package controller;

import model.Animal;
import view.AnimalView;

public class AnimalController {
    private Animal model;
    private AnimalView view;

    public AnimalController(Animal model, AnimalView view) {
        this.model = model;
        this.view = view;
    }

    public void fazerSom() {
        String som = model.obterSom();
        view.exibirSomAnimal(model.getClass().getSimpleName(), som);
    }
}
