package model;

import enums.StatusAluno;

public class Aluno {
    private String nome;
    private double[] notas;
    private double media;
    private StatusAluno status;

    public Aluno(String nome, double[] notas) {
        this.nome = nome;
        this.notas = notas;
        this.media = (notas[0] + notas[1] + notas[2]) / 3.0;
        this.status = StatusAluno.classificarPorMedia(this.media);
    }

    public String getNome() { return nome; }
    public double[] getNotas() { return notas; }
    public double getMedia() { return media; }
    public StatusAluno getStatus() { return status; }

    @Override
    public String toString() {
        return String.format("%s | Notas: %.0f, %.0f, %.0f | Média: %.2f | %s",
                nome, notas[0], notas[1], notas[2], media, status.name());
    }
}