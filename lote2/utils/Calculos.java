package lote2.utils;

import java.util.List;

public class Calculos {
    public static double media(List<Integer> vetor) {
        int soma = 0;
        double media;

        for (Integer num : vetor)
            soma += num.intValue();

        media = (double) soma / vetor.size();

        return media;
    }

    public static int somaLista(List<Integer> vetor) {
        int soma = 0;

        for (Integer num : vetor)
            soma += num.intValue();

        return soma;
    }
}
