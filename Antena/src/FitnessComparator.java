import java.util.*;

public class FitnessComparator implements Comparator<Subject> {
    public int compare(Subject o1, Subject o2){
        if(o1.fitness < o2.fitness) return 1;
        else if(o1.fitness > o2.fitness) return -1;
        else return 0;
    }
}
