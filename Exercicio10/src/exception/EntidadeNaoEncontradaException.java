package exception;

public class EntidadeNaoEncontradaException extends RegraNegocioException {
    public EntidadeNaoEncontradaException(String entidade) {
        super(entidade + " não encontrado(a).");
    }
}