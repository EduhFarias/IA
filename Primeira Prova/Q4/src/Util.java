import java.util.*;

public class Util {
    public static String[][] createBoard(){
        String[][] board = new String[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = "-";
            }
        }
        return board;
    }

    public static int count(String[][] board){
        int count = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j].equals("-")) count++;
            }
        }
        return count;
    }

    //Função para o jogo sem uma ia
    public static boolean mark(Node root, int line, int column){
        boolean condition = false;
        if(root.board[line][column].equals("-")) {
            root.board[line][column] = "X";

            condition = Node.check(root.board);
            if(!condition) {
                Random random = new Random();
                int i = 0;
                while(i < 4){
                    int lineOP = random.nextInt(3);
                    int columnOP = random.nextInt(3);
                    if(root.board[lineOP][columnOP].equals("-")){
                        root.board[lineOP][columnOP] = "O";
                        condition = Node.check(root.board);
                        break;
                    }
                    i++;
                }
            }
        }
        return condition;
    }

    public static void copy(String[][] board, String[][] copy){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                copy[i][j] = board[i][j];
            }
        }
    }

    public static Node getChoice(Node node){
        int max = -10;
        Node choice = node;
        for(Node current : node.children){
            if(current.evaluate > max){
                max = current.evaluate;
                choice = current;
            }
        }
        return choice;
    }

    public static Node getNode(Node root, String[][] board){
        for(Node current : root.children){
            if (Arrays.equals(current.board[0],board[0]) && Arrays.equals(current.board[1],board[1])
                    && Arrays.equals(current.board[2],board[2])){
                return current;
            }
        }
        return null;
    }

    public static void showBoard(String[][] board){
        System.out.printf("    0   1   2\n   ___________\n");
        for(int i = 0; i < 3; i++){
            System.out.printf("%d |", i);
            for(int j = 0; j < 3; j++){
                System.out.printf(" %s |", board[i][j]);
            }
            System.out.println();
        }
        System.out.println("   -----------");
    }
}
