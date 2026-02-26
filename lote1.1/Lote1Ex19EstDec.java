//Receba 2 valores reais. Calcule e mostre o maior deles.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lote1Ex19EstDec {
    public static void main(String args[]) {
        try {
            Scanner inputNum = new Scanner(System.in);

            System.out.print("Primeiro número: ");
            double num1 = inputNum.nextDouble();
        
            System.out.print("Segundo número: ");
            double num2 = inputNum.nextDouble();
            inputNum.close();

            double maior;

            if (num1 > num2) maior = num1;
            else if (num2 > num1) maior = num2;
            else throw new IllegalArgumentException("Os números são iguais.\n");

            System.out.print("O maior número é " + maior + ".\n");
            
        } catch (InputMismatchException e) {
            System.out.print("Os valores precisam ser números reais.\n");
        
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());

        }
    }
}
