//Receba o salário de um funcionário e mostre o novo salário com reajuste de 15%.

import javax.swing.JOptionPane;

public class Lote1Ex02EstSeq {
    public static void main(String args[]) {
        Double salario, reajustado;

        salario = Double.parseDouble(JOptionPane.showInputDialog("Salário atual: R$ "));

        reajustado = (salario + (salario * 0.15));

        JOptionPane.showMessageDialog(null, "O salário reajustado é R$ " + reajustado + ".");
    }
}