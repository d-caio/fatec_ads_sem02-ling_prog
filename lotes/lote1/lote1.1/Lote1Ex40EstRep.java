/*
OBJETIVO: Receba 2 números inteiros. Verifique e mostre todos os números primos existentes entre eles.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 06/03/2026
*/

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Locale;

public class Lote1Ex40EstRep {
    public static void main(String[] args) {
        BigInteger maior, menor;
        NumberFormat formatador = NumberFormat.getInstance(Locale.of("pt", "BR"));
        boolean haPrimos = false;
        
        try {
            if (args.length != 2)
                throw new ArrayIndexOutOfBoundsException("Erro: O programa deve conter exatamente 2 argumentos.");

            BigInteger num1 = new BigInteger(args[0]);
            BigInteger num2 = new BigInteger(args[1]);

            if (num1.equals(num2))
                throw new IllegalArgumentException("Erro: os números precisam ser diferentes entre si.");

            maior = num1.max(num2);
            menor = num1.min(num2);

            String maiorFormatado = formatador.format(maior);
            String menorFormatado = formatador.format(menor);

            StringBuilder msgResultado = new StringBuilder("Os números primos entre ").append(menorFormatado).append(" e ").append(maiorFormatado).append(" são (provavelmente):\n");

            for (BigInteger i = menor; i.compareTo(maior) <= 0; i = i.add(BigInteger.ONE)) {
                if (i.compareTo(BigInteger.ONE) >= 0 && i.isProbablePrime(100)) {
                    haPrimos = true;
                    String iFormatado = formatador.format(i);
                    msgResultado.append(iFormatado).append("\n");
                }
            }

            if (haPrimos == false)
                msgResultado.append("Não há números primos entre ").append(menorFormatado).append(" e ").append(maiorFormatado).append(".");

            System.out.println(msgResultado);

        } catch (NumberFormatException e) {
            System.out.println("Erro: Os valores precisam ser números inteiros.");
            
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            
        }
    }
}
