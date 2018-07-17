import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int distance[][] = new int[14][14];

        for(int i = 0; i < 14; i++){
            for(int j = 0; j < 14; j++){
                distance[i][j] = input.nextInt();
            }
        }

        String test = "E1";
        if(test.contains("2")){
            System.out.println("Ok");
        }
    }
}
