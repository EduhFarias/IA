import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int distance[][] = new int[14][14];
        Util.generateMatrix(distance);



        System.out.println("Estação de embarque: (Somente o numero)");
        int in = input.nextInt() - 1;
        System.out.println("Estação de desembarque: (Somente o numero)");
        int out = input.nextInt() - 1;


    }

    public static int evaluation( ){
        int result = 1;

        return result;
    }

    public static void generateNode(){
        Node newNode1 = new Node(0, "blue", null, null, 0, 0);
        Node newNode2 = new Node(1, "x", null, null, 0, 0); //Colocar x ou as duas possiveis
        Node newNode3 = new Node(2, "x", null, null, 0, 0);
        Node newNode4 = new Node(3, "x", null, null, 0, 0);
        Node newNode5 = new Node(4, "x", null, null, 0, 0);
        Node newNode6 = new Node(5, "blue", null, null, 0, 0);
        Node newNode7 = new Node(6, "yellow", null, null, 0, 0);
        Node newNode8 = new Node(7, "blue", null, null, 0, 0);
        Node newNode9 = new Node(8, "blue", null, null, 0, 0);
        Node newNode10 = new Node(9, "yellow", null, null, 0, 0);
        Node newNode11 = new Node(10, "red", null, null, 0, 0);
        Node newNode12 = new Node(11, "green", null, null, 0, 0);
        Node newNode13 = new Node(12, "blue", null, null, 0, 0);
        Node newNode14 = new Node(13, "green", null, null, 0, 0);

        newNode1.getChildren().add(newNode2);

        newNode2.getChildren().add(newNode1); newNode2.getChildren().add(newNode3); newNode2.getChildren().add(newNode9);
        newNode2.getChildren().add(newNode10);

        newNode3.getChildren().add(newNode2); newNode3.getChildren().add(newNode4); newNode3.getChildren().add(newNode9);
        newNode3.getChildren().add(newNode14);

        newNode4.getChildren().add(newNode3); newNode3.getChildren().add(newNode2);
    }


}
