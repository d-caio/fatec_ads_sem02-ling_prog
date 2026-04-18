/*
OBJETIVO: Receba 100 números inteiros reais. Verifique e mostre o maior e o menor valor. Obs.: somente valores positivos.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 05/03/2026
*/

import java.text.NumberFormat;
import java.util.Locale;

public class Lote1Ex38EstRep {
    private static final int TOTAL_LOOPS = 100;

    public static void main(String[] args) {
        double num, maior = 0.0, menor = 0.0;
        NumberFormat formatador = NumberFormat.getInstance(Locale.of("en", "UK"));
        formatador.setMaximumFractionDigits(3);

        StringBuilder msgResultado = new StringBuilder("Números gerados aleatoriamente: ");

        for (int i = 0; i < TOTAL_LOOPS; i++) {
            num = (Math.random() * 100);

            if (num > maior)
                maior = num;

            if (num < menor || i == 0)
                menor = num;

            String numFormatado = formatador.format(num);

            msgResultado.append(numFormatado);

            if (i + 1 < TOTAL_LOOPS)
                msgResultado.append(", ");
        }

        String maiorFormatado = formatador.format(maior);
        String menorFormatado = formatador.format(menor);
        
        msgResultado.append("\n").append("Maior número gerado: ").append(maiorFormatado).append("\n").append("Menor número gerado: ").append(menorFormatado);

        System.out.println(msgResultado);
    }
}
