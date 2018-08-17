import java.util.*;

class Node {
    int evaluate;
    String[][] board;
    ArrayList<Node> children = new ArrayList<>();
    int max;

    Node(){
        this.evaluate = -2;
        this.board = createBoard();
        this.max = 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = 0;
        Node root = new Node();
        boolean condition = false;

        showBoard(root.board);
        System.out.println("Escolha uma coordenada ' - ' para marcar: (linha, coluna)");
        int line = in.nextInt();
        int column = in.nextInt();
        root.board[line][column] = "X";
        showBoard(root.board);
        generate(root);
        minimax(root);
        root = getChoice(root);

        while(check(root.board) || count(root.board) != 0){
            showBoard(root.board);
            System.out.println("Escolha uma coordenada ' - ' para marcar: (linha, coluna)");
            line = in.nextInt();
            column = in.nextInt();
            root.board[line][column] = "X";
            root = getNode(root, root.board);
            root = getChoice(root);
        }
    }

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

            condition = check(root.board);
            if(!condition) {
                Random random = new Random();
                int i = 0;
                while(i < 4){
                    int lineOP = random.nextInt(3);
                    int columnOP = random.nextInt(3);
                    if(root.board[lineOP][columnOP].equals("-")){
                        root.board[lineOP][columnOP] = "O";
                        condition = check(root.board);
                        break;
                    }
                    i++;
                }
            }
        }
        return condition;
    }

    public static void generate(Node node){
        if(check(node.board)) {
            node.evaluate = evaluation(node.board);
            return;
        } else {
            for(int line = 0; line < 3; line++){
                for(int column = 0; column < 3; column++) {
                    if (node.board[line][column].equals("-")) {
                        Node newNode = new Node();
                        copy(node.board, newNode.board);
                        if (node.max == 0) {
                            newNode.board[line][column] = "O";
                            newNode.max = 1;
                        } else {
                            newNode.board[line][column] = "X";
                            newNode.max = 0;
                        }
                        //showBoard(newNode.board);
                        generate(newNode);
                        node.children.add(newNode);
                    }
                }
            }
        }
    }

    public static void copy(String[][] board, String[][] copy){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                copy[i][j] = board[i][j];
            }
        }
    }

    public static int minimax(Node node){
        if(check(node.board)){
            return evaluation(node.board);
        } else if(node.max == 0){
            int alpha = -10;
            for (Node current : node.children){
                int x = minimax(current);
                if(x > alpha){
                    alpha = x;
                }
            }
            node.evaluate = alpha;
            return alpha;
        } else{
            int beta = 10;
            for (Node current : node.children){
                int x = minimax(current);
                if(x < beta){
                    beta = x;
                }
            }
            node.evaluate = beta;
            return beta;
        }
    }

    // Checa se o nó atual é uma solução
    public static boolean check(String[][] board){
        if( (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[1][1].equals("-")) ||
                (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) && !board[1][1].equals("-") ||
                (board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2])) && !board[0][1].equals("-") ||
                (board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2])) && !board[1][1].equals("-") ||
                (board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2])) && !board[2][1].equals("-") ||
                (board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0])) && !board[1][0].equals("-") ||
                (board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1])) && !board[1][1].equals("-") ||
                (board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2])) && !board[1][2].equals("-") ){
            return true;
        }
        if(count(board) == 0){
            return true;
        }
        return false;
    }

    // Retorna '1' se ganhar, '0' se empatar '-1' se perder
    public static int evaluation(String[][] board){
        if( (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[1][1].equals("-")) ||
                (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) && !board[1][1].equals("-") ||
                (board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2])) && !board[1][1].equals("-") ||
                (board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1])) && !board[1][1].equals("-")){

            if(board[1][1].equals("X")){
                return -1;
            } else return 1;
        }
        if( (board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2])) && !board[0][1].equals("-")){
            if(board[1][1].equals("X")){
                return -1;
            } else return 1;
        }
        if((board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2])) && !board[2][1].equals("-")){
            if(board[1][1].equals("X")){
                return -1;
            } else return 1;
        } else if( (board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0])) && !board[1][0].equals("-")){
            if(board[1][1].equals("X")){
                return -1;
            } else return 1;
        } else if( (board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2])) && !board[1][2].equals("-")){
            if(board[1][1].equals("X")){
                return -1;
            } else return 1;
        } return 0;
    }

    public static Node getChoice(Node node){
        int max = -10;
        Node choice = null;
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
