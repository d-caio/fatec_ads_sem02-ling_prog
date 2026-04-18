/*
OBJETIVO: Receba o número da base e do expoente. Calcule e mostre o valor da potência.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 07/03/2026
*/

import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JOptionPane;

public class Lote1Ex44EstRep {
    private static final int MAX_TRIES = 5;

    public static void main(String[] args) {
        double base, resultado = 1.0;
        int expoente, tries = 0;

        while (true) {
            if (tries == MAX_TRIES) {
                JOptionPane.showMessageDialog(null, "Máximo de tentativas atingido. O programa será encerrado.", "Erro " + tries + "/" + MAX_TRIES, JOptionPane.ERROR_MESSAGE);

                return;
            }

            try {
                String entrada = JOptionPane.showInputDialog("Valor da base: ");

                if (entrada == null) {
                    JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.", "Fim", JOptionPane.WARNING_MESSAGE);

                    return;
                }

                entrada = entrada.replace(",", ".");

                base = Double.parseDouble(entrada);

                entrada = JOptionPane.showInputDialog("Valor do expoente: ");

                if (entrada == null) {
                    JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.", "Fim", JOptionPane.WARNING_MESSAGE);

                    return;
                }

                expoente = Integer.parseInt(entrada);

                if (expoente == 0)
                    resultado = 1.0;

                else if (expoente > 0)
                    for (int i = 0; i < expoente; i++)
                        resultado *= base;
                
                else {
                    boolean isNegativo;

                    isNegativo = (base < 0.0) ? true : false;
                    
                    String baseString = String.valueOf(Math.abs(base));
                    String[] partesBase = baseString.split("\\.");

                    int dividendo, divisor;

                    String inteiroString = partesBase[0];
                    String fracionarioString = partesBase[1];

                    if (fracionarioString.equals("0")) {
                        dividendo = Integer.parseInt(inteiroString);
                        divisor = 1;
                    } else {
                        String dividendoString = (inteiroString + fracionarioString);
                        String divisorString = "1";

                        for (int i = 0; i < fracionarioString.length(); i++)
                            divisorString += "0";

                        dividendo = Integer.parseInt(dividendoString);
                        divisor = Integer.parseInt(divisorString);
                    }

                    int menor = Math.min(dividendo, divisor);

                    for (int i = menor; i >= 2; i--)
                        if (dividendo % i == 0 && divisor % i == 0) {
                            dividendo /= i;
                            divisor /= i;
                            break;
                        }
                    
                    int temp = dividendo;
                    dividendo = divisor;
                    divisor = temp;
                    
                    if (isNegativo)
                        dividendo = -dividendo;

                    int expoenteInvertido = -expoente;

                    int resultadoDividendo = 1; 
                    int resultadoDivisor = 1;

                    for (int i = 0; i < expoenteInvertido; i++) {
                        resultadoDividendo *= dividendo;
                        resultadoDivisor *= divisor;
                    }

                    resultado = (double) resultadoDividendo / resultadoDivisor;
                }

                NumberFormat formatador = NumberFormat.getInstance(Locale.forLanguageTag("pt"));
                formatador.setMinimumFractionDigits(0);

                JOptionPane.showMessageDialog(null, formatador.format(base) + "^" + expoente + " = " + formatador.format(resultado), "Resultado", JOptionPane.INFORMATION_MESSAGE);

                return;

            } catch (NumberFormatException e) {
                tries++;

                if (tries < MAX_TRIES)
                    JOptionPane.showMessageDialog(null, "A base precisa ser um inteiro ou decimal e o expoente precisa ser um inteiro.", "Erro " + tries + "/" + MAX_TRIES, JOptionPane.ERROR_MESSAGE);

            }
        }

    }
}
