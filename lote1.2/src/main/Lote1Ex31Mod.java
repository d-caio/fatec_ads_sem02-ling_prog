/*
OBJETIVO: Calcule e mostre o quadrado dos números entre 10 e 150.
PROGRAMADOR: Caio Dias (d-caio)
DATA DA CRIAÇÃO: 26/02/2026
*/

import java.util.ArrayList;
import classes.LoopMath;

public class Lote1Ex31Mod {
    final static int INI = 10;
    final static int FIM = 150;

    public static void main(String[] args) {
        ArrayList<Integer> quadrados = new LoopMath().aoQuadrado(INI, FIM);
        
        int num = INI;

        for (int i = 0; i < quadrados.size(); i++) {
            System.out.println(num + "^2 = " + quadrados.get(i));
            num++;
        }
    }
}