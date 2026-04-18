/*
OBJETIVO: Receba um valor inteiro. Verifique e mostre se é divisível por 2 e 3.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 01/03/2026
*/

public class Lote1Ex24EstDec {
    public static void main(String[] args) {
        int num;

        try {
            if (args.length != 1) throw new ArrayIndexOutOfBoundsException("É necessário fornecer um (e apenas um) número inteiro como argumento do programa.");

            num = Integer.parseInt(args[0]);

            if (num % 2 == 0 && num % 3 == 0) System.out.println(num + " é divisível tanto por 2 quanto por 3.");

            else if (num % 2 == 0 && num % 3 != 0) System.out.println(num + " é divisível por 2 mas não por 3.");

            else if (num % 2 != 0 && num % 3 == 0) System.out.println(num + " não é divisível por 2 mas é por 3.");

            else System.out.println(num + " não é divisível por 2 nem por 3.");

        } catch (NumberFormatException e) {
            System.out.println("O valor fornecido precisa ser um número inteiro.");
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());

        }
    }
}
