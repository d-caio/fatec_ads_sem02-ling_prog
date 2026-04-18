/*
OBJETIVO: Calcule e mostre a série 1 – 2/4 + 3/9 – 4/16 + 5/25 + ... + 15/225
PROGRAMADOR: Caio Dias (d-caio).
DATA: 07/03/2026
*/

import java.text.NumberFormat;
import java.util.Locale;

public class Lote1Ex45EstRep {
    private static final int DIVIDENDO_MAX = 15;
    private static final int AUMENTO_SOMA_DIVIDENDO = 1;

    public static void main(String[] args) {
        int dividendo = 1, divisor = 1;
        double resultado = 0;
        boolean isSoma = true;

        NumberFormat formatador = NumberFormat.getInstance(Locale.forLanguageTag("pt"));
        formatador.setMaximumFractionDigits(20);
        
        StringBuilder msgResultado = new StringBuilder("");

        for (int i = 0; i < DIVIDENDO_MAX; i++) {
            if (!isSoma)
                resultado -= (double) dividendo / divisor;
            
            else
                resultado += (double) dividendo / divisor;

            isSoma = !isSoma;

            if (i == 0)
                msgResultado.append(dividendo).append((!isSoma) ? " - " : " + ");
            
            else if (i + 1 == DIVIDENDO_MAX)
                msgResultado.append(dividendo).append("/").append(divisor).append(" = ").append(formatador.format(resultado));
            
            else
                msgResultado.append(dividendo).append("/").append(divisor).append((!isSoma) ? " - " : " + ");

            dividendo += AUMENTO_SOMA_DIVIDENDO;
            divisor = dividendo * dividendo;

        }

        System.out.println(msgResultado);

    }
}
