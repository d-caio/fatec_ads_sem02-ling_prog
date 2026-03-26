/*
OBJETIVO: Receba um número inteiro. Calcule e mostre a série de Fibonacci até o seu N’nésimo termo.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 21/03/2026
*/

import java.util.Arrays;

import javax.swing.JOptionPane;

import entrada_saida.EntradaSaida;

public class Lote1Ex37ModFunc {
    public static void main(String[] args) {
        try {
            int n = EntradaSaida.entradaInteger("Valor de N: ");

            String msg = Arrays.toString(serieFibonacci(n, new int[n]));

            JOptionPane.showMessageDialog(null, msg, "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            EntradaSaida.excecao("N precisa ser um número inteiro.", "erro");
            
        } catch (IllegalArgumentException e) {
            EntradaSaida.excecao(e.getMessage(), "erro");
            
        } catch (NullPointerException e) {
            EntradaSaida.excecao(e.getMessage(), "warning");

        }
    }

    private static int termoFibonacci(int n) {
        if (n < 1)
            throw new IllegalArgumentException("N precisa ser maior que zero.");

        if (n == 1 || n == 2)
            return 1;

        return termoFibonacci(n - 1) + termoFibonacci(n - 2);
    }

    private static int[] serieFibonacci(int n, int[] serie) {
        if ((n > serie.length) || (n != serie.length && serie[n] == 0))
            throw new IllegalArgumentException("O tamanho do vetor precisa ser igual ao número de termos.");

        serie[n - 1] = termoFibonacci(n);
        
        if (n == 1)
            return serie;

        return serieFibonacci(n - 1, serie);
    }
}
