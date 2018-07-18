import java.util.*;

public class Util {

    public static void generateMatrix(int distance[][]){
        for(int i = 0; i < 14; i++){
            distance[i][i] = 0;
        }

        distance[0][1] = distance[1][0] = 11;
        distance[0][2] = distance[2][0] = 20;
        distance[0][3] = distance[3][0] = 27;
        distance[0][4] = distance[4][0] = 40;
        distance[0][5] = distance[5][0] = 43;
        distance[0][6] = distance[6][0] = 39;
        distance[0][7] = distance[7][0] = 28;
        distance[0][8] = distance[8][0] = 18;
        distance[0][9] = distance[9][0] = 10;
        distance[0][10] = distance[10][0] = 18;
        distance[0][11] = distance[11][0] = 30;
        distance[0][12] = distance[12][0] = 30;
        distance[0][13] = distance[13][0] = 32;

        distance[1][2] = distance[2][1] = 9;
        distance[1][3] = distance[3][1] = 16;
        distance[1][4] = distance[4][1] = 29;
        distance[1][5] = distance[5][1] = 32;
        distance[1][6] = distance[6][1] = 28;
        distance[1][7] = distance[7][1] = 19;
        distance[1][8] = distance[8][1] = 11;
        distance[1][9] = distance[9][1] = 4;
        distance[1][10] = distance[10][1] = 17;
        distance[1][11] = distance[11][1] = 23;
        distance[1][12] = distance[12][1] = 21;
        distance[1][13] = distance[13][1] = 24;

        distance[2][3] = distance[3][2] = 7;
        distance[2][4] = distance[4][2] = 20;
        distance[2][5] = distance[5][2] = 22;
        distance[2][6] = distance[6][2] = 19;
        distance[2][7] = distance[7][2] = 15;
        distance[2][8] = distance[8][2] = 10;
        distance[2][9] = distance[9][2] = 11;
        distance[2][10] = distance[10][2] = 21;
        distance[2][11] = distance[11][2] = 21;
        distance[2][12] = distance[12][2] = 13;
        distance[2][13] = distance[13][2] = 18;

        distance[3][4] = distance[4][3] = 13;
        distance[3][5] = distance[5][3] = 16;
        distance[3][6] = distance[6][3] = 12;
        distance[3][7] = distance[7][3] = 13;
        distance[3][8] = distance[8][3] = 13;
        distance[3][9] = distance[9][3] = 18;
        distance[3][10] = distance[10][3] = 26;
        distance[3][11] = distance[11][3] = 21;
        distance[3][12] = distance[12][3] = 11;
        distance[3][13] = distance[13][3] = 17;

        distance[4][5] = distance[5][4] = 3;
        distance[4][6] = distance[6][4] = 2;
        distance[4][7] = distance[7][4] = 21;
        distance[4][8] = distance[8][4] = 25;
        distance[4][9] = distance[9][4] = 31;
        distance[4][10] = distance[10][4] = 38;
        distance[4][11] = distance[11][4] = 27;
        distance[4][12] = distance[12][4] = 16;
        distance[4][13] = distance[13][4] = 20;

        distance[5][6] = distance[6][5] = 4;
        distance[5][7] = distance[7][5] = 23;
        distance[5][8] = distance[8][5] = 28;
        distance[5][9] = distance[9][5] = 33;
        distance[5][10] = distance[10][5] = 41;
        distance[5][11] = distance[11][5] = 30;
        distance[5][12] = distance[12][5] = 17;
        distance[5][13] = distance[13][5] = 20;

        distance[6][7] = distance[7][6] = 22;
        distance[6][8] = distance[8][6] = 25;
        distance[6][9] = distance[9][6] = 29;
        distance[6][10] = distance[10][6] = 38;
        distance[6][11] = distance[11][6] = 28;
        distance[6][12] = distance[12][6] = 13;
        distance[6][13] = distance[13][6] = 17;

        distance[7][8] = distance[8][7] = 9;
        distance[7][9] = distance[9][7] = 22;
        distance[7][10] = distance[10][7] = 18;
        distance[7][11] = distance[11][7] = 7;
        distance[7][12] = distance[12][7] = 25;
        distance[7][13] = distance[13][7] = 30;

        distance[8][9] = distance[9][8] = 13;
        distance[8][10] = distance[10][8] = 12;
        distance[8][11] = distance[11][8] = 12;
        distance[8][12] = distance[12][8] = 23;
        distance[8][13] = distance[13][8] = 28;

        distance[9][10] = distance[10][9] = 20;
        distance[9][11] = distance[11][9] = 27;
        distance[9][12] = distance[12][9] = 20;
        distance[9][13] = distance[13][9] = 23;

        distance[10][11] = distance[11][10] = 15;
        distance[10][12] = distance[12][10] = 35;
        distance[10][13] = distance[13][10] = 39;

        distance[11][12] = distance[12][11] = 31;
        distance[11][13] = distance[13][11] = 37;

        distance[12][13] = distance[13][12] = 5;
    }

