/*
OBJETIVO: Criar e carregar uma matriz [4][3] inteiro com quantidade de produtos vendidos em 4 semanas. Calcular e exibir:
        a. A quantidade de cada produto vendido no mês;
        b. A quantidade de produtos vendidos por semana;
        c. O total de produtos vendidos no mês.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 14/03/2026
*/

package lote2;

import java.util.Arrays;

import lote2.manipulacao_matrizes.ManipulacaoDeMatrizesInteger;

public class Lote2Ex08Mat {
    private static final int NUM_DE_LINHAS = 4;
    private static final int NUM_DE_COLUNAS = 3;
    
    public static void main(String[] args) {
        var matriz = new ManipulacaoDeMatrizesInteger(NUM_DE_LINHAS, NUM_DE_COLUNAS, 0, 100);

        Integer[] qtdsDeCadaProdutoVendido = matriz.SomaVetorialDaMatriz(NUM_DE_COLUNAS, NUM_DE_LINHAS, false);

        Integer[] qtdsDeProdutosVendidosPorSemana = matriz.SomaVetorialDaMatriz(NUM_DE_LINHAS, NUM_DE_COLUNAS, true);

        Integer totalDeProdutosVendidos = matriz.somaDaMatriz();

        System.out.println("Matriz: " + Arrays.deepToString(matriz.getMatriz()));

        System.out.println("\nQuantidade de cada produto vendido no mês: " + Arrays.toString(qtdsDeCadaProdutoVendido));

        System.out.println("\nQuantidade de produtos vendidos por semana: " + Arrays.toString(qtdsDeProdutosVendidosPorSemana));

        System.out.println("\nTotal de produtos vendidos: " + totalDeProdutosVendidos);
    }
}
