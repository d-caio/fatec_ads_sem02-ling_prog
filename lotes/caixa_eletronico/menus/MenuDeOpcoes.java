package menus;

import inputs_outputs.InputsEOutputs;

public class MenuDeOpcoes {
    private Opcao[] opcoes;
    private String titulo;
    private String texto;

    public MenuDeOpcoes(String titulo, Opcao... opcoes) {
        this.titulo = titulo;

        this.opcoes = new Opcao[opcoes.length];

        var textoBuilder = new StringBuilder();

        for (int i = 0; i < opcoes.length; i++) {
            textoBuilder
                    .append(opcoes[i].getCodigo())
                    .append(" - ")
                    .append(opcoes[i].getNome())
                    .append("\n");

            this.opcoes[i] = opcoes[i];
        }

        this.texto = textoBuilder.toString();

    }

    public int selecionarOpcao() {
        String inputDeOpcao = InputsEOutputs.mostrarDialogoDeInput(titulo, texto);

        if (inputDeOpcao == null)
            throw new NullPointerException("Programa encerrado pelo usuário.");

        int codigoDaOpcao = Integer.parseInt(inputDeOpcao);

        boolean opcaoValida = false;

        for (Opcao opcao:opcoes)
            if (codigoDaOpcao == opcao.getCodigo()) {
                opcaoValida = true;
                break;
            }

        if (!opcaoValida)
            throw new IllegalArgumentException("Opção inválida.");

        return codigoDaOpcao;
    }
}