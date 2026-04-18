package menus;

import javax.swing.JOptionPane;

abstract class MenuDeOpcoes {
    private Opcao[] opcoes;
    private String texto;
    private String titulo;

    protected MenuDeOpcoes(String titulo, Opcao... opcoes) {
        this.titulo = titulo;

        this.opcoes = new Opcao[opcoes.length];

        var textoBuilder = new StringBuilder();

        for (int i = 0; i < opcoes.length; i++) {
            textoBuilder
                    .append(opcoes[i].codigo)
                    .append(" - ")
                    .append(opcoes[i].nome)
                    .append("\n");

            this.opcoes[i] = opcoes[i];
        }

        this.texto = textoBuilder.toString();

    }

    public int selecionarOpcao() {
        String entrada = JOptionPane.showInputDialog(
                null,
                texto,
                titulo,
                JOptionPane.QUESTION_MESSAGE);

        if (entrada == null) {
            JOptionPane.showMessageDialog(
                    null,
                    "Programa encerrado pelo(a) usuário(a).",
                    "Fim",
                    JOptionPane.WARNING_MESSAGE);

            return -1;
        }

        int opcaoSelecionada = Integer.parseInt(entrada);

        boolean isOpcaoValida = false;

        for (Opcao opcao : opcoes)
            if (opcaoSelecionada == opcao.codigo) {
                isOpcaoValida = true;
                break;
            }

        if (!isOpcaoValida)
            throw new IllegalArgumentException("Opção inválida.");

        return opcaoSelecionada;

    }
}