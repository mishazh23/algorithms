package by.bsu.args.entity;

import java.util.*;


public class Graph {
    private List<List<Integer>> vertices;
    private List<List<Integer>> components;
    private boolean flag;

    public Graph(int size, List<List<Integer>> vertices) {
        this.vertices = new ArrayList<>();
        this.components = new ArrayList<>();
        for (int i = 0; i < size; i++){
            this.vertices.add(vertices.get(i));
        }
    }

    public  List<Integer> getComponent (int index){
        return components.get(index);
    }

    public void findComponents(){
        List<Boolean> usedVertices = new ArrayList<>();
        for(int i = 0; i < this.vertices.size(); i++){
            usedVertices.add(false);
        }
        for(int i = 0; i < this.vertices.size(); i++){
            if(!usedVertices.get(i)){
                List<Integer> currentComponent = new LinkedList<>();
                depthSearch(i, currentComponent, usedVertices);
                this.components.add(currentComponent);
            }
        }
    }

    public int getNumberOfComponents(){
        return components.size();
    }

    public void depthSearch(int vertex, List<Integer> currentComponent, List<Boolean> usedVertices) {
        usedVertices.set(vertex, true);
        currentComponent.add(vertex);

        for(int i = 0; i < vertices.get(vertex).size(); i++){
            int nextVertex = vertices.get(vertex).get(i);
            if(!usedVertices.get(nextVertex)){
                depthSearch(nextVertex, currentComponent, usedVertices);
            }
        }
    }

    public boolean isEuler(){
        findComponents();
        if(getNumberOfComponents() == 1){
            for(int i = 0; i < vertices.size(); i++){
                if(vertices.get(i).size() % 2 != 0){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public List<Integer> FindEulerCycle(){
        int initialVertex = 0;
        List<Integer> cycle = new ArrayList<>();
        List<List<Integer>> graphCopy = createListCopy();
        Stack<Integer> nextVertices = new Stack<>();
        nextVertices.push(initialVertex);

        while (!nextVertices.isEmpty()){
            int vertex = nextVertices.peek();

            if(graphCopy.get(vertex).size() != 0){
                int nextVertex = graphCopy.get(vertex).get(0);
                nextVertices.push(nextVertex);
                graphCopy.get(vertex).remove(graphCopy.get(vertex).lastIndexOf(nextVertex));
                graphCopy.get(nextVertex).remove(graphCopy.get(nextVertex).lastIndexOf(vertex));
            }else{
                cycle.add(nextVertices.pop());
            }
        }
        return cycle;
    }

    public boolean isBipartite(){
        if(vertices.size() == 1 || vertices.size() == 0){
            return false;
        }
        flag = false;
        List<Character> verticesColor = new LinkedList<>();
        for(int i = 0; i < vertices.size(); i++){
            verticesColor.add('n');
        }
        return depthColorSearch(0, verticesColor, 'u');
    }

    public boolean depthColorSearch(int vertex, List<Character> verticesColor, char vColor){
        if(flag) return false;
        verticesColor.set(vertex, vColor);
        for ( int nextVert: vertices.get(vertex)
             ) {
            if(verticesColor.get(nextVert) == 'n'){
                char newColor = (vColor == 'v') ? 'u' : 'v';
                depthColorSearch(nextVert, verticesColor, newColor);
            }else{
                if(verticesColor.get(nextVert) == vColor){
                    flag = true;
                    return false;
                }
            }
        }
        return !flag;
    }

    public void findBiComponent(){
        List<Integer> uComponent = new ArrayList<>();
        List<Integer> vComponent = new ArrayList<>();
        flag = false;
        List<Character> verticesColor = new LinkedList<>();
        for(int i = 0; i < vertices.size(); i++){
            verticesColor.add('n');
        }
        if(vertices.size() == 1 || vertices.size() == 0 || !depthColorSearch(0, verticesColor, 'u')){
            return;
        }
        for(int i = 0; i < verticesColor.size(); i++){
            if(verticesColor.get(i) == 'u'){
                uComponent.add(i);
            }else{
                vComponent.add(i);
            }
        }
        System.out.println("First part: " + uComponent);
        System.out.println("Second part: " + vComponent);
    }


    private List<List<Integer>> createListCopy() {
        List<List<Integer>> graphCopy = new ArrayList<>();
        for (int i = 0; i < vertices.size(); i++) {
            graphCopy.add(new ArrayList<>());
        }

        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.get(i).size(); j++) {
                graphCopy.get(i).add(vertices.get(i).get(j));
            }
        }
        return graphCopy;
    }
}
