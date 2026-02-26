//Receba a base e a altura de um triângulo. Calcule e mostre a sua área.

import javax.swing.JOptionPane;

public class Lote1Ex03EstSeq {
    public static void main(String args[]) {
        Double base, altura, area;

        base = Double.parseDouble(JOptionPane.showInputDialog("Base do triângulo: "));

        altura = Double.parseDouble(JOptionPane.showInputDialog("Altura do triângulo: "));

        area = ((base * altura) / 2);

        JOptionPane.showMessageDialog(null, "A área do triângulo é " + area + ".");
    }
}
