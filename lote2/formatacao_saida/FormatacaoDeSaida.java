package lote2.formatacao_saida;

import java.text.NumberFormat;
import java.util.*;


public class FormatacaoDeSaida {
    @SuppressWarnings("unchecked")
    public static <T extends Number> String[] formatacaoNumerica(String regiao, int minCasasDecimais, int maxCasasDecimais, T... nums) {
        NumberFormat formatador = NumberFormat.getInstance(Locale.forLanguageTag(regiao));
        formatador.setMinimumFractionDigits(minCasasDecimais);
        formatador.setMaximumFractionDigits(maxCasasDecimais);

        String[] numsFormatados = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            String numFormatado = formatador.format(nums[i]);

            numsFormatados[i] = numFormatado;
        }

        return numsFormatados;
    }
}
