/*
OBJETIVO: Criar e coletar em um vetor [20] com números aleatórios. Classificar este vetor em ordem crescente e mostre os dados. A partir disso solicitar um valor qualquer e verificar a sua existência no vetor (utilizar pesquisa binária).
PROGRAMADOR: Caio Dias (d-caio).
DATA: 12/03/2026
*/

package lote2;

import java.util.Arrays;
import javax.swing.JOptionPane;
import lote2.manipulacao_vetores.ManipulacaoDeVetoresInteger;

public class Lote2Ex06E07Vet {
    private static final int TAMANHO_DO_VETOR = 20;
    private static final int VLR_MIN_DOS_ITENS = -999;
    private static final int VLR_MAX_DOS_ITENS = 999;

    public static void main(String[] args) {
        try {
            var vetor = new ManipulacaoDeVetoresInteger(TAMANHO_DO_VETOR, VLR_MIN_DOS_ITENS, VLR_MAX_DOS_ITENS);

            Integer[] vetorOriginal = vetor.getVetor().clone();
            
            vetor.bubbleSort();

            Integer[] vetorOrdenado = vetor.getVetor();

            JOptionPane.showMessageDialog(null, Arrays.toString(vetorOriginal), "Vetor Original", JOptionPane.INFORMATION_MESSAGE);

            JOptionPane.showMessageDialog(null, Arrays.toString(vetorOrdenado), "Vetor Ordenado", JOptionPane.INFORMATION_MESSAGE);

            String inputAlvo = JOptionPane.showInputDialog("Alvo da busca binária: ");

            if (inputAlvo == null) {
                JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.", "Fim", JOptionPane.WARNING_MESSAGE);

                return;
            }

            Integer alvo = Integer.parseInt(inputAlvo);

            int resultadoDaBuscaBinaria = vetor.buscaBinaria(alvo);

            if (resultadoDaBuscaBinaria == -1)
                JOptionPane.showMessageDialog(null, alvo + " não está presente no vetor.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            
            else
                JOptionPane.showMessageDialog(null, alvo + " está presente no índice [" + resultadoDaBuscaBinaria + "].", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O valor do alvo precisa ser um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
            
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        }
    }
}
