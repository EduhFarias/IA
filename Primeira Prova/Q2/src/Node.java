import java.util.*;
public class Node {
    private int station;
    private String line;
    private Node father;
    private List<Node> children;
    private int heuristic;
    private int depth;
    boolean past = false;

    public Node(int station, String line, Node father, List<Node> children, int heuristic, int depth) {
        this.station = station;
        this.line = line;
        this.father = father;
        this.children = new ArrayList<>();
        this.heuristic = heuristic;
        this.depth = depth;
    }

    public int getStation() {
        return station;
    }

    public void setStation(int station) {
        this.station = station;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
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

    public static Node getNode(int station, ArrayList<Node> nodes){
        for(Node current : nodes){
            if(current.getStation() == station){
                return current;
            }
        }
        return null;
    }
}
