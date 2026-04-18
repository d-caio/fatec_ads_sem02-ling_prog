/*
OBJETIVO: Calcule e mostre quantos anos serão necessários para que Ana seja maior que Maria sabendo que Ana tem 1,10 m e cresce 3 cm ao ano e Maria tem 1,5 m e cresce 2 cm ao ano.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 26/03/2026
*/

public class Lote1Ex43ModFunc {
    private static final double ALTURA_ANA = 1.1;
    private static final double ALTURA_MARIA = 1.5;
    private static final double CRESC_ANA = 0.03;
    private static final double CRESC_MARIA = 0.02;

    private static StringBuilder msgBuilder = new StringBuilder();

    public static void main(String[] args) {
        int anos = anosParaAnaFicarMaiorQueMaria(ALTURA_ANA, ALTURA_MARIA, 0);

        msgBuilder.insert(0, "Ana levará " + anos + " anos para ficar maior que Maria.\n");

        System.out.println(msgBuilder.toString());
    }

    private static int anosParaAnaFicarMaiorQueMaria(double ana, double maria, int count) {
        msgBuilder.append("\n").append("Ano ").append(count).append("\n  Ana: ").append(String.format("%.2f", ana)).append("; Maria: ").append(String.format("%.2f", maria)).append("\n");
        
        if (ana > maria)
            return count;

        return anosParaAnaFicarMaiorQueMaria(ana + CRESC_ANA, maria + CRESC_MARIA, count + 1);
    }
}
