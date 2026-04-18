package entrada_saida;

import javax.swing.JOptionPane;

public class EntradaSaida {
    public static int entradaInteger(String msgEntrada) {
        int num;
        
        String entradaNum = inputDialog(msgEntrada);

        num = Integer.parseInt(entradaNum);

        return num;
    }

    public static void excecao(String msg, String tipoDeMsg) {
        JOptionPane.showMessageDialog(null, msg, (tipoDeMsg == "erro") ? "Erro" : "Fim", (tipoDeMsg == "erro") ? JOptionPane.ERROR_MESSAGE : JOptionPane.WARNING_MESSAGE);
    }

    private static String inputDialog(String msgEntrada) {
        String entradaNum = JOptionPane.showInputDialog(msgEntrada);

        if (entradaNum == null)
            throw new NullPointerException("Programa encerrado pelo usuário.");

        return entradaNum;
    }
}
