import java.util.*;

public class Main {
    public static void main(String[] args){
        ArrayList<Subject> population = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        Random r = new Random();

        System.out.println("Population: (int)");
        Subject.generatePopulation(population, input.nextInt());

        System.out.println("Processes: (int)");
        int processes = input.nextInt();
        for(int i = 0; i < processes; i++){
            AG(population);
            population.sort(new FitnessComparator());
        }
        Util.showBest(population.get(0));
    }

    public static void AG(ArrayList<Subject> population){
        selection(population);
    }

    public static void fitness(Subject subject){
        subject.fitness = Util.accessUrl(Util.setUrl(subject.angles));
        //System.out.println(subject.fitness); //test

    }

    public static void selection(ArrayList<Subject> population){
        Collections.shuffle(population);
        ArrayList<Subject> children = new ArrayList<>();
        Subject[] parents;
        int size = population.size();

        for(int i = 0; i < size; i+= 2){
            parents = Subject.getSubject(population);
            Subject[] newParents = crossover(parents[0], parents[1]);
            children.add(newParents[0]);
            children.add(newParents[1]);
        }
        population.addAll(children);
        survival(population, size);
    }

    public static Subject[] crossover(Subject parent1, Subject parent2){
        Random generate = new Random();
        Subject child1 = new Subject(new ArrayList<>()), child2 = new Subject(new ArrayList<>());
        Subject[] newChildren = new Subject[2];

        for(int i = 0; i < 6; i++){
            if(generate.nextInt(2) > 0){
                child1.angles.add(i, parent1.angles.get(i));
                child2.angles.add(i, parent2.angles.get(i));
            } else{
                child1.angles.add(i, parent2.angles.get(i));
                child2.angles.add(i, parent1.angles.get(i));
            }
        }

        newChildren[0] = mutation(child1);
        newChildren[1] = mutation(child2);
        return newChildren;
    }

    public static Subject mutation(Subject subject){
        Random random = new Random();
        if(random.nextInt(11) > 3){
            int i = random.nextInt(6);
            int newAngle = random.nextInt(361);
            subject.angles.set(i, newAngle);
        }
        fitness(subject);
        return subject;
    }

    public static void survival(ArrayList<Subject> population, int size){
        population.sort(new FitnessComparator());

        for(int i = population.size()-1; i > size; i--){
            population.remove(i);
        }
    }

}
