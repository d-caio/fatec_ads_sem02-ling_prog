/*
OBJETIVO: Mostre todas as possibilidades de 2 dados de forma que a soma tenha como resultado 7.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 06/03/2026
*/

public class Lote1Ex41EstRep {
    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                if (i + j == 7)
                    System.out.println("Primeiro dado: " + i + "; segundo dado: " + j);
            }
        }
    }
}