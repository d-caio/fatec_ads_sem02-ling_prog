package menus;

import java.math.BigDecimal;

import inputs_outputs.InputsEOutputs;

public class MenuDeEscrita {
    String titulo;
    String texto;

    public MenuDeEscrita(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

    public BigDecimal informarValor() {
        String inputDoValor = InputsEOutputs.mostrarDialogoDeInput(
            titulo,
            texto
        );

        if (inputDoValor == null)
            throw new NullPointerException("Programa encerrado pelo usuário.");

        BigDecimal valor = new BigDecimal(inputDoValor);

        return valor;
    }
}
