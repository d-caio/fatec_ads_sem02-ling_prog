/*
OBJETIVO: Criar e coletar um vetor [50] inteiro. Calcular e exibir:
        a. A média dos valores entre 10 e 200;
        b. A soma dos números ímpares.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 09/03/2026
*/

package lote2;

import java.util.function.Predicate;

import lote2.utils.*;

public class Lote2Ex01Vet {
    private static final int TAMANHO_DO_VETOR = 50;
    private static final int MIN_MEDIA = 10;
    private static final int MAX_MEDIA = 200;
    private static final int VLR_MIN_ITEM_VETOR = 0;
    private static final int VLR_MAX_ITEM_VETOR = 5000;

    public static void main(String[] args) {
        var vetor = new ManipulacaoDeVetoresInteger(TAMANHO_DO_VETOR, VLR_MIN_ITEM_VETOR, VLR_MAX_ITEM_VETOR);
        
        Predicate<Number> testeMedia = num -> num.doubleValue() >= MIN_MEDIA && num.doubleValue() <= MAX_MEDIA;
        
        double media = vetor.media(testeMedia);
        
        int soma = vetor.somaImpares();
        
        String msg = "Vetor: " + vetor.vetorString() + "%n%nMédia dos valores entre 10 e 200: %s%n%nSoma dos ímpares: %s";

        Saida.ImprimirNoTerminal(msg, media, (double) soma);
    }
}
