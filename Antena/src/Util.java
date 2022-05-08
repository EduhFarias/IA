import java.util.*;
import java.net.*;
import java.io.*;

public class Util {

    public static String setUrl(ArrayList<Integer> angles){
        return "http://localhost:8080/antenna/simulate?phi1=" + Integer.toString(angles.get(0)) +
                "&theta1=" + Integer.toString(angles.get(1)) + "&phi2=" + Integer.toString(angles.get(2)) +
                "&theta2=" + Integer.toString(angles.get(3)) + "&phi3=" + Integer.toString(angles.get(4)) +
                "&theta3=" + Integer.toString(angles.get(5));
    }

    public static void showBest(Subject subject){
        System.out.println("Ganho: " + subject.fitness + "\nPhi 1: " + subject.angles.get(0) +
                "\nTheta 1: " + subject.angles.get(1) + "\nPhi 2: " + subject.angles.get(2) +
                "\nTheta 2: " + subject.angles.get(3) + "\nPhi 3: " + subject.angles.get(4) +
                "\nTheta 3: " + subject.angles.get(5));
    }

    public static double accessUrl(String url){

        HttpURLConnection connection = null;
        BufferedReader reader = null;
        StringBuilder stringBuilder = null;
        String line = null;
        URL serverAddress = null;
        double fitness = 0;

        try{
            serverAddress = new URL(url);
            connection = (HttpURLConnection)serverAddress.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setReadTimeout(100000);

            connection.connect();

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            stringBuilder = new StringBuilder();

            while((line = reader.readLine()) != null){
                stringBuilder.append(line + '\n');
            }

            //System.out.println(stringBuilder.toString()); //test

            String aux = stringBuilder.toString().substring(0,12);
            fitness = Double.parseDouble(aux);

            connection.disconnect();
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return fitness;
    }

}
