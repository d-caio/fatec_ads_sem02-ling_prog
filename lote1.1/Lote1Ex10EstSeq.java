//Receba 2 números reais. Calcule e mostre a diferença desses valores.

import javax.swing.JOptionPane;

public class Lote1Ex10EstSeq {
    public static void main(String args[]) {
        try {
            double diff = Double.parseDouble(args[0]) - Double.parseDouble(args[1]);

            JOptionPane.showMessageDialog(null, args[0] + " - " + args[1] + " = " + diff);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
