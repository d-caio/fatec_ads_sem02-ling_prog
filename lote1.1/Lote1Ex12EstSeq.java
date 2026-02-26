//Receba o ano de nascimento e o ano atual. Calcule e mostre a sua idade e quantos anos terá daqui a 17 anos.

import javax.swing.JOptionPane;
import java.time.LocalDate;

public class Lote1Ex12EstSeq {
    public static void main(String args[]) {
        int anoNasc, anoAtual, idade, idade17;

        try {
            anoNasc = Integer.parseInt(JOptionPane.showInputDialog("Ano de nascimento: "));
            anoAtual = LocalDate.now().getYear();

            idade = anoAtual - anoNasc;

            idade17 = idade + 17;

            JOptionPane.showMessageDialog(null, "A idade atual é " + idade + " e daqui 17 anos será " + idade17);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
