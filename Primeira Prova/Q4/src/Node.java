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

        System.out.println("Escolha uma coordenada ' - ' para marcar: (linha, coluna)");
        int line = in.nextInt();
        int column = in.nextInt();
        root.board[line][column] = "X";
        generate(root);
        /*while(!condition){
            if(i >= 1) break;
            showBoard(root.board);
            System.out.println("Escolha uma coordenada ' - ' para marcar: (linha, coluna)");
            line = in.nextInt();
            column = in.nextInt();
            //condition = mark(root, line, column);
            root.board[line][column] = "X";
            root.board[1][1] = "X";
            root.board[2][1] = "0";
            root.board[1][2] = "X";
            root.board[1][0] = "0";
            generate(root);
            i++;
        }*/
        showBoard(root.board);
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
        if(check(node.board) || count(node.board) == 0) {
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
                        node.children.add(newNode);
                        showBoard(newNode.board);
                        generate(newNode);
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

        public static void minimax(Node node){

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
        }
        if( (board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0])) && !board[1][0].equals("-")){
            if(board[1][1].equals("X")){
                return -1;
            } else return 1;
        }
        if( (board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2])) && !board[1][2].equals("-")){
            if(board[1][1].equals("X")){
                return -1;
            } else return 1;
        }
        return 0;
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
