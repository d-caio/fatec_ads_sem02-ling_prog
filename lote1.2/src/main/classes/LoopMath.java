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
}
