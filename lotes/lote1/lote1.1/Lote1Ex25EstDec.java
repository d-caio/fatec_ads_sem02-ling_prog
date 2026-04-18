/*
OBJETIVO: Receba a hora de início e de final de um jogo (HH,MM), calcular o tempo do jogo em horas e minutos, sabendo que o tempo máximo é menor que 24 horas e pode começar num dia e terminar noutro.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 02/03/2026
*/

import java.time.*;
import javax.swing.JOptionPane;

public class Lote1Ex25EstDec {
    public static void main(String[] args) {
        int hr, min;

        try {
            String entrHr = JOptionPane.showInputDialog("Hora de início do jogo: ");
            if (entrHr == null) {
                JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);

                return;
            }
            hr = Integer.parseInt(entrHr);
            if (hr < 0 || hr > 23) throw new IllegalArgumentException("A hora deve ser entre 00 e 23.");

            String entrMin = JOptionPane.showInputDialog("Minuto de início do jogo: ");
            if (entrMin == null) {
                JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);

                return;
            }
            min = Integer.parseInt(entrMin);
            if (min < 0 || min > 59) throw new IllegalArgumentException("O minuto deve ser entre 00 e 59.");

            LocalTime ini = LocalTime.of(hr, min);

            entrHr = JOptionPane.showInputDialog("Hora de final do jogo: ");
            if (entrHr == null) {
                JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);

                return;
            }
            hr = Integer.parseInt(entrHr);
            if (hr < 0 || hr > 23) throw new IllegalArgumentException("A hora deve ser entre 00 e 23.");

            entrMin = JOptionPane.showInputDialog("Minuto de final do jogo: ");
            if (entrMin == null) {
                JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);

                return;
            }
            min = Integer.parseInt(entrMin);
            if (min < 0 || min > 59) throw new IllegalArgumentException("O minuto deve ser entre 00 e 59.");

            LocalTime fim = LocalTime.of(hr, min);

            Duration duracao = Duration.between(ini, fim);

            if (duracao.isNegative()) duracao = duracao.plusDays(1);
            
            else if (duracao.isZero()) throw new IllegalArgumentException("Os horários de início e final não podem ser iguais.");

            hr = (int) duracao.toHours();
            min = (int) duracao.toMinutesPart();

            JOptionPane.showMessageDialog(null, "O jogo durou " + hr + "h" + min + "m.", "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "As horas e minutos devem ser números inteiros.", "Erro", JOptionPane.ERROR_MESSAGE);

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        }
    }
}
