/*
OBJETIVO: Receba o número de voltas, a extensão do circuito (em metros) e o tempo de duração (minutos). Calcule e mostre a velocidade média em km/h.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 02/03/2026
*/

public class Lote1Ex27EstDec {
    public static void main(String[] args) {
        int n;
        double d, t, v;

        try {
            if (args.length != 3) throw new ArrayIndexOutOfBoundsException("O programa deve ser compilado com exatamente três argumentos, correspondentes, respectivamente, a: número de voltas, extensão do circuito e tempo de duração.");

            n = Integer.parseInt(args[0]);
            d = Double.parseDouble(args[1]);
            t = Double.parseDouble(args[2]);

            v = (n * d * 0.06) / t;

            System.out.println("Número de voltas: " + n + ";\nExtenção do circuito: " + d + "m;\nTempo: " + t + "min;\nVelocidade média: " + v + "km/h.");

        } catch (NumberFormatException e) {
            System.out.println("As variáveis devem ser numéricas, sendo o número de voltas um valor inteiro e as demais reais.");
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());

        }
    }
}
