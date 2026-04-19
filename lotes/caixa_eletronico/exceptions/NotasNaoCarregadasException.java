package exceptions;

public class NotasNaoCarregadasException extends IllegalArgumentException {
    public NotasNaoCarregadasException() {
        super("Notas não carregadas.");
    }

    public NotasNaoCarregadasException(String mensagem) {
        super(mensagem);
    }
}
