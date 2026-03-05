/*
OBJETIVO: Receba 2 números inteiros, verifique qual o maior entre eles. Calcule e mostre o resultado da somatória dos números ímpares entre esses valores.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 04/03/2026
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lote1Ex35EstRep {
    public static final int MAX_TRIES = 5;

    public static void main(String[] args) {
        int num1, num2, maior, menor, somaImpares = 0, tries = 0;

        Scanner entrada = new Scanner(System.in);

        while (true) {
            if (tries == MAX_TRIES) {
                System.out.println("Tentativa " + tries + "/" + MAX_TRIES + ": máximo de tentativas atingido. O programa será encerrado.");

                entrada.close();

                return;
            }

            try {
                System.out.print("Primeiro número: ");
                num1 = entrada.nextInt();
                
                System.out.print("Segundo número: ");
                num2 = entrada.nextInt();

                if (num1 == num2) throw new IllegalArgumentException("os números precisam ser diferentes.");

                maior = Math.max(num1, num2);
                menor = Math.min(num1, num2);

                StringBuilder msgResultado = new StringBuilder("");

                int totalImpares = 0;
                for (int i = menor; i <= maior; i++) if (i % 2 != 0) totalImpares++;
                
                int contador = 0;
                for (int i = menor; i <= maior; i++) {
                    if (i % 2 != 0) {
                        if ((contador < 5) || (contador >= (totalImpares - 5)) || (contador == 5 && contador + 1 > totalImpares / 2)) {
                            msgResultado.append(i < 0 ? "(" + i + ")" : i);

                            if (i != maior && i + 1 != maior) msgResultado.append(" + ");

                        } else if (contador == 5 && contador + 1 <= totalImpares / 2) msgResultado.append("... + ");
                        
                        contador++;
                        somaImpares += i;

                    }
                }

                msgResultado.append(" = " + somaImpares);

                System.out.println(msgResultado);

                entrada.close();

                return;

            } catch (InputMismatchException e) {
                tries++;

                if (tries < MAX_TRIES) System.out.println("Tentativa " + tries + "/" + MAX_TRIES + ": Os valores precisam ser números inteiros.");

                entrada.nextLine();
                
            } catch (IllegalArgumentException e) {
                tries++;

                if (tries < MAX_TRIES) System.out.println("Tentativa " + tries + "/" + MAX_TRIES + ": " + e.getMessage());

            }
        }
    }
}
