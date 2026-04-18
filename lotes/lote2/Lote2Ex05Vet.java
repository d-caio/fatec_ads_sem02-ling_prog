/*
OBJETIVO: Criar e coletar em um vetor [20] inteiro. Calcule e exiba, segundo:
10
∑ (A[1] – A[21–1])
i = 1
PROGRAMADOR: Caio Dias (d-caio).
DATA: 10/03/2026
*/

package lote2;

import java.util.Arrays;

import lote2.formatacao_saida.FormatacaoDeSaida;
import lote2.manipulacao_vetores.ManipulacaoDeVetoresInteger;

public class Lote2Ex05Vet {
    private static final int TAMANHO_DO_VETOR = 20;

    public static void main(String[] args) {
        var vetor = new ManipulacaoDeVetoresInteger(TAMANHO_DO_VETOR);

        Integer somatorio = vetor.somatorioDeDiferencasSimetricas();

        System.out.println("Vetor: " + Arrays.toString(vetor.getVetor()) + "\n\nSomatório: " + FormatacaoDeSaida.formatacaoNumerica("pt-BR", 0, 0, somatorio)[0]);
    }
}
