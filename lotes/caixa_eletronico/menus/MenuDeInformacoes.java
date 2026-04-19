package menus;

import inputs_outputs.InputsEOutputs;

public class MenuDeInformacoes {
    private String titulo;
    private String texto;

    public MenuDeInformacoes(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

    public String getTitulo() { return titulo; }

    public String getTexto() { return texto; }

    public void mostrarInformacoes() {
        InputsEOutputs.mostrarMensagemDeSucesso(titulo, texto);
    }
}
