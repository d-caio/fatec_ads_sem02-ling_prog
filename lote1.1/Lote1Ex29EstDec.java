/*
OBJETIVO: Receba o tipo de investimento (1 = poupança e 2 = renda fixa) e o valor do investimento. Calcule e mostre o valor corrigido em 30 dias sabendo que a poupança = 3% e a renda fixa = 5%. Demais tipos não serão considerados.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 02/03/2026
*/

import java.text.NumberFormat;
import java.util.*;

public class Lote1Ex29EstDec {
    static final double POUPANCA = 0.03;
    static final double RENDA_FIXA = 0.05;
    
    public static void main(String[] args) {
        String tipoInvest;
        double vlrInvest, vlrCorrigido;

        try (Scanner entrada = new Scanner(System.in)) {
            System.out.print("Tipo de investimento (1 = poupança e 2 = renda fixa): ");

            tipoInvest = entrada.nextLine();

            if (!List.of("1", "2").contains(tipoInvest)) throw new IllegalArgumentException("Os tipos de investimento só podem ser 1 (poupança) e 2 (renda fixa).");

            System.out.print("Valor do investimento: R$ ");

            String entradaVlrInvest = entrada.nextLine();

            if (!entradaVlrInvest.matches("^(\\d{1,3}(\\.\\d{3})*|\\d+)(\\,\\d{2})?$")) throw new IllegalArgumentException("O valor do investimento deve ser numérico, com os centavos separados por vírgula.");

            String entradaVlrInvestFormat = entradaVlrInvest.replace(".", "").replace(",", ".");

            vlrInvest = Double.parseDouble(entradaVlrInvestFormat);

            vlrCorrigido = (tipoInvest.equals("1")) ? (vlrInvest * (1 + POUPANCA)) : (vlrInvest * (1 + RENDA_FIXA));

            String vlrInvestMoeda = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR")).format(vlrInvest);

            String vlrCorrigidoMoeda = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR")).format(vlrCorrigido);

            System.out.println("Em 30 dias, o valor de " + vlrInvestMoeda + ", a uma taxa de " + (tipoInvest.equals("1") ? (int) (POUPANCA * 100) : (int) (RENDA_FIXA * 100)) + "% a.m., será corrigido para " + vlrCorrigidoMoeda + ".");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
