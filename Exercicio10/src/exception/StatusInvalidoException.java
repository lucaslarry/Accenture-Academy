package exception;

public class StatusInvalidoException extends RegraNegocioException {
    public StatusInvalidoException(String transicao) {
        super("Transição de status inválida: " + transicao);
    }
}