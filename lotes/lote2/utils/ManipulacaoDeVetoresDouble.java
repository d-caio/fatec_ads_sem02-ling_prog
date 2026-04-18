package lote2.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @deprecated devido à fraqueza dos tipos e falta de encapsulamento.
 * Nova classe a ser desenvolvida.
 */

@Deprecated
public class ManipulacaoDeVetoresDouble extends ManipulacaoDeVetores {
    public ManipulacaoDeVetoresDouble(int tamanhoDoVetor, double vlrMinItem, double vlrMaxItem) {
        super(tamanhoDoVetor);

        for (int i = 0; i < getVetor().length; i++) {
            Double item = ThreadLocalRandom.current().nextDouble(vlrMinItem, vlrMaxItem);

            adicionarItemAoVetor(i, item);
        }
    }
    
}
