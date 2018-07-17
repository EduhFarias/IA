import java.util.*;

public class Node {
    private int station;
    private Node father;
    private List<Node> children;
    private int heuristic;
    private int depth;

    public Node(int station, Node father, List<Node> children, int heuristic, int depth) {
        this.station = station;
        this.father = father;
        this.children = children;
        this.heuristic = heuristic;
        this.depth = depth;
    }

    public int getStation() {
        return station;
    }

    public void setStation(int station) {
        this.station = station;
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

    public int getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public static void cDepth(Node node){
        Node aux;
        int cont = 0;
        boolean condition = true;
        while(condition){
            aux = node.getFather();
            //cont += //matriz[aux.getStation()][node.getStation()];
            //Acessa a tabela de distancia entre pontos para pegar a diff entre o no atual e seu pai
            if(aux == null) condition = false;
        }
    }

}
