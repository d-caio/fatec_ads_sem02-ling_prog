//Receba 2 ângulos de um triângulo. Calcule e mostre o valor do 3º ângulo.

import javax.swing.JOptionPane;

public class Lote1Ex14EstSeq {
    public static void main(String args[]) {
        try {
            double ang1 = Double.parseDouble(args[0]);
            double ang2 = Double.parseDouble(args[1]);

            if (ang1 <= 0 || ang2 <= 0) {
                throw new IllegalArgumentException("Os ângulos precisam ser maiores que 0º.");
            }

            if (ang1 + ang2 >= 180) {
                throw new IllegalArgumentException("A soma dos ângulos deve ser menor que 180º.");
            }

            double ang3 = (180 - (ang1 + ang2));

            JOptionPane.showMessageDialog(null, "O valor do terceiro ângulo é de " + ang3 + "º");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
