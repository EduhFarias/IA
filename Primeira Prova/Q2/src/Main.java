import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int distance[][] = new int[14][14];
        Util.generateMatrix(distance);

        System.out.println("Estação de embarque: (Somente o numero)");
        int in = input.nextInt();
        System.out.println("Estação de desembarque: (Somente o numero)");
        int out = input.nextInt();


    }

}
