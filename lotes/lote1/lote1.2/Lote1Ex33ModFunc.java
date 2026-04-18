/*
OBJETIVO: Receba um número. Calcule e mostre a série 1 + 1/2 + 1/3 + ... + 1/N.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 16/03/2026
*/

import javax.swing.JOptionPane;

import entrada_saida.EntradaSaida;

public class Lote1Ex33ModFunc {
    public static void main(String[] args) {
        int num;
        double resultado;

        try {
            num = EntradaSaida.entradaInteger("Valor de N: ");

            resultado = serieHarmonica(num);

            String msg = msgSerieHarmonica(num, resultado, "");

            JOptionPane.showMessageDialog(null, msg, "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            EntradaSaida.excecao("N precisa ser um número inteiro.", "erro");

        } catch (NullPointerException | IllegalArgumentException e) {
            EntradaSaida.excecao(e.getMessage(), (e instanceof IllegalArgumentException) ? "erro" : "warning");

        }

    }

    private static double serieHarmonica(int n) {
        double resultado;

        if (n < 1)
            throw new IllegalArgumentException("O número deve ser maior que zero.");

        if (n == 1)
            return n;

        resultado = ((double) 1 / n) + serieHarmonica(n - 1);
        return resultado;
    }

    private static String msgSerieHarmonica(int n, double resultado, String msg) {
        StringBuilder msgBuilder = new StringBuilder(msg);

        if (n == 1) {
            msgBuilder.append(n + " = " + resultado);
            return msgBuilder.toString();
        }

        msgBuilder.append("1/" + n + " + ");
        return msgSerieHarmonica(n - 1, resultado, msgBuilder.toString());
    }
}
