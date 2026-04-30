package model;

public class Dog extends Animal {
    public Dog(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public String obterSom() {
        return "auau";
    }
}
