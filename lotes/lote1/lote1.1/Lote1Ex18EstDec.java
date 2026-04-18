//Receba 2 valores inteiros. Calcule e mostre o resultado da diferença do maior pelo menor valor.

import javax.swing.*;

public class Lote1Ex18EstDec {
    public static void main(String args[]) {
        try {
            String inputNum1 = JOptionPane.showInputDialog("Primeiro número: ");
            if (inputNum1 == null) {
                JOptionPane.showMessageDialog(null, "Programa fechado pelo usuário.");
                return;
            }
            int num1 = Integer.parseInt(inputNum1);

            String inputNum2 = JOptionPane.showInputDialog("Segundo número: ");
            if (inputNum2 == null) {
                JOptionPane.showMessageDialog(null, "Programa fechado pelo usuário.");
                return;
            }
            int num2 = Integer.parseInt(inputNum2);

            if (num1 > num2) JOptionPane.showMessageDialog(null, num1 + " - " + num2 + " = " + (num1 - num2));

            else JOptionPane.showMessageDialog(null, num2 + " - " + num1 + " = " + (num2 - num1));

            return;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Os números devem ser inteiros.");
        }
    }
}
