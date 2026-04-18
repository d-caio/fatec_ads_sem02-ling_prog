//Receba os valores de 2 catetos de um triângulo retângulo. Calcule e mostre a hipotenusa.

import javax.swing.JOptionPane;

public class Lote1Ex15EstSeq {
    public static void main(String args[]) {
        double a, b, c;

        try {
            a = Double.parseDouble(JOptionPane.showInputDialog("Valor do primeiro cateto: "));
            b = Double.parseDouble(JOptionPane.showInputDialog("Valor do segundo cateto: "));

            if (a <= 0 || b <= 0) {
                throw new IllegalArgumentException("Os catetos devem ter valores positivos");
            }

            c = Math.hypot(a, b);
            
            JOptionPane.showMessageDialog(null, "A hipotenusa é " + c);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }    
}
