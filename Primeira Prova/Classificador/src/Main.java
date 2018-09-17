import java.util.*;

class Main {
    ArrayList<Double> attributes = new ArrayList<>();
    String realType;
    String type;
    ArrayList<Main> neighbors = new ArrayList<>();
    double distance;

    public Main(ArrayList<Double> attributes, String realType, ArrayList<Main> neighbors) {
        this.attributes = attributes;
        this.realType = realType;
        this.neighbors = neighbors;
    }

    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();
        ArrayList<Main> finalClassifier = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        Util.accessUrl(data);
        System.out.println("K neighbors:");
        int K = input.nextInt();
        getValues(data, finalClassifier, K);

    }

    public static void getValues(ArrayList<String> data, ArrayList<Main> finalClassifier, int K) {
        Collections.shuffle(data);
        int count = 0;
        double hit = 0;
        double miss = 0;

        for (String current : data) {
            String aux = "";
            ArrayList<Double> attributes = new ArrayList<>();

            for (int i = 0; i < current.length(); i++) {
                if (current.charAt(i) == ',') {
                    attributes.add(Double.parseDouble(aux));
                    aux = "";
                } else
                    aux += current.charAt(i);
            }
            Main newData = new Main(attributes, aux, null);
            test(newData, finalClassifier, K);
            if(count > 99){
                if(newData.type.equals(newData.realType)){
                    hit++;
                } else miss++;
            }
            count++;
        }
        System.out.printf("Acertos: %.0f  -  Acuracia: %.1f%%\n" +
                "Erros: %.0f  -  Taxa de erros: %.1f%%\n", hit, (hit/50)*100, miss, (miss/50)*100);
    }

    public static void test(Main newData, ArrayList<Main> finalClassifier, int K) {
        ArrayList<Main> neighbors = new ArrayList<>();
        double distanceMax = 1000;

        for (Main current : finalClassifier) {
            double distance = distance(newData, current);
            if (distance <= distanceMax) {
                current.distance = distance;
                if (neighbors.size() == K) {
                    neighbors.sort(new DistanceComparator());
                    neighbors.add(0, current);
                    neighbors.sort(new DistanceComparator());
                    distanceMax = neighbors.get(0).distance;
                } else neighbors.add(current);
            }
        }
        newData.neighbors = neighbors;
        classifier(newData);
        finalClassifier.add(newData);
    }

    public static double distance(Main newData, Main data) {
        double distance = 0.0;

        for (int i = 0; i < 4; i++) {
            distance += Math.pow(newData.attributes.get(0) - data.attributes.get(0), 2);
        }
        return Math.sqrt(distance);
    }

    public static void classifier(Main data){
        int frequency[] = {0,0,0};
        for(Main current : data.neighbors){
            if(current.realType.equals("Iris-setosa")){
                frequency[0]++;
            } else if(current.realType.equals("Iris-versicolor")){
                frequency[1]++;
            } else frequency[2]++;
        }
        int max = Math.max(frequency[0], frequency[1]);
        max = Math.max(frequency[2], max);

        if(max == frequency[0]){
            data.type = "Iris-setosa";
        } else if(max == frequency[1]){
            data.type = "Iris-versicolor";
        } else if(max == frequency[2]){
            data.type = "Iris-virginica";
        } else data.type = data.realType;
    }

    // acuracia = acertos/base ; taxa de erros = erros/base
}
