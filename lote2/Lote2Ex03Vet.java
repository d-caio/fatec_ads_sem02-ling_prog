/*
OBJETIVO: Criar e coletar valores inteiros nos vetores VT1[3] e VT2[3]. Concatenar esses valores em um 3º vetor (VT3[6]) e mostrar os seus dados. P. ex:
VT1|	1|	2|	3|	|VT2|	4|	5|	6|	|VT3|	1|	2|	3|	4|	5|	6
PROGRAMADOR: Caio Dias (d-caio).
DATA: 09/03/2026
*/

package lote2;

import lote2.utils.ManipulacaoDeVetoresInteger;
import lote2.utils.Saida;

public class Lote2Ex03Vet {
    private static final int TAMANHO_DOS_VETORES_INICIAIS = 3;

    public static void main(String[] args) {
        var vetor1 = new ManipulacaoDeVetoresInteger(TAMANHO_DOS_VETORES_INICIAIS, 0, 10000);

        var vetor2 = new ManipulacaoDeVetoresInteger(TAMANHO_DOS_VETORES_INICIAIS, 0, 10000);

        Number[] vetor3 = vetor1.concatenarVetores(vetor2.getVetor());

        String msg = "Vetor 1: " + vetor1.vetorString() + "%n%nVetor 2: " + vetor2.vetorString() + "%n%nVetor 3: " + Saida.vetorNumberFormatadoParaString(vetor3);

        Saida.ImprimirNoTerminal(msg);
    }
    
}
