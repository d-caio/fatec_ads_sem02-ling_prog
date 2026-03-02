/*
OBJETIVO: Receba um número inteiro. Calcule e mostre o seu fatorial.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 02/03/2026
*/

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Locale;

public class Lote1Ex32EstRep {
    public static void main(String[] args) {
        int num;
        BigInteger fatorial;

        try {
            if (args.length != 1) throw new ArrayIndexOutOfBoundsException("O programa precisa ser compilado com um único argumento.");

            num = Integer.parseInt(args[0]);

            fatorial = BigInteger.valueOf(num);
            
            for (int count = num - 1; count >= 1; count--) {
                fatorial = fatorial.multiply(BigInteger.valueOf(count));
            }

            System.out.println(NumberFormat.getNumberInstance(Locale.of("pt", "BR")).format(num) + "! = " + NumberFormat.getNumberInstance(Locale.of("pt", "BR")).format(fatorial));

        } catch (NumberFormatException e) {
            System.out.println("O valor precisa ser um dado do tipo integer.");
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());

        }
    }
}
