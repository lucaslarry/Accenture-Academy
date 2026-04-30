package view;

public class MundoView {
    public void mostrarStatus(String nome, String local) {
        System.out.println("[STATUS] " + nome + " está atualmente em: " + local);
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println("-> " + mensagem);
    }

    public void mostrarAlerta(String alerta) {
        System.out.println("[ALERTA] " + alerta);
    }
}
