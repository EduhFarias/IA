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
        root.setPast(true);
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
            double evaluation;
            double total = 0;

            for(Node current : station.getChildren()){
                evaluation = evaluation(current, goal);
                if(!current.isPast()){
                    if(evaluation < deeper || current.equals(goal)){
                        if(station.getFather() != null && !station.getFather().getLine().contains(current.getLine())){
                            total = 2;
                        } else total = 0;
                        deeper = evaluation;
                        current.setFather(station);
                        choice = current;
                        if(current.equals(goal)) break;
                    }
                }
            }
            choice.setPast(true);
            total += (deeper + depth);
            path.add(choice);
            search(choice, goal, path, total);
        }
    }

    public static int heuristic(Node station, Node goal){
        int h = Util.generateMatrix(station.getStation(), goal.getStation());
        return h;
    }

    public static double depth(Node current){
        double total = 0;
        while(current.getFather() != null){
            total += heuristic(current, current.getFather());
            current = current.getFather();
        }
        return total;
    }

    public static double evaluation(Node current, Node goal){
        double total;
        int h = heuristic(current, goal);
        double depth = depth(current);
        total = h + depth;
        return total;
    }


}
