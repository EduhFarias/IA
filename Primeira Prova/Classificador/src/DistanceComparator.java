import java.util.*;

public class DistanceComparator implements Comparator<Main> {
    public int compare(Main o1, Main o2){
        if(o1.distance > o2.distance) return 1;
        else if(o1.distance < o2.distance) return -1;
        else return 0;
    }
}
