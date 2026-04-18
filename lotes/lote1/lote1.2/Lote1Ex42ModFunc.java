/*
OBJETIVO: Calcule e mostre a série 1 + 2/3 + 3/5 + ... + 50/99
PROGRAMADOR: Caio Dias (d-caio).
DATA: 26/03/2026
*/

public class Lote1Ex42ModFunc {
    private static final int DIVIDENDO_MIN = 1;
    private static final int DIVISOR_MIN = 1;
    private static final int DIVIDENDO_MAX = 50;

    private static StringBuilder msgBuilder = new StringBuilder();

    public static void main(String[] args) {
        double resultado = seqFracoes(DIVIDENDO_MIN, DIVISOR_MIN, DIVIDENDO_MAX);

        msgBuilder.append(String.format("%.4f", resultado));

        String msg = msgBuilder.toString();

        System.out.println(msg);
    }

    private static double seqFracoes(int dividendo, int divisor, int max) {
        msgBuilder.append(dividendo).append("/").append(divisor);
        
        if (dividendo == max) {
            msgBuilder.append(" = ");
            
            return (double) dividendo / divisor;
        }

        msgBuilder.append(" + ");

        return ((double) dividendo / divisor) + seqFracoes(dividendo + 1, divisor + 2, max);
    }
}
