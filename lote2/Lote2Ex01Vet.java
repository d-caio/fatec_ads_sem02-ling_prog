/*
OBJETIVO: Criar e coletar um vetor [50] inteiro. Calcular e exibir:
        a. A média dos valores entre 10 e 200;
        b. A soma dos números ímpares.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 07/03/2026
*/

package lote2;

import java.text.NumberFormat;
import java.util.*;
import lote2.utils.*;

public class Lote2Ex01Vet {
    private static final int TAMANHO_VETOR = 50;
    private static final int VLR_MAX_VETOR = 1000;

    public static int[] vetor = new int[TAMANHO_VETOR];
    public static List<Integer> vetorFiltradoMedia = new ArrayList<>();
    public static List<Integer> vetorFiltradoImpares = new ArrayList<>();
    public static double media;
    public static int soma;
    public static String msgResultado = "Dado o vetor %s%nA média dos valores entre 10 e 200 é %s e a soma dos ímpares é %s.%n";

    public static void main(String[] args) {
        NumberFormat formatador = NumberFormat.getInstance(Locale.forLanguageTag("pt"));

        vetor = VetorMatriz.coletarVetor(vetor.length, VLR_MAX_VETOR);

        filtrarVetorMedia();

        media = Calculos.media(vetorFiltradoMedia);

        filtrarVetorImpares();

        soma = Calculos.somaLista(vetorFiltradoImpares);

        String vetorString = Arrays.toString(vetor);
        String mediaFormatada = formatador.format(media);
        String somaFormatada = formatador.format(soma);

        String msgResultadoFormatada = String.format(msgResultado, vetorString, mediaFormatada, somaFormatada);

        System.out.println(msgResultadoFormatada);

    }

    private static void filtrarVetorMedia() {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] >= 10 && vetor[i] <= 200)
                vetorFiltradoMedia.add(vetor[i]);
        }
    }

    private static void filtrarVetorImpares() {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 != 0)
                vetorFiltradoImpares.add(vetor[i]);
        }
    }
}