    public static void generateNode(ArrayList<Node> nodes){
        Node newNode1 = new Node(0, "blue", null, null, 0, 0);
        Node newNode2 = new Node(1, "blue, yellow", null, null, 0, 0); //Colocar x ou as duas possiveis
        Node newNode3 = new Node(2, "blue, red", null, null, 0, 0);
        Node newNode4 = new Node(3, "blue, green", null, null, 0, 0);
        Node newNode5 = new Node(4, "blue, yellow", null, null, 0, 0);
        Node newNode6 = new Node(5, "blue", null, null, 0, 0);
        Node newNode7 = new Node(6, "yellow", null, null, 0, 0);
        Node newNode8 = new Node(7, "green, yellow", null, null, 0, 0);
        Node newNode9 = new Node(8, "yellow, red", null, null, 0, 0);
        Node newNode10 = new Node(9, "yellow", null, null, 0, 0);
        Node newNode11 = new Node(10, "red", null, null, 0, 0);
        Node newNode12 = new Node(11, "green", null, null, 0, 0);
        Node newNode13 = new Node(12, "green, red", null, null, 0, 0);
        Node newNode14 = new Node(13, "green", null, null, 0, 0);

        newNode1.getChildren().add(newNode2);

        newNode2.getChildren().add(newNode1); newNode2.getChildren().add(newNode3);
        newNode2.getChildren().add(newNode9); newNode2.getChildren().add(newNode10);

        newNode3.getChildren().add(newNode2); newNode3.getChildren().add(newNode4);
        newNode3.getChildren().add(newNode9); newNode3.getChildren().add(newNode13);

        newNode4.getChildren().add(newNode3); newNode4.getChildren().add(newNode5);
        newNode4.getChildren().add(newNode8); newNode4.getChildren().add(newNode13);

        newNode5.getChildren().add(newNode4); newNode5.getChildren().add(newNode6);
        newNode5.getChildren().add(newNode7); newNode5.getChildren().add(newNode8);

        newNode6.getChildren().add(newNode5);

        newNode7.getChildren().add(newNode5);

        newNode8.getChildren().add(newNode4); newNode8.getChildren().add(newNode5);
        newNode8.getChildren().add(newNode9); newNode8.getChildren().add(newNode12);

        newNode9.getChildren().add(newNode2); newNode9.getChildren().add(newNode3);
        newNode9.getChildren().add(newNode8); newNode9.getChildren().add(newNode11);

        newNode10.getChildren().add(newNode2);

        newNode11.getChildren().add(newNode9);

        newNode12.getChildren().add(newNode8);

        newNode13.getChildren().add(newNode3); newNode13.getChildren().add(newNode4);
        newNode13.getChildren().add(newNode14);

        newNode14.getChildren().add(newNode13);

        nodes.add(newNode1); nodes.add(newNode2); nodes.add(newNode3);
        nodes.add(newNode4); nodes.add(newNode5); nodes.add(newNode6);
        nodes.add(newNode7); nodes.add(newNode8); nodes.add(newNode9);
        nodes.add(newNode10); nodes.add(newNode11); nodes.add(newNode12);
        nodes.add(newNode13); nodes.add(newNode14);

    }
}
