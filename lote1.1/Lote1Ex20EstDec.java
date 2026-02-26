//Receba 3 coeficientes A, B e C de uma equação do 2º grau da fórmula AX²+BX+C=0. Verifique e mostre a existência de raízes reais e se caso exista, calcule e mostre.

public class Lote1Ex20EstDec {
    public static void main(String args[]) {
        double a, b, c, Δ, r1, r2;
        //Sei que não é recomendado usar letras gregas na declaração de variáveis, mas quis fazer uma graça aqui kkkkkk

        try {
            a = Double.parseDouble(args[0]);
            if (a == 0) throw new IllegalArgumentException("O valor de a não pode ser zero.");

            b = Double.parseDouble(args[1]);
            c = Double.parseDouble(args[2]);

            Δ = ((b * b ) - 4 * a * c);

            if (Δ > 0) {
                r1 = ((-b + Math.sqrt(Δ)) / (2 * a));
                r2 = ((-b - Math.sqrt(Δ)) / (2 * a));

                System.out.println("A equação " + a + "x²" + " + " + b + "x" + " + " + c + " = 0 tem duas raízes reais: " + r1 + " e " + r2);

            } else if (Δ == 0) {
                r1 = ((-b + Math.sqrt(Δ)) / (2 * a)); 

                System.out.println("A equação " + a + "x²" + " + " + b + "x" + " + " + c + " = 0 tem uma raíz real: " + r1);

            } else System.out.println("A equação " + a + "x²" + " + " + b + "x" + " + " + c + " = 0 não possui raízes reais.");

        } catch (NumberFormatException e) {
            System.out.println("Os valores dos coeficientes precisam ser numéricos, sendo a != 0.");
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("É necessário declarar três coeficientes numéricos, sendo a != 0.");
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }
    }
}
