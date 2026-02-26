//Receba os 2 números inteiros. Calcule e mostre a soma dos quadrados.

import javax.swing.JOptionPane;

public class Lote1Ex09EstSeq {
    public static void main(String args[]) {
        int num1, num2;
        double somaQuadrados;

        try {
            num1 = Integer.parseInt(args[0]);
            num2 = Integer.parseInt(args[1]);

            somaQuadrados = Math.pow(num1, 2) + Math.pow(num2, 2);

            JOptionPane.showMessageDialog(null, "A soma dos quadrados é " + somaQuadrados);
        } catch(ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Erro: Você não passou os args.");
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: Valores não são inteiros.");
        }

    }
}
