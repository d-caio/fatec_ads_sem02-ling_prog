//Receba o valor de um depósito em poupança. Calcule e mostre o valor após 1 mês de aplicação sabendo que rende 1,3% a. m.

import javax.swing.JOptionPane;

public class Lote1Ex08EstSeq {
    public static void main(String args[]) {
        double deposito, rendimento;

        deposito = Double.parseDouble(JOptionPane.showInputDialog("Valor do depósito: R$ "));

        rendimento = deposito + (deposito * 0.013);

        JOptionPane.showMessageDialog(null, "Valor depois de um mês: R$ " + rendimento);
    }
}
