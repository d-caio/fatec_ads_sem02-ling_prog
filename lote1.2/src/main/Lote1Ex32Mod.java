/*
OBJETIVO: Receba um número inteiro. Calcule e mostre o seu fatorial.
PROGRAMADOR: Caio Dias (d-caio)
DATA DA CRIAÇÃO: 26/02/2026
*/

import java.util.InputMismatchException;
import java.util.Scanner;
import classes.LoopMath;

public class Lote1Ex32Mod {
    public static void main(String[] args) {
        int num, fat;

        try {
            Scanner inputNum = new Scanner(System.in);

            System.out.print("Informe um número inteiro: ");
            num = inputNum.nextInt();
            inputNum.close();

            fat = new LoopMath().fatorial(num);

            System.out.println(num + "! = " + fat);

        } catch (InputMismatchException e) {
            System.out.println("O valor precisa ser um número inteiro.");
            
        }

    }  
}
