package lote2.manipulacao_vetores;

import java.util.Random;

public class ManipulacaoDeVetoresInteger extends ManipulacaoDeVetoresNumericos<Integer> {
    public ManipulacaoDeVetoresInteger(int tamanhoDoVetor) {
        super(Integer.class, tamanhoDoVetor);

        int valorMinDoItem = -(Integer.MAX_VALUE / getVetor().length);
        int valorMaxDoItem = Integer.MAX_VALUE / getVetor().length;

        int limiteSeguro = valorMaxDoItem;

        boolean isMultiplicacao = false;

        Random gerador = new Random();
        
        for (int i = 0; i < tamanhoDoVetor; i++) {

            Integer item = (gerador.nextInt(valorMaxDoItem * 2) + valorMinDoItem);

            adicionarItemAoVetor(item, i);

            if (((valorMaxDoItem / 2) <= 10) || ((valorMinDoItem / 2) >= 10))
                isMultiplicacao = true;

            if (((valorMaxDoItem * 2) >= limiteSeguro) || ((valorMinDoItem * 2) <= -limiteSeguro))
                isMultiplicacao = false;

            if (!isMultiplicacao) {
                valorMinDoItem /= 2;
                valorMaxDoItem /= 2;
            } else {
                valorMinDoItem *= 2;
                valorMaxDoItem *= 2;
            }
        }
    }
}
