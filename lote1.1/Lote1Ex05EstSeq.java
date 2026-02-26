//Receba os coeficientes A, B e C de uma equação do 2º grau (AX²+BX+C=0). Calcule e mostre as raízes reais (considerar que a equação possue2 raízes).

import javax.swing.JOptionPane;

public class Lote1Ex05EstSeq {
    public static void main(String args[]) {
        int a, b, c;
        double delta, raiz1, raiz2;

        a = Integer.parseInt(JOptionPane.showInputDialog("Valor de A: "));
        b = Integer.parseInt(JOptionPane.showInputDialog("Valor de B: "));
        c = Integer.parseInt(JOptionPane.showInputDialog("Valor de C: "));

        delta = (Math.pow(b, 2) - 4 * a * c);
        raiz1 = (-b + Math.sqrt(delta) / (2 * a));
        raiz2 = (-b - Math.sqrt(delta) / (2 * a));

        JOptionPane.showMessageDialog(null, "A primeira raiz é " + raiz1 + " e a segunda é " + raiz2);
    }
}
