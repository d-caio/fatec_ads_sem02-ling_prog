//Receba a temperatura em graus Celsius. Calcule e mostre a sua temperatura convertida em fahrenheit F = (9*C+160) /5.

import javax.swing.JOptionPane;

public class Lote1Ex04EstSeq {
    public static void main(String args[]) {
        Double c, f;

        c = Double.parseDouble(JOptionPane.showInputDialog("Temperatura em Celsius: "));

        f = (((9 * c) + 160) / 5);

        JOptionPane.showMessageDialog(null, "A temperatura é de " + f + "F.");
    }
}
