/*
OBJETIVO: Calcule e mostre a série 1 + 2/3 + 3/5 + ... + 50/99
PROGRAMADOR: Caio Dias (d-caio).
DATA: 06/03/2026
*/

public class Lote1Ex42EstRep {
    public static void main(String[] args) {
        double resultado = 0;

        for (int i = 1, j = 1; i <= 50; i++, j += 2) {
            resultado += (double) i / j;
            
            if (i == 1)
                System.out.print(i + " + ");

            else if (i == 50)
                System.out.println(i + "/" + j + " = " + resultado);

            else
                System.out.print(i + "/" + j + " + ");
        }
    }
}
