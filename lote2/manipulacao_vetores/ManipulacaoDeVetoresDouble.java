package lote2.manipulacao_vetores;

import java.util.Random;

public class ManipulacaoDeVetoresDouble extends ManipulacaoDeVetoresNumericos<Double> {
    public ManipulacaoDeVetoresDouble(int tamanhoDoVetor, double vlrMinDosItens, double vlrMaxDosItens) {
        super(Double.class, tamanhoDoVetor);

        Random gerador = new Random();
        
        for (int i = 0; i < tamanhoDoVetor; i++) {

            Double item = (gerador.nextDouble(vlrMaxDosItens * 2) + vlrMinDosItens);

            adicionarItemAoVetor(item, i);
        }
    }
}
