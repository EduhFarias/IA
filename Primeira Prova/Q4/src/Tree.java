import java.util.*;

class Tree {
    int depth;
    String[][] board;
    ArrayList<String[][]> children = new ArrayList<>();

    Tree(){
        this.depth = 0;
        this.board = createBoard();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = 0, j = 1;
        Tree newTree = new Tree();
        boolean condition = false;

        while(!condition){
            if(i >= 5) break;
                showBoard(newTree.board);
                System.out.println("Escolha uma coordenada ' - ' para marcar: (linha, coluna)");
                int line = in.nextInt();
                int column = in.nextInt();
                condition = mark(newTree, line, column);
                i++;
            }
        showBoard(newTree.board);

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

    public static boolean mark(Tree root, int line, int column){
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

    public static void generate(){
        
    }
    
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
  
