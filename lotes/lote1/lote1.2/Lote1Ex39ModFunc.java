/*
OBJETIVO: Calcule a quantidade de grãos contidos em um tabuleiro de xadrez onde:
    Casa: 	1	2	3	4	...	64
    Qdte:	1	2	4	8	...	N
PROGRAMADOR: Caio Dias (d-caio).
DATA: 21/03/2026
*/

import java.math.BigInteger;

public class Lote1Ex39ModFunc {
    public static void main(String[] args) {
        BigInteger resultado = somaProgressaoGeometrica(new BigInteger("2"), new BigInteger("1"), 64);

        System.out.println("Quantidade de grãos: " + resultado.toString());
        
    }

    private static BigInteger progressaoGeometrica(BigInteger razao, BigInteger vlrInicial, int termo) {
        if (termo < 1)
            throw new IllegalArgumentException("É preciso haver pelo menos um termo.");

        if (termo == 1)
            return vlrInicial;

        return progressaoGeometrica(razao, vlrInicial, termo - 1).multiply(razao);
    }

    private static BigInteger somaProgressaoGeometrica(
        BigInteger razao,
        BigInteger vlrInicial,
        int termo
    ) {
        if (termo == 1)
            return progressaoGeometrica(razao, vlrInicial, termo);

        return somaProgressaoGeometrica(razao, vlrInicial, termo - 1).add(progressaoGeometrica(razao, vlrInicial, termo));
    }
}
