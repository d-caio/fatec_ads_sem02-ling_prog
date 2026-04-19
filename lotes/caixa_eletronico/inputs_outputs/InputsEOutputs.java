package inputs_outputs;

import javax.swing.JOptionPane;

public class InputsEOutputs {
    public static String mostrarDialogoDeInput(String titulo, String texto) {
        return JOptionPane.showInputDialog(
            null,
            texto,
            titulo,
            JOptionPane.QUESTION_MESSAGE
        );
    }

    public static void mostrarMensagemDeSucesso(String titulo, String texto) {
        JOptionPane.showMessageDialog(
            null,
            texto,
            titulo,
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void mostrarMensagemDeAtencao(String titulo, String texto) {
        JOptionPane.showMessageDialog(
            null,
            texto,
            titulo,
            JOptionPane.WARNING_MESSAGE
        );
    }

    public static void mostrarMensagemDeErro(String titulo, String texto) {
        JOptionPane.showMessageDialog(
            null,
            texto,
            titulo,
            JOptionPane.ERROR_MESSAGE
        );
    }
}
