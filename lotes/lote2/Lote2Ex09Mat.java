/*
OBJETIVO: Criar e carregar uma matriz [4][4] com valores aleatórios, sendo que a diagonal principal terá seus dados carregados no programa segundo:
    |1 |  |  |  |
    |  |4 |  |  |
    |  |  |16|  |
    |  |  |  |64|
PROGRAMADOR: Caio Dias (d-caio).
DATA: 14/03/2026
*/

package lote2;

import java.util.Arrays;
import lote2.manipulacao_matrizes.ManipulacaoDeMatrizesInteger;

public class Lote2Ex09Mat {
    public static void main(String[] args) {
        var matriz = new ManipulacaoDeMatrizesInteger(4, 4, -999, 999, 4);

        Integer[][] mat = matriz.getMatriz();

        for (Integer[] vetor:mat) {
            System.out.println(Arrays.toString(vetor));
        }
    }
}
