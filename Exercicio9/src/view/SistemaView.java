package view;

import model.Aluno;

import java.util.List;
import java.util.Scanner;


public class SistemaView {
    private Scanner scanner;

    public SistemaView() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public String lerEntrada(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public void exibirRelatorioIndividual(List<Aluno> alunos) {
        exibirMensagem("\n--- 1. Relatório Individual ---");
        for (Aluno a : alunos) {
            exibirMensagem(a.toString());
        }
    }

    public void exibirEstatisticasTurma(double maior, double menor, double media) {
        exibirMensagem("\n--- 2. Estatísticas da Turma ---");
        exibirMensagem(String.format("Maior média: %.2f", maior));
        exibirMensagem(String.format("Menor média: %.2f", menor));
        exibirMensagem(String.format("Média geral: %.2f", media));
    }

    public void exibirDistribuicaoResultados(int total, int aprovados, int recup, int reprovados) {
        exibirMensagem("\n--- 3. Distribuição de Resultados ---");
        exibirMensagem("Total de alunos: " + total);
        exibirMensagem("APROVADOS: " + aprovados);
        exibirMensagem("RECUPERAÇÃO: " + recup);
        exibirMensagem("REPROVADOS: " + reprovados);
    }

    public void exibirMelhoresAlunos(List<Aluno> melhoresAlunos) {
        exibirMensagem("\n--- 4. Melhor(es) Aluno(s) ---");
        for (Aluno a : melhoresAlunos) {
            exibirMensagem("- " + a.getNome() + " | Média: " + String.format("%.2f", a.getMedia()));
        }
    }

    public void fechar() {
        scanner.close();
    }
}