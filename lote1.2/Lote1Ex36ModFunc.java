/*
OBJETIVO: Receba um número N. Calcule e mostre a série 1 + 1/1! + 1/2! + ... + 1/N!
PROGRAMADOR: Caio Dias (d-caio).
DATA: 21/03/2026
*/

import javax.swing.JOptionPane;
import entrada_saida.EntradaSaida;

public class Lote1Ex36ModFunc {
    public static void main(String[] args) {
        try {
            int n = EntradaSaida.entradaInteger("Valor de N: ");

            double resultado = serieEuler(n);

            String msg = msgResultado(n, resultado, "");

            JOptionPane.showMessageDialog(null, msg, "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            EntradaSaida.excecao("N precisa ser um número inteiro.", "erro");
            
        } catch (IllegalArgumentException e) {
            EntradaSaida.excecao(e.getMessage(), "erro");
            
        } catch (NullPointerException e) {
            EntradaSaida.excecao(e.getMessage(), "warning");

        }
    }

    private static double serieEuler(int n) {
        if (n < 1)
            throw new IllegalArgumentException("N precisa ser maior que zero.");

        if (n == 1)
            return 1 + ((double) 1 / fatorial(n));

        return serieEuler(n - 1) + ((double) 1 / fatorial(n));
    }

    private static int fatorial(int n) {
        if (n < 1)
            throw new IllegalArgumentException("N deve ser maior que zero.");

        if (n == 1)
            return n;

        return n * fatorial(n - 1);
    }

    private static String msgResultado(int n, double resultado, String msg) {
        StringBuilder msgBuilder = new StringBuilder(msg).insert(0, " + 1/" + n + "!");

        if (n == 1) {
            msgBuilder.insert(0, "1").append(" = " + resultado);

            return msgBuilder.toString();
        }

        return msgResultado(n - 1, resultado, msgBuilder.toString());
    }
}
