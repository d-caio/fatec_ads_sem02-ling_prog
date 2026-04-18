package lote2.manipulacao_matrizes;

import java.lang.reflect.Array;

abstract class ManipulacaoDeMatrizesNumericas<T extends Number> {
    private T[][] matriz;

    @SuppressWarnings("unchecked")
    ManipulacaoDeMatrizesNumericas(Class<T> classeDaMatriz, int numDeLinhas, int numDeColunas) {
        matriz = (T[][]) Array.newInstance(classeDaMatriz, numDeLinhas, numDeColunas);
    }

    protected void adicionarItem(int linha, int coluna, T item) {
        matriz[linha][coluna] = item;
    }
    
    public T[][] getMatriz() {
        return matriz;
    }

    public abstract T[] SomaVetorialDaMatriz(int indiceDeReferencia, int indiceIterador, boolean isLinha);

    public abstract T somaDaMatriz();
}
