import java.util.*;

public class Main {
    public static void main(String[] args){
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<ArrayList<String>> values = new ArrayList<>();
        Util.accessUrl(strings);
        getValues(strings, values);

        for(ArrayList<String> current : values){
            for(String string : current){
                System.out.printf("%s ", string);
            }
            System.out.println();
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
    }
}
