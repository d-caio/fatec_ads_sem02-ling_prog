/*
OBJETIVO: Receba um número inteiro. Calcule e mostre o seu fatorial.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 16/03/2026
*/

import javax.swing.JOptionPane;

public class Lote1Ex32ModFunc {
    public static void main(String[] args) {
        int num, resultado;
        
        try {
            String entradaNum = JOptionPane.showInputDialog("Número: ");

            if (entradaNum == null) {
                JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.", "Fim", JOptionPane.WARNING_MESSAGE);

                return;
            }

            num = Integer.parseInt(entradaNum);

            resultado = fatorial(num);

            StringBuilder msg = new StringBuilder("");

            for (int i = num; i > 0; i--)
                if (i - 1 == 0)
                    msg.append(i + " = " + resultado);
                else
                    msg.append(i + "x");

            JOptionPane.showMessageDialog(null, msg, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O número precisa ser inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
            
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        }
    }

    private static int fatorial(int num) {
        int resultado;

        if (num < 0)
            throw new IllegalArgumentException("O número deve ser 0 ou positivo.");

        if (num == 0)
            return 1;

        if (num == 1)
            return num;

        resultado = num * fatorial(num - 1);

        return resultado;
    }
}
