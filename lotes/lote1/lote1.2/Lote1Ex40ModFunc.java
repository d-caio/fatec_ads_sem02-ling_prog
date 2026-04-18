/*
OBJETIVO: Receba 2 números inteiros. Verifique e mostre todos os números primos existentes entre eles.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 21/03/2026
*/

import java.util.*;
import javax.swing.JOptionPane;

import entrada_saida.EntradaSaida;

public class Lote1Ex40ModFunc {
    private static int num1, num2, maior, menor;

    public static void main(String[] args) {
        try {
            num1 = EntradaSaida.entradaInteger("Primeiro número: ");
            num2 = EntradaSaida.entradaInteger("Segundo número: ");

            maiorMenor();

            List<Integer> primos = verificarPrimos(
                menor,
                maior,
                new ArrayList<Integer>()
            );
            
            JOptionPane.showMessageDialog(
                null,
                (primos.size() > 0) ? "Primos entre " + menor + " e " + maior + ": " + primos.toString() : "Não há primos entre " + menor + " e " + maior + ".",
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE 
            );

        } catch (NumberFormatException e) {
            EntradaSaida.excecao(
                "Os valores precisam ser números inteiros.",
                "erro"
            );
        } catch (IllegalArgumentException e) {
            EntradaSaida.excecao(
                e.getMessage(),
                "erro"
            );
        } catch (NullPointerException e) {
            EntradaSaida.excecao(
                e.getMessage(),
                "warning"
            );
        }
        
    }

    private static void maiorMenor() {
        if (num1 == num2)
            throw new IllegalArgumentException("Os números devem ser diferentes.");

        maior = Math.max(num1, num2);
        menor = Math.min(num1, num2);
    }

    private static List<Integer> verificarPrimos(int menor, int maior, List<Integer> primos) {
        if (menor < 2 && maior < 2) {
            primos.clear();
            return primos;
        }
        
        if (menor < 2 && maior >= 2)
            menor = 2;

        int raiz = (int) Math.sqrt((double) menor);

        if (isPrimo(menor, raiz))
            primos.add(menor);

        if (menor == maior)
            return primos;

        return verificarPrimos(menor + 1, maior, primos);

    }

    private static boolean isPrimo(int dividendo, int divisor) {
        if (dividendo == 2 || dividendo == 3)
            return true;
        
        if ((dividendo < 2) || ((dividendo % divisor == 0) && (divisor != 1)))
            return false;

        if (divisor == 2)
            return true;

        return isPrimo(dividendo, divisor - 1); 
    }
}
