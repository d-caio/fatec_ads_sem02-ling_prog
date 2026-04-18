/*
OBJETIVO: Receba 2 valores inteiros. Calcule e mostre o resultado da diferença do maior pelo menor valor.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 05/03/2026
*/

import java.util.*;
import java.text.*;

public class Lote1Ex18ModProc {
    private static int num1, num2;

    private static final int MAX_TRIES = 5;

    public static void main(String[] args) {
        int tries = 0;

        Scanner entrada = new Scanner(System.in);

        while (true) {
            if (tries == MAX_TRIES) {
                System.out.println("Erro " + tries + "/" + MAX_TRIES + " - Máximo de tentativas atingido. O programa será encerrado.");
                entrada.close();
                return;
            }

            try {
                System.out.print("Primeiro número: ");
                num1 = entrada.nextInt();

                System.out.print("Segundo número: ");
                num2 = entrada.nextInt();

                diferencaMaiorPeloMenor();

                entrada.close();

                return;

            } catch (InputMismatchException e) {
                tries++;

                entrada.nextLine();

                if (tries < MAX_TRIES)
                    System.out.println("Erro " + tries + "/" + MAX_TRIES + " - Os valores pecisam ser números inteiros.");

            } catch (IllegalArgumentException e) {
                tries++;

                entrada.nextLine();

                if (tries < MAX_TRIES)
                    System.out.println("Erro " + tries + "/" + MAX_TRIES + " - " + e.getMessage());

            }
        }
    }

    private static void diferencaMaiorPeloMenor() {
        if (num1 == num2)
            throw new IllegalArgumentException("Os números precisam ser diferentes entre si.");

        NumberFormat formatador = NumberFormat.getInstance(Locale.forLanguageTag("pt"));

        String num1Formatado = formatador.format(num1);
        String num2Formatado = formatador.format(num2);
        String difNum1Maior = formatador.format(num1 - num2);
        String difNum2Maior = formatador.format(num2 - num1);

        if (num1 > num2)
            System.out.println(num2 < 0 ? num1Formatado + " - " + "(" + num2Formatado + ")" + " = " + difNum1Maior : num1Formatado + " - " + num2Formatado + " = " + difNum1Maior);

        else
            System.out.println(num1 < 0 ? num2Formatado + " - " + "(" + num1Formatado + ")" + " = " + difNum2Maior : num2Formatado + " - " + num1Formatado + " = " + difNum2Maior);

    }
}