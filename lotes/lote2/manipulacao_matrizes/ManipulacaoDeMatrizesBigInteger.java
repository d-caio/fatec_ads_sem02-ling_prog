package lote2.manipulacao_matrizes;

import java.math.BigInteger;

public class ManipulacaoDeMatrizesBigInteger extends ManipulacaoDeMatrizesNumericas<BigInteger> {
    private BigInteger[][] matriz = getMatriz();

    public ManipulacaoDeMatrizesBigInteger(int numDeLinhas, int numDeColunas) {
        super(BigInteger.class, numDeLinhas, numDeColunas);

        BigInteger item = new BigInteger("1");
        
        for (int i = 0; i < numDeLinhas; i++) {
            for (int j = 0; j < numDeColunas; j++) {
                adicionarItem(i, j, item);

                item = item.multiply(new BigInteger("2"));
            }
        }
    }

    @Override
    public BigInteger[] SomaVetorialDaMatriz(int indiceDeReferencia, int indiceIterador, boolean isLinha) {
        BigInteger[] somaVetorial = new BigInteger[indiceDeReferencia];

        for (int i = 0; i < indiceDeReferencia; i++) {
            BigInteger soma = new BigInteger("0");

            for (int j = 0; j < indiceIterador; j++) {
                if (isLinha)
                    soma = matriz[i][j].multiply(soma);
                
                else
                    soma = matriz[j][i].multiply(soma);

            }

            somaVetorial[i] = soma;
        }

        return somaVetorial;
    }

    @Override
    public BigInteger somaDaMatriz() {
        BigInteger soma = new BigInteger("0");

        for (BigInteger[] vetor:matriz)
            for (BigInteger num:vetor)
                soma = num.add(soma);

        return soma;
    }
}
