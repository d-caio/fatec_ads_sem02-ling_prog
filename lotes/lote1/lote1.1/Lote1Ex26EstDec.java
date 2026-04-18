/*
OBJETIVO: Receba 2 números inteiros. Verifique e mostre se o maior número é múltiplo do menor.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 02/03/2026
*/

import java.util.*;

public class Lote1Ex26EstDec {
    public static void main(String[] args) {
        int n1, n2, maior, menor;

        try (Scanner inputNum = new Scanner(System.in)) {
            System.out.print("Primeiro número: ");
            n1 = inputNum.nextInt();
            
            System.out.print("Segundo número: ");
            n2 = inputNum.nextInt();

            if (n1 == n2) throw new IllegalArgumentException("Os números precisam ser diferentes.");

            maior = Math.max(n1, n2);
            menor = Math.min(n1, n2);

            System.out.println((maior % menor == 0) ? maior + " é múltiplo de " + menor : maior + " não é múltiplo de " + menor);

        } catch (InputMismatchException e) {
            System.out.println("Os valores precisam ser números inteiros.");
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }
    }
}
