import java.util.*;

public class State {
    private int station;
    private State father;
    private List<State> children;
    private int heuristic;
    private int depth;

    public State(int station, State father, List<State> children, int heuristic, int depth) {
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

    public State getFather() {
        return father;
    }

    public void setFather(State father) {
        this.father = father;
    }

    public List<State> getChildren() {
        return children;
    }

    public void setChildren(List<State> children) {
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

    public static void cDepth(State node){
        State aux;
        int cont = 0;
        boolean condition = true;
        while(condition){
            aux = node.getFather();
            cont += //matriz[aux.getStation()][node.getStation()];
            //Acessa a tabela de distancia entre pontos para pegar a diff entre o no atual e seu pai
            if(aux == null) condition = false;
        }
    }

}
