import java.util.*;
class Main {
    public static void main(String[] args) {
        ArrayList<Integer> states = new ArrayList<>();
        createState(states);
        System.out.println(" ESQ  BARCO   DIR\n M, C  M, C  M, C");
        do{
            System.out.println(states);
            test1(states);
        }while (!(states.get(4) == 3 && states.get(5) == 3));
        System.out.println(states);
    }

    public static void createState(ArrayList<Integer> states){
        states.add(3);
        states.add(3);
        states.add(0);
        states.add(0);
        states.add(0);
        states.add(0);
    }

    public static void test1(ArrayList<Integer> states){
        if(states.get(0) == 3 && states.get(1) == 3){
            states.set(0, 2);
            states.set(1, 2);
            states.set(2,1);
            states.set(3, 1);
            return;
        }
        else if(states.get(0).equals(states.get(1)) && (states.get(2) + states.get(3)) < 2){
            states.set(1, states.get(1) - 1);
            states.set(3, states.get(3) + 1);
            return;
        }
        else if(states.get(0) > (states.get(1)) && (states.get(2) + states.get(3)) < 2){
            states.set(0, states.get(0) - 1);
            states.set(2, states.get(2) + 1);
            return;
        }
        else if((states.get(2) + states.get(3)) == 2){
            if(states.get(4) == 2 && states.get(5) == 2){
                states.set(2, 0);
                states.set(3, 0);
                states.set(4, 3);
                states.set(5, 3);
                return;
            }
            else if(states.get(2) == 1 && states.get(3) == 1){
                states.set(2, 0);
                states.set(4,states.get(4)+1);
                return;
            }
            else if(states.get(2) == 0 && states.get(3) == 2){
                states.set(3, 1);
                states.set(5, states.get(5) + 1);
                return;
            }
        }
    }
}
  
