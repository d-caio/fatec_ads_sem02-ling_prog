/*
        Receba 4 notas bimestrais de um aluno. Calcule e mostre a média aritmética. Mostre a mensagem de acordo com a média:
        a. Se a média for >= 6,0 exibir “APROVADO”;
        b. Se a média for >= 3,0 E < 6,0 exibir “EXAME”;
        c. Se a média for < 3,0 exibir “RETIDO”.
*/

import javax.swing.JOptionPane;
import java.util.stream.DoubleStream;

public class Lote1Ex21EstDec {
    static final double NOTA_MIN = 0;
    static final double NOTA_MAX = 10;
    
    public static void main(String args[]) {
        double n1, n2, n3, n4, m;
        String inputN;

        try {
            inputN = JOptionPane.showInputDialog("Primeira nota: ");
            if (inputN == null) {
                JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.");
                return;
            }
            n1 = Double.parseDouble(inputN);

            inputN = JOptionPane.showInputDialog("Segunda nota: ");
            if (inputN == null) {
                JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.");
                return;
            }
            n2 = Double.parseDouble(inputN);

            inputN = JOptionPane.showInputDialog("Terceira nota: ");
            if (inputN == null) {
                JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.");
                return;
            }
            n3 = Double.parseDouble(inputN);

            inputN = JOptionPane.showInputDialog("Quarta nota: ");
            if (inputN == null) {
                JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.");
                return;
            }
            n4 = Double.parseDouble(inputN);

            if (DoubleStream.of(n1, n2, n3, n4).anyMatch(n -> n > NOTA_MAX || n < NOTA_MIN)) throw new IllegalArgumentException("As notas devem ser entre 0 e 10.");

            m = ((n1 + n2 + n3 + n4) / 4);

            if (m >= 6) JOptionPane.showMessageDialog(null, "Média: " + m + "\nAprovado.");

            else if (m < 6 && m >=3) JOptionPane.showMessageDialog(null, "Média: " + m + "\nExame.");

            else JOptionPane.showMessageDialog(null, "Média: " + m + "\nRetido.");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "As notas devem ser números entre 0 e 10.");
            
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }
}
