/*
OBJETIVO: Criar uma matriz [8][8] onde o programa irá carregar segundo:
    Casa  |1|2|3|4|...| Exibir a soma
    Valor |1|2|4|8|...| dos valores
PROGRAMADOR: Caio Dias (d-caio)
DATA: 20/03/2026
*/

package lote2;

import java.math.BigInteger;
import java.util.Arrays;
import lote2.manipulacao_matrizes.ManipulacaoDeMatrizesBigInteger;

public class Lote2Ex10Mat {
    public static void main(String[] args) {
        var matriz = new ManipulacaoDeMatrizesBigInteger(8, 8);

        BigInteger[][] mat = matriz.getMatriz();

        for (BigInteger[] vetor:mat)
            System.out.println(Arrays.toString(vetor));

        BigInteger soma = matriz.somaDaMatriz();

        System.out.println("\nSoma da Matriz: " + soma);
    }
}
