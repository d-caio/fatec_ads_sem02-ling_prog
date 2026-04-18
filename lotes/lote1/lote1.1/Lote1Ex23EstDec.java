/*
OBJETIVO: Receba 3 valores obrigatoriamente em ordem crescente e um 4º valor não necessariamente em ordem. Mostre os 4 números em ordem crescente.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 01/03/2026
*/

import java.util.*;

public class Lote1Ex23EstDec {
    public static void main(String args[]) {
        double num1, num2, num3, num4;

        try {
            Scanner entradaNum = new Scanner(System.in);

            System.out.print("Digite o primeiro número: ");
            num1 = entradaNum.nextDouble();

            System.out.print("Digite o segundo número (maior que o primeiro): ");
            num2 = entradaNum.nextDouble();
            if (num2 <= num1) {
                entradaNum.close();

                throw new IllegalArgumentException("O segundo número deve ser maior do que o primeiro.");
            }

            System.out.print("Digite o terceiro número (maior que o segundo e o primeiro): ");
            num3 = entradaNum.nextDouble();
            if (num3 <= num2) {
                entradaNum.close();

                throw new IllegalArgumentException("O terceiro número deve ser maior do que o segundo e o primeiro.");
            }

            System.out.print("Digite o quarto número (Sem ordem necessária, mas diferente dos outros três.): ");
            num4 = entradaNum.nextDouble();
            entradaNum.close();
            if (num4 == num1 || num4 == num2 || num4 == num3 ) throw new IllegalArgumentException("Todos os números devem ser diferentes entre si.");

            if (num4 < num1) System.out.println("Números em ordem crescente: " + num4 + ", " + num1 + ", " + num2 + ", " + num3);

            else if (num4 < num2) System.out.println("Números em ordem crescente: " + num1 + ", " + num4 + ", " + num2 + ", " + num3);

            else if (num4 < num3) System.out.println("Números em ordem crescente: " + num1 + ", " + num2 + ", " + num4 + ", " + num3);

            else System.out.println("Números em ordem crescente: " + num1 + ", " + num2 + ", " + num3 + ", " + num4);

        } catch (InputMismatchException e) {
            System.out.println("Os valores devem ser numéricos.");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
