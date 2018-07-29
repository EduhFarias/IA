import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        ArrayList<Node> nodes = new ArrayList<>();
        Util.generateNode(nodes);
        ArrayList<Node> path = new ArrayList<>();

        System.out.println("Estação de embarque: (Somente o numero)");
        int in = input.nextInt();
        System.out.println("Estação de desembarque: (Somente o numero)");
        int out = input.nextInt();

        Node root = null;
        Node goal = null;
        try {
            root = Node.getNode(in, nodes);
            goal = Node.getNode(out, nodes);
        } catch (NullPointerException e){
            System.out.println("Invalido");
            System.exit(1);
        }

        path.add(root);
        search(root, goal, path, 0);

        for(Node current : path){
            System.out.println("E" + current.getStation());
        }
    }

    public static void search(Node station, Node goal, ArrayList<Node> path, double depth){
        if(station == goal){
            return;
        } else{
            double deeper = 1000000;
            Node choice = null;
            int h = 0;
            double total = 0;

            for(Node current : station.getChildren()){ //loop para checar para qual filho vai
                h = Util.generateMatrix(current.getStation(), station.getStation());
                if(!current.equals(station.getFather())){
                    if((h + depth) < deeper || current.equals(goal)){ //verifica se a distancia do filho ao pai é menor
                        if(station.getFather() != null && !station.getFather().getLine().contains(current.getLine())){
                            total = 2;
                        } else total = 0;
                        deeper = h;
                        current.setFather(station);
                        choice = current;
                        if(current.equals(goal)) break;
                    }
                }
            }
            total += (h + depth);
            path.add(choice);
            search(choice, goal, path, total);
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
