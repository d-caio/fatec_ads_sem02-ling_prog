/*
OBJETIVO: Serie2 = (N) + (N-1) + (N-2) + ... + (1)
PROGRAMADOR: Caio Dias (d-caio).
DATA: 14/03/2026
*/

package recursividade;

import javax.swing.JOptionPane;

public class Recursividade02 {
    public static void main(String[] args) {
        int n, resultado;

        try {
            String entradaN = JOptionPane.showInputDialog("Valor de N: ");

            if (entradaN == null) {
                JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.", "Fim", JOptionPane.WARNING_MESSAGE);

                return;
            }

            n = Integer.parseInt(entradaN);

            resultado = serie02(n);

            JOptionPane.showMessageDialog(null, "N = " + n + "\n\nO resultado da série (N + (N - 1) + (N - 2) + ... + (1)) é " + resultado + ".", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "N precisa ser um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
            
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        }
    }

    private static int serie02(int n) {
        if (n < 1)
            throw new IllegalArgumentException("N precisa ser maior ou igual a 1.");

        if (n == 1)
            return n;

        return (n + serie02(n - 1));
    }
}
