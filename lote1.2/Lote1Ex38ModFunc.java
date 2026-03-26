/*
OBJETIVO: Receba 100 números inteiros reais. Verifique e mostre o maior e o menor valor. Obs.: somente valores positivos.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 21/03/2026
*/

import java.util.*;

public class Lote1Ex38ModFunc {
    public static void main(String[] args) {
        int[] vetor = geradorDeNums(100, new int[100]);

        int[] maiorEMenor = maiorMenor(vetor.length, new int[2], vetor);

        System.out.println("Números recebidos: " + Arrays.toString(vetor));
        System.out.println("\nMaior: " + maiorEMenor[0]);
        System.out.println("\nMenor: " + maiorEMenor[1]);
    }
    
    private static int[] maiorMenor(int i, int[] nums, int[] vetor) {
        if (nums.length != 2)
            throw new IllegalArgumentException("Só pode haver um maior e um menor.");
        
        if (i < 1 || i > vetor.length)
            throw new IllegalArgumentException("É preciso ter ao menos uma iteração.");

        if (vetor[i - 1] > nums[0])
            nums[0] = vetor[i - 1];

        if (vetor[i - 1] < nums[1] || nums[1] == 0.0)
            nums[1] = vetor[i - 1];

        if (i == 1)
            return nums;

        return maiorMenor(i - 1, nums, vetor);
    }

    private static int[] geradorDeNums(int total, int[] nums) {
        if (total < 1)
            throw new IllegalArgumentException("É preciso gerar ao menos um número.");
        
        if ((total > nums.length) || (total < nums.length && nums[total] == 0))
            throw new IllegalArgumentException("O total de números deve ser igual ao tamnho do vetor.");

        var gerador = new Random();

        int num = gerador.nextInt(100) + 1;

        nums[total - 1] = num;

        if (total == 1)
            return nums;

        return geradorDeNums(total - 1, nums);
    }
}
