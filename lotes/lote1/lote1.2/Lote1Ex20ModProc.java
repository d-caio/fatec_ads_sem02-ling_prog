/*
OBJETIVO: Receba 3 coeficientes A, B e C de uma equação do 2º grau da fórmula AX²+BX+C=0. Verifique e mostre a existência de raízes reais e se caso exista, calcule e mostre.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 07/03/2026
*/

import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JOptionPane;

public class Lote1Ex20ModProc {
    private static double a, b, c, d, r1, r2;
    private static String msgResultado;
    private static NumberFormat formatador = NumberFormat.getInstance(Locale.forLanguageTag("pt"));

    public static void main(String[] args) {
        try {
            String entrada = JOptionPane.showInputDialog("Valor do coeficiente A: ");

            if (entrada == null) {
                JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.", "Fim",
                        JOptionPane.WARNING_MESSAGE);

                return;
            }

            a = Double.parseDouble(entrada);

            if (a == 0)
                throw new IllegalArgumentException("O valor do coeficiente A não pode ser zero.");

            entrada = JOptionPane.showInputDialog("Valor do coeficiente B: ");

            if (entrada == null) {
                JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.", "Fim",
                        JOptionPane.WARNING_MESSAGE);

                return;
            }

            b = Double.parseDouble(entrada);

            entrada = JOptionPane.showInputDialog("Valor do coeficiente C: ");

            if (entrada == null) {
                JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.", "Fim",
                        JOptionPane.WARNING_MESSAGE);

                return;
            }

            c = Double.parseDouble(entrada);

            equacao2Grau();

            JOptionPane.showMessageDialog(null, msgResultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Os coeficientes precisam ser números.", "Erro",
                    JOptionPane.ERROR_MESSAGE);

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        }

    }

    private static void equacao2Grau() {
        formatador.setMinimumFractionDigits(0);
        
        String aFormatado = formatador.format(a);
        String bFormatado = formatador.format(b);
        String cFormatado = formatador.format(c);
        String r1Formatado;
        String r2Formatado;

        d = (b * b) - 4 * a * c;

        if (d > 0) {
            r1 = (((-b) + Math.sqrt(d)) / (2 * a));
            r1Formatado = formatador.format(r1);
            
            r2 = (((-b) - Math.sqrt(d)) / (2 * a));
            r2Formatado = formatador.format(r2);

            msgResultado = "A equação " + ((a == 1) ? "x²" : aFormatado + "x²") + ((b < 0) ? " " : " +") + bFormatado + "x" + ((c < 0) ? " " : " +") + cFormatado + " = 0 tem duas raízes reais: " + r1Formatado + " e " + r2Formatado + ".";

        } else if (d == 0) {
            r1 = (((-b) + Math.sqrt(d)) / (2 * a));
            r1Formatado = formatador.format(r1);

            msgResultado = "A equação " + ((a == 1) ? "x²" : aFormatado + "x²") + ((b < 0) ? " " : " +") + bFormatado + "x" + ((c < 0) ? " " : " +") + cFormatado + " = 0 tem uma raíz real: " + r1Formatado + ".";

        } else
            msgResultado = "A equação " + ((a == 1) ? "x²" : aFormatado + "x²") + ((b < 0) ? " " : " +") + bFormatado + "x" + ((c < 0) ? " " : " +") + cFormatado + " = 0 não tem raízes reais.";

    }
}
