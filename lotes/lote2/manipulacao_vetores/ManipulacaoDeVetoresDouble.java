package lote2.manipulacao_vetores;

import java.util.concurrent.ThreadLocalRandom;

public class ManipulacaoDeVetoresDouble extends ManipulacaoDeVetoresNumericos<Double> {
    public ManipulacaoDeVetoresDouble(int tamanhoDoVetor, double vlrMinDosItens, double vlrMaxDosItens) {
        super(Double.class, tamanhoDoVetor);

        for (int i = 0; i < tamanhoDoVetor; i++) {

            Double item = ThreadLocalRandom.current().nextDouble(vlrMinDosItens, (vlrMaxDosItens + 1));

            adicionarItemAoVetor(item, i);
        }
    }
}
