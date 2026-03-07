/*
OBJETIVO: Calcule e mostre quantos anos serão necessários para que Ana seja maior que Maria sabendo que Ana tem 1,10 m e cresce 3 cm ao ano e Maria tem 1,5 m e cresce 2 cm ao ano.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 06/03/2026
*/

import java.text.NumberFormat;
import java.util.Locale;

public class Lote1Ex43EstRep {
    private static final double CRESC_ANA = 0.03, CRESC_MARIA = 0.02;

    public static void main(String[] args) {
        double alturaAna = 1.1, alturaMaria = 1.5;
        int anos = 0;
        boolean isAnaMaior = false;
        
        NumberFormat formatador = NumberFormat.getInstance(Locale.of("pt", "BR"));
        formatador.setMinimumFractionDigits(2);
        formatador.setMaximumFractionDigits(2);
        
        do {
            anos++;

            alturaAna += CRESC_ANA;
            alturaMaria += CRESC_MARIA;

            String alturaAnaFormatado = formatador.format(alturaAna);
            String alturaMariaFormatado = formatador.format(alturaMaria);

            System.out.println("Em " + anos + (anos <= 1 ? " ano" : " anos") + ", Ana terá " + alturaAnaFormatado + "m e será " + (alturaAna > alturaMaria ? "maior que Maria, que terá " : "menor que Maria, que terá ") + alturaMariaFormatado + "m.");

            if (alturaAna > alturaMaria)
                isAnaMaior = true;

        } while (!isAnaMaior);
    }
}
