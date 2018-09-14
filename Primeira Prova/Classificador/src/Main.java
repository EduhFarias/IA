import java.util.*;

public class Main {     //Talvez seja melhor fazer um objeto
    public static void main(String[] args){
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<ArrayList<String>> values = new ArrayList<>();
        Util.accessUrl(strings);
        getValues(strings, values);

        /*for(ArrayList<String> current : values){
            for(String string : current){
                System.out.printf("%s ", string);
            }
            System.out.println();
        }*/
        Collections.shuffle(values);
        ArrayList<String> test = new ArrayList<>();
        test.add("5.1");
        test.add("4.3");
        test.add("1.2");
        test.add("0.4");
        distance(values, test);
    }

    public static void distance(ArrayList<ArrayList<String>> values, ArrayList<String> newObject){
        for(ArrayList<String> current : values){
            double distance = 0.0;
            for(int i = 0; i < 4; i++){
                distance += (Double.parseDouble(newObject.get(i)) - Double.parseDouble(current.get(i))) *
                        (Double.parseDouble(newObject.get(i)) - Double.parseDouble(current.get(i)));
            }
            distance = Math.sqrt(distance);
            System.out.println(distance);

        }
    }

    public static void getValues(ArrayList<String> strings, ArrayList<ArrayList<String>> values){
        int position = 0;
        int j = 0;

        for(String current : strings){
            String aux = null;
            ArrayList<String> test = new ArrayList<>();
            for(int i = 0; i < current.length(); i++){
                if(current.charAt(i) == ',' || i == current.length()-1){
                    aux = aux.replace("null", "");
                    test.add(j, aux);
                    j++;
                    aux = null;
                } else aux += current.charAt(i);

            }
            values.add(position, test);
            position++;
            j = 0;
        }
        values.remove(150);
    }
}
