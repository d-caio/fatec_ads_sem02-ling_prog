/*
OBJETIVO: Receba a data de nascimento e atual em ano, mês e dia. Calcule e mostre a idade em anos, meses e dias, considerando os anos bissextos.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 07/03/2026
*/

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

public class Lote1Ex30Especial {
    public static void main(String[] args) {
        int difAnos, difMeses, difDias;
        LocalDate dataNasc, dataAtual = LocalDate.now();
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataAtualFormatada = dataAtual.format(formatadorData);

        try {
            String entrada = JOptionPane.showInputDialog("Data de nascimento no formato dd/mm/aaaa: ");

            if (entrada == null) {
                JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.", "Fim", JOptionPane.WARNING_MESSAGE);

                return;
            }
            
            if (!entrada.matches("\\d{2}/\\d{2}/\\d{4}"))
                throw new IllegalArgumentException("A data de nascimento precisa ter o formato dd/mm/aaaa.");

            dataNasc = LocalDate.parse(entrada, formatadorData);

            if (dataNasc.isAfter(dataAtual))
                throw new IllegalArgumentException("A data de nascimento precisa ser menor que a data atual, que é " + dataAtualFormatada + ".");

            String dataNascFormatada = dataNasc.format(formatadorData);

            Period difDatas = Period.between(dataNasc, dataAtual);

            difAnos = difDatas.getYears();
            difMeses = difDatas.getMonths();
            difDias = difDatas.getDays();

            JOptionPane.showMessageDialog(null, "A diferença entre a data de nascimento " + dataNascFormatada + " e a data atual " + dataAtualFormatada + " é de " + difAnos + ((difAnos <= 1) ? " ano, " : " anos, ") + difMeses + ((difMeses <= 1) ? " mês e " : " meses e ") + difDias + ((difDias <= 1) ? " dia." : " dias."));

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "A data precisa ser fornecida no formato dd/mm/aaaa", "Erro", JOptionPane.ERROR_MESSAGE);

        }
    }
}
