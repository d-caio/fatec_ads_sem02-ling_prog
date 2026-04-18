/*
OBJETIVO: Receba o preço atual e a média mensal de um produto. Calcule e mostre o novo preço sabendo que:
Venda Mensal	Preço Atual	Preço Novo
< 500	< 30	+ 10%
>= 500 e < 1000	>= 30 e < 80	+15%
>= 1000	>= 80	- 5%
Obs.: para outras condições, preço novo será igual ao preço atual.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 02/03/2026
*/

import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;

public class Lote1Ex28EstDec {
    public static void main(String[] args) {
        double mediaMensal, precoAtual, precoNovo;

        try {
            String entrada = JOptionPane.showInputDialog("Preço atual do produto: R$ ");
            
            if (entrada == null) {
                JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.", "Encerrado", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            if (!entrada.matches("^(\\d{1,3}(\\.\\d{3})*|\\d+)(\\,\\d{2})?$")) throw new IllegalArgumentException("O preço precisa ser numérico, com centavos, se houver, separados por vírgula.");

            entrada = entrada.replace(".", "").replace(",", ".");

            precoAtual = Double.parseDouble(entrada);

            if (precoAtual <= 0) throw new IllegalArgumentException("O preço precisa ser um valor positivo.");

            entrada = JOptionPane.showInputDialog("Média mensal de vendas do produto: ");

            if (entrada == null) {
                JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.", "Encerrado", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            if (!entrada.matches("^(\\d{1,3}(\\.\\d{3})*|\\d+)(\\,\\d+)?$")) throw new IllegalArgumentException("A média mensal precisa ser numérica, com casas decimais, se houver, separadas por vírgula.");

            entrada = entrada.replace(".", "").replace(",", ".");

            mediaMensal = Double.parseDouble(entrada);

            if (mediaMensal < 0) throw new IllegalArgumentException("A média precisa ser um valor positivo ou zero.");

            if (precoAtual < 500 && mediaMensal < 30) precoNovo = (precoAtual * 1.1);

            else if ((precoAtual >= 500 && precoAtual < 1000) && (mediaMensal >= 30 && mediaMensal < 80)) precoNovo = (precoAtual * 1.15);

            else if (precoAtual >= 1000 && mediaMensal >= 80) precoNovo = (precoAtual - (precoAtual * 0.05));

            else precoNovo = precoAtual;

            String precoAtualMoeda = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR")).format(precoAtual);

            String precoNovoMoeda = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR")).format(precoNovo);

            JOptionPane.showMessageDialog(null, "O preço anterior era de " + precoAtualMoeda + (precoAtual == precoNovo ? " e continua igual." : " e passou para " + precoNovoMoeda + "."), "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Os valores precisam ser numéricos.", "Erro", JOptionPane.ERROR_MESSAGE);
            
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        }
    }
}
