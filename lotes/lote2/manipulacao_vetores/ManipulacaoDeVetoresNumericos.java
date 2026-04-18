package lote2.manipulacao_vetores;

import java.lang.reflect.Array;

abstract class ManipulacaoDeVetoresNumericos<T extends Number> implements ManipulacaoDeVetoresGerais<T> {
    private T[] vetor;
    private Class<T> classeDoVetor;
    private boolean isVetorOrdenado = false;

    @SuppressWarnings("unchecked")
    ManipulacaoDeVetoresNumericos(Class<T> classeDoVetor, int tamanhoDoVetor) {
        this.classeDoVetor = classeDoVetor;
        vetor = (T[]) Array.newInstance(classeDoVetor, tamanhoDoVetor);
    }

    protected void adicionarItemAoVetor(T item, int index) {
        vetor[index] = item;
    }

    public T[] getVetor() {
        return vetor;
    }

    public void bubbleSort() {
        T temp;

        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor.length; j++) {
                if (((j + 1) < vetor.length) && (vetor[j].doubleValue() > vetor[j + 1].doubleValue())) {
                    temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }

        isVetorOrdenado = true;
    }

    public T somatorioDeDiferencasSimetricas() {
        int limiteSuperior = vetor.length / 2;
        int limiteInferior = 0;
        int subscrito = vetor.length - 1;
        double somatorio = 0.0;

        while (limiteInferior < limiteSuperior) {
            somatorio += (vetor[limiteInferior].doubleValue() - vetor[subscrito].doubleValue());

            limiteInferior++;
            subscrito--;
        }

        if (classeDoVetor.equals(Integer.class))
            return classeDoVetor.cast((int) somatorio);

        return classeDoVetor.cast(somatorio);
    }

    @Override
    public int buscaBinaria(T alvo) {
        if (isVetorOrdenado) {

            int inicio = 0, fim = vetor.length - 1, meio;

            while (inicio <= fim) {
                meio = (inicio + ((fim - inicio) / 2));

                if (vetor[meio].doubleValue() == alvo.doubleValue())
                    return meio;

                if (vetor[meio].doubleValue() < alvo.doubleValue())
                    inicio = meio + 1;

                else
                    fim = meio - 1;
            }
        
            return -1;
        }

        throw new IllegalArgumentException("Erro: o vetor não está ordenado.");
    }
}
