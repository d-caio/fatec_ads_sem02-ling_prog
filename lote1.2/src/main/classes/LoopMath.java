package classes;

import java.util.ArrayList;

public class LoopMath {
    public ArrayList<Integer> aoQuadrado(int ini, int fim) {
        int num = ini;
        ArrayList<Integer> quadrados = new ArrayList<>();

        while (num <= fim) {
            int quadrado = num * num;

            quadrados.add(quadrado);

            num++;
        }

        return quadrados;
    }

    public int fatorial(int num) {
        if (num <= 1) return 1;
        
        return (num * fatorial(num - 1));
    }
}
