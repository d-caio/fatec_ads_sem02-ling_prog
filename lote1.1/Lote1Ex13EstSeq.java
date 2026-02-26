//Receba a quantidade de alimento em quilos. Calcule e mostre quantos dias durará esse alimento sabendo que a pessoa consome 50g ao dia.

import java.util.Scanner;

public class Lote1Ex13EstSeq {
    public static void main(String args[]) {
        try {
            Scanner input = new Scanner(System.in);

            System.out.print("Quantidade de alimentos em kg: ");

            double qtd = input.nextDouble();
            input.close();

            double dias = Math.ceil((qtd * 1000) / 50);

            System.out.println("A comida durará " + dias + " dias.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
