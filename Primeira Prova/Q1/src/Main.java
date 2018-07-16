import java.util.*;

public class Main {
    public static void main(String[] args){
        Node newNode = new Node();
        Tree root = new Tree(newNode);
        Node.createRoot(root);

        View.header();
        View.print(root.getRoot());
    }

}
