import java.util.*;
import java.net.*;
import java.io.*;

public class Util {

    public static void accessUrl(ArrayList<String> infos){

        HttpURLConnection connection = null;
        BufferedReader reader = null;
        StringBuilder stringBuilder = null;
        String line = null;
        URL serverAddress = null;

        try{
            serverAddress = new URL("https://archive.ics.uci.edu/ml/machine-learning-databases/iris/iris.data");
            connection = (HttpURLConnection)serverAddress.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setReadTimeout(100000);

            connection.connect();

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            stringBuilder = new StringBuilder();

            while((line = reader.readLine()) != null){
                stringBuilder.append(line + '\n');
                infos.add(line);
            }
            infos.remove(150);
            
            /*for(String current : infos){
                System.out.println(current);
            }*/

            connection.disconnect();
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
