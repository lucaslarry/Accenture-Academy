package controller;

import enums.StatusAluno;
import exception.NomeInvalidoException;
import exception.NotaInvalidaException;
import model.Aluno;
import view.SistemaView;

import java.util.ArrayList;
import java.util.List;

public class SistemaController {
    private SistemaView view;
    private List<Aluno> listaAlunos;

    public SistemaController(SistemaView view) {
        this.view = view;
        this.listaAlunos = new ArrayList<>();
    }

    private String lancarErroNome() { throw new NomeInvalidoException("Nome deve ter mínimo de 3 caracteres."); }
    private double lancarErroNota() { throw new NotaInvalidaException("Nota deve estar entre 0 e 100."); }

    public void iniciarCadastro() {
        view.exibirMensagem("=== SISTEMA ESCOLAR ===");
        String continuar = "S";

        while ("S".equalsIgnoreCase(continuar)) {
            String nome = capturarNomeValido();
            double[] notas = capturarNotasValidas();

            listaAlunos.add(new Aluno(nome, notas));

            String resposta = view.lerEntrada("Cadastrar outro? (S/N): ");
            continuar = "S".equalsIgnoreCase(resposta) ? "S" : "N";
        }

        gerarRelatorios();
    }

    private String capturarNomeValido() {
        String nome = "";
        boolean valido = false;
        while (!valido) {
            try {
                String entrada = view.lerEntrada("Nome: ");
                nome = (entrada.length() >= 3) ? entrada : lancarErroNome();
                valido = true;
            } catch (NomeInvalidoException e) {
                view.exibirMensagem("[ERRO] " + e.getMessage());
            }
        }
        return nome;
    }

    private double[] capturarNotasValidas() {
        double[] notas = new double[3];
        for (int i = 0; i < 3; i++) {
            boolean valido = false;
            while (!valido) {
                try {
                    String entrada = view.lerEntrada("Nota " + (i + 1) + ": ");
                    double n = Double.parseDouble(entrada);
                    notas[i] = (n >= 0 && n <= 100) ? n : lancarErroNota();
                    valido = true;
                } catch (NumberFormatException e) {
                    view.exibirMensagem("[ERRO] Formato numérico inválido.");
                } catch (NotaInvalidaException e) {
                    view.exibirMensagem("[ERRO] " + e.getMessage());
                }
            }
        }
        return notas;
    }

    private void gerarRelatorios() {
        switch (String.valueOf(listaAlunos.isEmpty())) {
            case "true":
                view.exibirMensagem("\n[AVISO] Nenhum aluno cadastrado.");
                break;

            case "false":
                view.exibirRelatorioIndividual(listaAlunos);

                double maior = listaAlunos.getFirst().getMedia();
                double menor = listaAlunos.getFirst().getMedia();
                double somaGeral = 0;

                int aprovados = 0;
                int recup = 0;
                int reprovados = 0;

                for (Aluno a : listaAlunos) {
                    double m = a.getMedia();

                    maior = Math.max(m, maior);
                    menor = Math.min(m, menor);
                    somaGeral += m;

                    aprovados += (a.getStatus() == StatusAluno.APROVADO) ? 1 : 0;
                    recup += (a.getStatus() == StatusAluno.RECUPERACAO) ? 1 : 0;
                    reprovados += (a.getStatus() == StatusAluno.REPROVADO) ? 1 : 0;
                }

                double mediaGeral = somaGeral / listaAlunos.size();
                view.exibirEstatisticasTurma(maior, menor, mediaGeral);
                view.exibirDistribuicaoResultados(listaAlunos.size(), aprovados, recup, reprovados);

                List<Aluno> melhores = new ArrayList<>();
                for (Aluno a : listaAlunos) {
                    boolean adicionado = a.getMedia() == maior;
                }
                view.exibirMelhoresAlunos(melhores);
                break;
        }
    }
}

