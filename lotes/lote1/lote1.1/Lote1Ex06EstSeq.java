//Receba os valores em x e y. Efetua a troca de seus valores e mostre seus conteúdos.

import javax.swing.JOptionPane;

public class Lote1Ex06EstSeq {
    public static void main(String args[]) {
        double x, y, temp;

        x = Double.parseDouble(JOptionPane.showInputDialog("Valor de x: "));
        y = Double.parseDouble(JOptionPane.showInputDialog("Valor de y: "));

        temp = x;
        x = y;
        y = temp;

        JOptionPane.showMessageDialog(null, "x = " + x + " e y = " + y + ".");
    }
}
