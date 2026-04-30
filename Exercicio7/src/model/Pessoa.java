package model;

public class Pessoa {
    private String nome;
    private String localizacao;

    public Pessoa(String nome) {
        this.nome = nome;
        this.localizacao = "Rua";
    }

    public String getNome() { return nome; }
    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }
}