package exceptions;

public class ValorExcedidoException extends IllegalArgumentException {
    public ValorExcedidoException() {
        super("Valor solicitado maior do que o disponível.");
    }

    public ValorExcedidoException(String mensagem) {
        super(mensagem);
    }
}
