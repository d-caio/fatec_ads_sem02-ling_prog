/*
OBJETIVO: Receba 2 valores inteiros e diferentes. Mostre seus valores em ordem crescente.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 01/03/2026
*/

import javax.swing.JOptionPane;

public class Lote1Ex22EstDec {
    public static void main(String[] args) {
        int num1, num2;

        try {
            // Entrada do primeiro número
            String entrada1 = JOptionPane.showInputDialog("Digite o primeiro número inteiro:");
            
            // Verificar se o usuário cancelou na primeira entrada
            if (entrada1 == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            // Converter primeiro número imediatamente
            num1 = Integer.parseInt(entrada1);
            
            // Entrada do segundo número
            String entrada2 = JOptionPane.showInputDialog("Digite o segundo número inteiro (diferente do primeiro):");
            
            // Verificar se o usuário cancelou na segunda entrada
            if (entrada2 == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            // Converter segundo número imediatamente
            num2 = Integer.parseInt(entrada2);

            // Verificar se os números são diferentes
            if (num1 == num2) {
                JOptionPane.showMessageDialog(null, "Os números devem ser diferentes. Por favor, execute o programa novamente.");
                return;
            }

            // Ordenar e exibir os números em ordem crescente
            if (num1 < num2) {
                JOptionPane.showMessageDialog(null, "Números em ordem crescente: " + num1 + ", " + num2, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Números em ordem crescente: " + num2 + ", " + num1, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: Digite apenas números inteiros válidos!", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
}
