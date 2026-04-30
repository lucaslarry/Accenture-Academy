package exception;

public class EstoqueInsuficienteException extends RegraNegocioException {
    public EstoqueInsuficienteException(String sku) {
        super("Estoque insuficiente para o produto SKU: " + sku);
    }
}