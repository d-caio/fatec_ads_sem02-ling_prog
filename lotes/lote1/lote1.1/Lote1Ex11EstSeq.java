//Receba o raio de uma circunferência. Calcule e mostre o comprimento da circunferência.

import javax.swing.JOptionPane;

public class Lote1Ex11EstSeq {
    public static void main(String args[]) {
        double r, c;

        try {
            r = Double.parseDouble(JOptionPane.showInputDialog("Raio da circunferência: "));

            c = 2 * Math.PI * r;

            JOptionPane.showMessageDialog(null, "O comprimento da circunferência é " + c);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
