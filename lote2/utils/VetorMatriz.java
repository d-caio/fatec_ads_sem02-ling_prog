package lote2.utils;

import java.util.Random;

public class VetorMatriz {
    public static int[] coletarVetor(int tamanho, int vlrMaxItem) {
        Random item = new Random();

        int[] vetor = new int[tamanho];

        for (int i = 0; i < tamanho; i++)
            vetor[i] = item.nextInt(vlrMaxItem);

        return vetor;
    }
    
}
