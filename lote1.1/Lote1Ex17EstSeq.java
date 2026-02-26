//Calcule a quantidade de litros gastos em uma viagem, sabendo que o automóvel faz 12 km/l. Receber o tempo de percurso e a velocidade média.

import javax.swing.JOptionPane;

public class Lote1Ex17EstSeq {
    public static void main(String args[]) {
        double t, v, l;

        try {
            t = Double.parseDouble(args[0]);
            v = Double.parseDouble(args[1]);

            if (t <= 0 || v <= 0) {
                throw new IllegalArgumentException("Tempo e velocidade devem ser maiores que zero.");
            }

            l = ((t * v) / 12);

            JOptionPane.showMessageDialog(null, "Na viagem foram gastos " + l + "l." );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
