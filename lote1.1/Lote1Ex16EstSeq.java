//Receba a quantidade de horas trabalhadas, o valor por hora, o percentual de desconto e o número de dependentes. Calcule o salário que serão as horas trabalhadas x o valor por hora. Calcule o salário líquido (= Salário Bruto – desconto). A cada dependente será acrescido R$ 100 no Salário Líquido. Exiba o salário a receber.

import javax.swing.JOptionPane;

public class Lote1Ex16EstSeq {
    public static void main(String args[]) {
        double hrsTrab, vlrHr, percentDesc, salBruto, salLiq;
        int numDeps;

        try {
            hrsTrab = Double.parseDouble(JOptionPane.showInputDialog("Horas trabalhadas: "));
            vlrHr = Double.parseDouble(JOptionPane.showInputDialog("Valor por hora: R$ "));
            percentDesc = Double.parseDouble(JOptionPane.showInputDialog("Percentual de desconto: "));
            numDeps = Integer.parseInt(JOptionPane.showInputDialog("Número de dependentes: "));

            if (hrsTrab < 0 || vlrHr < 0 || percentDesc < 0 || numDeps < 0) {
                throw new IllegalArgumentException("Todos os valores devem ser maiores ou iguais a zero.");
            }

            double desc = percentDesc / 100;

            salBruto = (hrsTrab * vlrHr);
            salLiq = ((salBruto - (salBruto * desc)) + (100 * numDeps));

            JOptionPane.showMessageDialog(null, "O salário líquido é R$ " + salLiq);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }   
}
