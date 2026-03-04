/*
OBJETIVO: Receba um número. Calcule e mostre os resultados da tabuada desse número.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 04/03/2026
*/

import javax.swing.JOptionPane;

public class Lote1Ex34EstRep {
    public static final int NUM_MIN = 1;
    public static final int NUM_MAX = 10;
    
    public static final int MAX_TRIES = 5;

    public static void main(String[] args) {
        int num, tries = 0;

        while (true) {
            try {
                if (tries == MAX_TRIES) {
                    JOptionPane.showMessageDialog(null, "Máximo de tentativas atingido.  programa será encerrado.", "Tentativa " + tries + "/" + MAX_TRIES, JOptionPane.ERROR_MESSAGE);

                    return;
                }

                String inputNum = JOptionPane.showInputDialog("Informe um número entre 1 e 10: ");

                if (inputNum == null) {
                    JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.", "Fim", JOptionPane.WARNING_MESSAGE);

                    return;
                }

                num = Integer.parseInt(inputNum);

                if (num < NUM_MIN || num > NUM_MAX) throw new IllegalArgumentException("O número precisa ser entre " + NUM_MIN + " e " + NUM_MAX + ".");

                StringBuilder msgResultado = new StringBuilder("");

                for (int i = NUM_MIN; i <= NUM_MAX; i++) msgResultado.append(num + " x " + i + " = " + num * i + "\n");

                JOptionPane.showMessageDialog(null, msgResultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);

                return;

            } catch (NumberFormatException e) {
                tries++;

                if (tries < MAX_TRIES) JOptionPane.showMessageDialog(null, "O valor precisa ser um número inteiro entre " + NUM_MIN + " e " + NUM_MAX + ".", "Tentativa " + tries + "/" + MAX_TRIES, JOptionPane.ERROR_MESSAGE);
                
            } catch (IllegalArgumentException e) {
                tries++;
                
                if (tries < MAX_TRIES) JOptionPane.showMessageDialog(null, e.getMessage(), "Tentativa " + tries + "/" + MAX_TRIES, JOptionPane.ERROR_MESSAGE);

            }
        }

    }
}
