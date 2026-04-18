/*
OBJETIVO: Criar uma matriz [8][8] inteiro e o programa irá carregar segundo:
    1|1|1|1|1|1|1|1
    1|2|2|2|2|2|2|1
    1|2|3|3|3|3|2|1
    1|2|3|4|4|3|2|1
    1|2|3|4|4|3|2|1
    1|2|3|3|3|3|2|1
    1|2|2|2|2|2|2|1
    1|1|1|1|1|1|1|1
PROGRAMADOR: Caio Dias (d-caio)
DATA: 20/03/2026
*/

package lote2;

import java.util.Arrays;

import lote2.manipulacao_matrizes.ManipulacaoDeMatrizesInteger;

public class Lote2Ex11Mat {
    public static void main(String[] args) {
        var matrizInt = new ManipulacaoDeMatrizesInteger(8, 8);

        Integer[][] matriz = matrizInt.getMatriz();

        for (Integer[] vetor:matriz)
            System.out.println(Arrays.toString(vetor));
    }
}
