/*
OBJETIVO: Calcule a quantidade de litros gastos em uma viagem, sabendo que o automóvel faz 12 km/l. Receber o tempo de percurso e a velocidade média.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 05/03/2026
*/

import javax.swing.*;
import java.text.NumberFormat;
import java.util.Locale;

public class Lote1Ex17ModProc {
    private static final double KM_L = 12;

    private static final int MAX_TRIES = 5;
    
    private static double l, t, v;

    public static void main(String args[]) {
        int tries = 0;
        
        while (true) {
            if (tries == MAX_TRIES) {
                JOptionPane.showMessageDialog(null, "Máximo de tentativas atingido. O programa será encerrado.", "Tentativa " + tries + "/" + MAX_TRIES, JOptionPane.ERROR_MESSAGE);

                return;
            }

            try {
                String entrada = JOptionPane.showInputDialog("Tempo de percurso em horas: ");

                if (entrada == null) {
                    JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.", "Fim", JOptionPane.WARNING_MESSAGE);

                    return;
                }

                t = Double.parseDouble(entrada);

                if (t <= 0)
                    throw new IllegalArgumentException("O tempo de percurso precisa ser maior que 0 h.");
            
                entrada = JOptionPane.showInputDialog("Velocidade média em km/h: ");

                if (entrada == null) {
                    JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.", "Fim", JOptionPane.WARNING_MESSAGE);

                    return;
                }

                v = Double.parseDouble(entrada);

                if (v <= 0)
                    throw new IllegalArgumentException("A velocidade média precisa ser maior que 0 km/h.");

                calcularLitrosGastos();
            
                String lFormatado = NumberFormat.getInstance(Locale.forLanguageTag("pt")).format(l);

                JOptionPane.showMessageDialog(null, "Serão gastos " + lFormatado + "l de combustível na viagem.", "Resultado", JOptionPane.INFORMATION_MESSAGE);

                return;

            } catch (NumberFormatException e) {
                tries++;

                if (tries < MAX_TRIES)
                    JOptionPane.showMessageDialog(null, "Os valores precisam ser números reais.", "Tentativa " + tries + "/" + MAX_TRIES, JOptionPane.ERROR_MESSAGE);

            } catch (IllegalArgumentException e) {
                tries++;

                if (tries < MAX_TRIES)
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Tentativa " + tries + "/" + MAX_TRIES, JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    private static void calcularLitrosGastos() { l = ((v * t) / KM_L); }
}