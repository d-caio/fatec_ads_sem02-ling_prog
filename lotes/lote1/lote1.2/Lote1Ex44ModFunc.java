/*
OBJETIVO: Receba o número da base e do expoente. Calcule e mostre o valor da potência.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 26/03/2026
*/

import javax.swing.JOptionPane;

import entrada_saida.EntradaSaida;

public class Lote1Ex44ModFunc {
    public static void main(String[] args) {
        try {
            int base = EntradaSaida.entradaInteger("Valor da base: ");
            int expoente = EntradaSaida.entradaInteger("Valor do expoente: ");

            int resultado = potencia(base, expoente);

            String msg = base + "^" + expoente + " = " + resultado;

            JOptionPane.showMessageDialog(null, msg, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException e) {
            EntradaSaida.excecao("Base e expoente devem ser números inteiros.", "erro");
            
        } catch (IllegalArgumentException e) {
            EntradaSaida.excecao(e.getMessage(), "erro");
            
        } catch (NullPointerException e) {
            EntradaSaida.excecao(e.getMessage(), "warning");

        }
    }

    private static int potencia(int base, int expoente) {
        if (expoente < 0)
            throw new IllegalArgumentException("O expoente precisa ser zero ou maior.");
        
        if (expoente == 0)
            return 1;

        return base * potencia(base, expoente - 1);
    }
}
