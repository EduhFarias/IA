import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int distance[][] = new int[14][14];
        Util.generateMatrix(distance);
        ArrayList<Node> nodes = new ArrayList<>();
        Util.generateNode(nodes);

        System.out.println("Estação de embarque: (Somente o numero)");
        int in = input.nextInt() - 1;
        System.out.println("Estação de desembarque: (Somente o numero)");
        int out = input.nextInt() - 1;

    }

    public static int evaluation( ){
        int result = 1;

        return result;
    }
}
