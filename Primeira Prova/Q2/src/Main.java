import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        ArrayList<Node> nodes = new ArrayList<>();
        Util.generateNode(nodes);
        ArrayList<Node> path = new ArrayList<>();

        System.out.println("Estação de embarque: (Somente o numero)");
        int in = input.nextInt() - 1;
        System.out.println("Estação de desembarque: (Somente o numero)");
        int out = input.nextInt() - 1;

        Node root = null;
        Node goal = null;
        try {
            root = Node.getNode(in, nodes);
            goal = Node.getNode(out, nodes);
        } catch (NullPointerException e){
            System.out.println("Invalido");
            System.exit(1);
        }
        search(root, goal, path, 0);
        for(Node current : path){
            System.out.println("E" + current.getStation());
        }
    }

    public static void search(Node station, Node goal, ArrayList<Node> path, double depth){
        if(station == goal){
            path.add(station);
            return;
        } else{
            double deeper = 1000000;
            Node choice = null;
            for(Node current : station.getChildren()){
                if(Util.generateMatrix(current.getStation(), station.getStation()) < deeper){
                    if(station.getFather() != null || !station.getFather().getLine().contains(current.getLine())){
                        
                    }
                    deeper = depth;
                    current.setFather(station);
                    choice = current;
                }
            }
            path.add(choice);
            search(choice, goal, path, depth);
        }
    }

    public static int heuristic(int distance[][], Node station, Node goal){
        int h = distance[station.getStation()][goal.getStation()];
        return h;
    }

    public static double depth(Node root, Node station){
        double test = 0;
        return test;
    }

    public static double evaluation(Node current, Node goal, int distance[][], int depth){
        int total = heuristic(distance, current, goal) + depth;
        return total/0.5;
    }


}
