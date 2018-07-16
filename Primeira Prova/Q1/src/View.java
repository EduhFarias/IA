import java.util.*;

public class View {
    public static void header(){
        System.out.println(" Left  Boat  Right");
        System.out.println(" M,C   M,C   M,C");
    }

    public static void print(Node node){
        System.out.printf("(%d,%d) (%d,%d) (%d,%d)", node.getLeftState().get(0), node.getLeftState().get(1),
                node.getBoatState().get(0), node.getBoatState().get(1), node.getRightState().get(0),
                node.getRightState().get(1));
    }
}
