package lote2.manipulacao_vetores;

import java.lang.reflect.Array;

abstract class ManipulacaoDeVetoresNumericos<T extends Number> {
    private T[] vetor;
    private Class<T> classeDoVetor;

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

        if (classeDoVetor.equals(Byte.class))
            return classeDoVetor.cast((byte) somatorio);
        
        if (classeDoVetor.equals(Short.class))
            return classeDoVetor.cast((short) somatorio);
        
        if (classeDoVetor.equals(Integer.class))
            return classeDoVetor.cast((int) somatorio);

        if (classeDoVetor.equals(Long.class))
            return classeDoVetor.cast((long) somatorio);

        if (classeDoVetor.equals(Float.class))
            return classeDoVetor.cast((float) somatorio);
        
        return classeDoVetor.cast(somatorio);
    }
}
