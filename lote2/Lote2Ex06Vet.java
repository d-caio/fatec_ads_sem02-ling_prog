/*
OBJETIVO: Criar e coletar em um vetor [20] com números aleatórios. Classificar este vetor em ordem crescente e mostre os dados.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 12/03/2026
*/

package lote2;

import java.util.Arrays;

import lote2.manipulacao_vetores.ManipulacaoDeVetoresDouble;

public class Lote2Ex06Vet {
    private static final int TAMANHO_DO_VETOR = 20;
    private static final double VLR_MIN_DOS_ITENS = -500.00;
    private static final double VLR_MAX_DOS_ITENS = 500.00;

    public static void main(String[] args) {
        var vetor = new ManipulacaoDeVetoresDouble(TAMANHO_DO_VETOR, VLR_MIN_DOS_ITENS, VLR_MAX_DOS_ITENS);

        System.out.println("Vetor original: " + Arrays.toString(vetor.getVetor()));
        
        vetor.bubbleSort();

        System.out.println("\nVetor ordenado: " + Arrays.toString(vetor.getVetor()));
    }
}
