//Receba os valores do comprimento, largura e altura de um paralelepípedo. Calcule e mostre seu volume.

import javax.swing.JOptionPane;

public class Lote1Ex07EstSeq {
    public static void main(String args[]) {
        double c, l, a, v;

        c = Double.parseDouble(JOptionPane.showInputDialog("Comprimento do paralelepípedo: "));
        l = Double.parseDouble(JOptionPane.showInputDialog("Largura do paralelepípedo: "));
        a = Double.parseDouble(JOptionPane.showInputDialog("Altura do paralelepípedo: "));

        v = c * l * a;

        JOptionPane.showMessageDialog(null, "O volume do paralelepípedo é " + v + ".");
    }
}
