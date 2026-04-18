package lote2.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @deprecated devido à fraqueza dos tipos e falta de encapsulamento.
 * Nova classe {@link lote2.manipulacao_vetores.ManipulacaoDeVetoresInteger}
 */

@Deprecated
public class ManipulacaoDeVetoresInteger extends ManipulacaoDeVetores{
    public ManipulacaoDeVetoresInteger(int tamanhoDoVetor, int vlrMinItem, int vlrMaxItem) {
        super(tamanhoDoVetor);

        for (int i = 0; i < getVetor().length; i++) {
            Integer item = ThreadLocalRandom.current().nextInt(vlrMinItem, vlrMaxItem);

            adicionarItemAoVetor(i, item);
        }
    }

    public int somaImpares() {
        int soma = 0;

        for (Number num:getVetor())
            if (num.intValue() % 2 != 0)
                soma += num.intValue();
        
        return soma;
    }
}
