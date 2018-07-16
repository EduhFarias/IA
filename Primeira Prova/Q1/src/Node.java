import java.util.*;

public class Node {
    private Node father;
    private List<Node> children;
    private List<Integer> leftState;
    private List<Integer> boatState;
    private List<Integer> rightState;
    private int depth;

    public Node() {
        this.father = null;
        this.children = new ArrayList<>();
        this.leftState = new ArrayList<>();;
        this.boatState = new ArrayList<>();;
        this.rightState = new ArrayList<>();;
        this.depth = 0;
    }

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public List<Integer> getLeftState() {
        return leftState;
    }

    public void setLeftState(List<Integer> leftState) {
        this.leftState = leftState;
    }

    public List<Integer> getBoatState() {
        return boatState;
    }

    public void setBoatState(List<Integer> boatState) {
        this.boatState = boatState;
    }

    public List<Integer> getRightState() {
        return rightState;
    }

    public void setRightState(List<Integer> rightState) {
        this.rightState = rightState;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public static void createRoot(Tree root) {
        for(int i = 0; i < 2; i++){
            root.getRoot().getLeftState().add(3);
            root.getRoot().getBoatState().add(0);
            root.getRoot().getRightState().add(0);
        }
    }

    public static void addNode(Node father){
        Node newNode = new Node();

        newNode.father = father;
        newNode.setDepth(father.getDepth() + 1);
        father.getChildren().add(newNode);
    }
}
