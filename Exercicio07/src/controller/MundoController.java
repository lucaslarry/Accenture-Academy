package controller;

import model.Arvore;
import model.Carro;
import model.Casa;
import model.Pessoa;
import view.MundoView;

public class MundoController {
    private Pessoa pessoa;
    private Casa casa;
    private Carro carro;
    private Arvore arvore;
    private MundoView view;

    public MundoController(Pessoa p, Casa c, Carro car, Arvore a, MundoView v) {
        this.pessoa = p;
        this.casa = c;
        this.carro = car;
        this.arvore = a;
        this.view = v;
    }

    public void entrarEmCasa() {
        if (!casa.isTrancada()) {
            pessoa.setLocalizacao("Casa");
            view.mostrarMensagem(pessoa.getNome() + " entrou em casa.");
        } else {
            view.mostrarAlerta("A casa está trancada! João continua na " + pessoa.getLocalizacao());
        }
    }

    public void usarCarro() {
        if (carro.isLigado()) {
            pessoa.setLocalizacao("Carro");
            view.mostrarMensagem(pessoa.getNome() + " está dirigindo.");
        } else {
            view.mostrarAlerta("O carro está desligado! Não é possível dirigir.");
        }
    }

    public void irParaArvore() {
        pessoa.setLocalizacao("Árvore");
        view.mostrarMensagem(pessoa.getNome() + " foi para perto da árvore.");
    }

    public void acaoBuzinar() {
        if (pessoa.getLocalizacao().equals("Carro")) {
            view.mostrarMensagem(carro.buzinar());
        } else {
            view.mostrarAlerta(pessoa.getNome() + " precisa estar no carro para buzinar.");
        }
    }

    public void acaoRegar() {
        if (pessoa.getLocalizacao().equals("Árvore")) {
            view.mostrarMensagem(arvore.serRegada());
        } else {
            view.mostrarAlerta(pessoa.getNome() + " precisa ir até a árvore para regá-la.");
        }
    }

    public void exibirEstadoAtual() {
        view.mostrarStatus(pessoa.getNome(), pessoa.getLocalizacao());
    }

    // Métodos de ambiente
    public void destrancarCasa() { casa.setTrancada(false); view.mostrarMensagem("Casa destrancada."); }
    public void ligarCarro() { carro.setLigado(true); view.mostrarMensagem("Carro ligado."); }
}
