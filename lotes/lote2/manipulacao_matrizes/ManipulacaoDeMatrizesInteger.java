package lote2.manipulacao_matrizes;

import java.util.concurrent.ThreadLocalRandom;

public class ManipulacaoDeMatrizesInteger extends ManipulacaoDeMatrizesNumericas<Integer> {
    private Integer[][] matriz = getMatriz();
    
    public ManipulacaoDeMatrizesInteger(int numDeLinhas, int numDeColunas, int vlrMinDosItens, int vlrMaxDosItens) {
        super(Integer.class, numDeLinhas, numDeColunas);

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                Integer item = ThreadLocalRandom.current().nextInt(vlrMinDosItens, vlrMaxDosItens + 1);

                adicionarItem(i, j, item);
            }
        }
    }

    public ManipulacaoDeMatrizesInteger(int numDeLinhas, int numDeColunas, int vlrMinDosItens, int vlrMaxDosItens, int base) {
        super(Integer.class, numDeLinhas, numDeColunas);

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                Integer item = (i == j) ? Math.powExact(base, i) : ThreadLocalRandom.current().nextInt(vlrMinDosItens, vlrMaxDosItens + 1);

                adicionarItem(i, j, item);
            }
        }        
    }

    public ManipulacaoDeMatrizesInteger(int numDeLinhas, int numDeColunas) {
        super(Integer.class, numDeLinhas, numDeColunas);

        Integer item = 1, vlrMax = (numDeColunas / 2);
        int indiceMin = 0, indiceMax = numDeColunas;

        while (item.intValue() <= vlrMax.intValue()) {
            for (int i = indiceMin; i < indiceMax; i++) {
                for (int j = indiceMin; j < indiceMax; j++) {
                    adicionarItem(i, j, item);
                }
            }

            item = item.intValue() + 1;
            indiceMin++;
            indiceMax--;
        }
    }

    @Override
    public Integer[] SomaVetorialDaMatriz(int indiceDeReferencia, int indiceIterador, boolean isLinha) {
        Integer[] somaVetorial = new Integer[indiceDeReferencia];

        for (int i = 0; i < indiceDeReferencia; i++) {
            Integer soma = 0;

            for (int j = 0; j < indiceIterador; j++) {
                if (isLinha)
                    soma += matriz[i][j].intValue();
                
                else
                    soma += matriz[j][i].intValue();

            }

            somaVetorial[i] = soma;
        }

        return somaVetorial;
    }

    @Override
    public Integer somaDaMatriz() {
        Integer soma = 0;

        for (Integer[] vetor:matriz)
            for (Integer num:vetor)
                soma += num.intValue();

        return soma;
    }
}
