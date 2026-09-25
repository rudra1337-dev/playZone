import java.util.*;

class GraphRel{
    List<List<Integer>> graph;

    GraphRel(int vertices){
        this.graph = new ArrayList<>();

        for(int i=0; i<vertices; i++){
            graph.add(new ArrayList<>());
        }
    }
    
    private boolean isValidVertex(int v) {
        return v >= 0 && v < graph.size();
    }

    boolean addUndirectedEdge(int from, int to){
        if (!isValidVertex(from) || !isValidVertex(to)) {
            return false;
        }

        graph.get(from).add(to);
        graph.get(to).add(from);

        return true;
    }

    boolean removeUndirectedEdge(int from, int to){
        if (!isValidVertex(from) || !isValidVertex(to)) {
            return false;
        }

        graph.get(from).remove(Integer.valueOf(to));
        graph.get(to).remove(Integer.valueOf(from));

        return true;
    }

    boolean addDirectedEdge(int from, int to){
        if (!isValidVertex(from) || !isValidVertex(to)) {
            return false;
        }

        graph.get(from).add(to);

        return true;
    }

    boolean removeDirectedEdge(int from, int to){
        if (!isValidVertex(from) || !isValidVertex(to)) {
            return false;
        }

        return graph.get(from).remove(Integer.valueOf(to));
    }
}


class GraphWeighted{
    List<List<int[]>> graph;

    GraphWeighted(int vertices){
        this.graph = new ArrayList<>();

        for(int i=0; i<vertices; i++){
            graph.add(new ArrayList<>());
        }
    }
    
    
    private boolean isValidVertex(int v) {
        return v >= 0 && v < graph.size();
    }

    boolean addUndirectedEdge(int from, int to, int weight){
        if (!isValidVertex(from) || !isValidVertex(to)) {
            return false;
        }

        graph.get(from).add(new int[]{to, weight});
        graph.get(to).add(new int[]{from, weight});

        return true;
    }

    boolean removeUndirectedEdge(int from, int to){
        if (!isValidVertex(from) || !isValidVertex(to)) {
            return false;
        }

        boolean fromCleared = false, toCleared = false;

        for (int i = 0; i < graph.get(to).size(); i++) {
            if (graph.get(to).get(i)[0] == from) {
                graph.get(to).remove(i);
                fromCleared = true;
            }
        }

        for (int i = 0; i < graph.get(from).size(); i++) {
            if (graph.get(from).get(i)[0] == to) {
                graph.get(from).remove(i);
                toCleared = true;
            }
        }
        

        return fromCleared && toCleared;
    }

    boolean addDirectedEdge(int from, int to, int weight){
        if (!isValidVertex(from) || !isValidVertex(to)) {
            return false;
        }

        graph.get(from).add(new int[]{to, weight});

        return true;
    }

    boolean removeDirectedEdge(int from, int to){
        if (!isValidVertex(from) || !isValidVertex(to)) {
            return false;
        }

        for (int i = 0; i < graph.get(from).size(); i++) {
            if (graph.get(from).get(i)[0] == to) {
                graph.get(from).remove(i);
                return true;
            }
        }

        return false;
    }
}

class Edge{
    int neighbor;
    int weight;

    Edge(int neighbor, int weight){
        this.neighbor = neighbor;
        this.weight = weight;
    }
}

public class Graph{



    public static void main(String[] args){
        System.out.println("--------Welcome to Graph ---------");


    }
}