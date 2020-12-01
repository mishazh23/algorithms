package by.bsu.args.run;

import by.bsu.args.entity.Graph;

import java.util.List;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Find components in 3-component graph");
        List<List<Integer>> vertices2 = asList(
                asList(1,2),
                asList(0,2),
                asList(1,0),
                asList(3),
                asList(5),
                asList(4)
        );
        int size2 = 6;
        Graph graphThreeComponent = new Graph(size2, vertices2);
        graphThreeComponent.findComponents();
        System.out.println("There are " + graphThreeComponent.getNumberOfComponents() + " components:");
        for(int i = 0; i < graphThreeComponent.getNumberOfComponents(); i++){
            System.out.println(graphThreeComponent.getComponent(i));
        }
        int size1 = 6;
        List<List<Integer>> vertices1 = asList(
                asList(1,2),
                asList(0,2,3,4),
                asList(0,1,4,5),
                asList(1,4),
                asList(1,2,3,5),
                asList(4,2)

        );
        Graph graphEuler = new Graph(size1, vertices1);
        System.out.println("\n" + "Find out if the graph is Eulerian ");
        if(graphEuler.isEuler()){
            System.out.println("Graph is Eulerian!" + "\n" + "The cycle is: ");
            System.out.println(graphEuler.FindEulerCycle() + "\n");
        }else{
            System.out.println("Graph isn't Eulerian :(");
        }

        int size = 7;
        List<List<Integer>> vertices = asList(
                asList(1),
                asList(0,2,3),
                asList(1,4),
                asList(1),
                asList(2,5),
                asList(4,6),
                asList(5));
        Graph bigraph = new Graph(size, vertices);
        System.out.println("Find out if the graph is bigraph ");
        if(bigraph.isBipartite()){
            System.out.println("The graph is bigraph!");
            bigraph.findBiComponent();
        }else{
            System.out.println("The graph isn't bi :(");
        }
    }
}
