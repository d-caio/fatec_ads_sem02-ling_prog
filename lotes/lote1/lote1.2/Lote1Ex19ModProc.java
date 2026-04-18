/*
OBJETIVO: Receba 2 valores reais. Calcule e mostre o maior deles.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 07/03/2026
*/

public class Lote1Ex19ModProc {
    private static double num1, num2, maior, menor;

    public static void main(String[] args) {
        try {
            if (args.length != 2)
                throw new ArrayIndexOutOfBoundsException("Erro: O programa precisa ser executado com exatamente dois argumentos.");

            num1 = Double.parseDouble(args[0]);
            num2 = Double.parseDouble(args[1]);

            determinarMaiorMenor();

            System.out.println(maior + " > " + menor);
            
        } catch (NumberFormatException e) {
            System.out.println("Erro: Os valores precisam ser números.");
            
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }
    }

    private static void determinarMaiorMenor() {
        if (num1 == num2)
            throw new IllegalArgumentException("Erro: Os números precisam ser diferentes.");

        maior = Math.max(num1, num2);
        menor = Math.min(num1, num2);
    }
}
