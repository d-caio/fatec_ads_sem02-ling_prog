/*
OBJETIVO: Calcule e mostre a série 1 – 2/4 + 3/9 – 4/16 + 5/25 + ... + 15/225
PROGRAMADOR: Caio Dias (d-caio).
DATA: 26/03/2026
*/

public class Lote1Ex45ModFunc {
    private static final int DIVIDENDO = 1;
    private static final int DIVIDENDO_MAX = 15;

    private static StringBuilder msgBuilder = new StringBuilder();

    public static void main(String[] args) {
        double resultado = seqFracoes(DIVIDENDO, DIVIDENDO_MAX, false);

        msgBuilder.append(resultado);

        String msg = msgBuilder.toString();

        System.out.println(msg);
    }

    private static double seqFracoes(int dividendo, int max, boolean isSoma) {
        int divisor = dividendo * dividendo;

        msgBuilder.append(dividendo).append("/").append(divisor);

        double termo = (double) dividendo / divisor;

        if (dividendo == max) {
            msgBuilder.append(" = ");
            return termo;
        }

        String sinal;

        if (!isSoma)
            sinal = " - ";

        else {
            sinal = " + ";
            termo = -termo;
        }

        msgBuilder.append(sinal);
        return termo + seqFracoes(dividendo + 1, max, !isSoma);

    }
}
