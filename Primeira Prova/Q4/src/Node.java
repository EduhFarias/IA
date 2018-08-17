import java.util.*;

class Node {
    int evaluate;
    String[][] board;
    ArrayList<Node> children = new ArrayList<>();
    int max;
    int depth;

    Node(){
        this.evaluate = -2;
        this.board = Util.createBoard();
        this.max = 0;
        this.depth = 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Node root = new Node();
        int i = 0;
        Util.showBoard(root.board);
        System.out.println("Escolha uma coordenada ' - ' para marcar: (linha, coluna)");
        int line = in.nextInt();
        int column = in.nextInt();
        root.board[line][column] = "X";
        Util.showBoard(root.board);
        generate(root);
        minimax(root);
        root = Util.getChoice(root);

        while(check(root.board) == false && Util.count(root.board) != 0){
            Util.showBoard(root.board);
            System.out.println("Escolha uma coordenada ' - ' para marcar: (linha, coluna)");
            line = in.nextInt();
            column = in.nextInt();
            root.board[line][column] = "X";
            root = Util.getNode(root, root.board);
            root = Util.getChoice(root);
            i++;
        }
        Util.showBoard(root.board);
        if(i > 4 && check(root.board) == false){
            System.out.println("Empate");
        } else{
            if(root.max == 1) System.out.println("Voce perdeu");
            else System.out.println("Voce ganhou");
        }
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
                        newNode.depth = node.depth + 1;
                        Util.copy(node.board, newNode.board);
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

    public static int minimax(Node node){
        if(check(node.board)){
            return node.depth - evaluation(node.board);
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

    // Checa se o nó atual é uma solução ou se todas as casas já foram marcadas
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
        if(Util.count(board) == 0){
            return true;
        }
        return false;
    }

    // Retorna '1' se ganhar, '0' se empatar '-1' se perder ---- Testada no debug e esta certa
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

}
