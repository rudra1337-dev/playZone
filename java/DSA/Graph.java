import java.util.*;

class GraphUtils{
    List<Integer> bfs(List<List<Integer>> graph, int source){
        List<Integer> res = new ArrayList<>();

        if(graph.size() <= 0 ) return res;

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        visited.add(source);
        res.add(source);

        while(!queue.isEmpty()){
            int curr = queue.poll();
            

            for(int neighbor : graph.get(curr)){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.offer(neighbor);
                    res.add(neighbor);
                    System.out.println(neighbor+",");
                }
            }

            System.out.println();
        }

        return res;
    }

    private List<Integer> parentToPath(int[] parent, int source){
        List<Integer> path = new ArrayList<>();
        
        while(source != -1){
            path.add(source);
            source = parent[source];
        }

        Collections.reverse(path);
        return path;
    }


    List<Integer> minPath(List<List<Integer>> graph, int source, int target){
        if(graph.size() <= 0 ) return nuull;

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        visited.add(source);
        queue.offer(source);
        int[] parent = new int[graph.size()];
        parent[source] = -1;

        while(!queue.isEmpty()){
            int curr = queue.poll();

            for(int neighbor : graph.get(curr)){
                if(!visited.contains(neighbor)){
                    parent[neighbor] = curr;
                    if(neighbor == target) return parentToPath(parent, target);
                    visited.add(neighbor);
                    queue.offeer(neighbor);
                }
            }
        }

        return null;
    }


    int distance(List<List<Integer>> graph, int source, int target){
        if(graph.size() <= 0 ) return -1;

        Set<Integer> visited = new HashSet<>();
        int[] dist = new int[graph.size()];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        dist[source] = 0;
        visited.add(source);

        while(!queue.isEmpty()){
            int curr = queue.poll();

            for(int neighbor : graph.get(curr)){

                if(!visited.contains(neighbor)){
                    dist[neighbor] = dist[curr]+1;
                    if(neighbor == target) return dist[curr]+1;
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return -1;
    }


    List<Integer> bfsgrid(int[][] grid, int sr, int sc){
        List<Integer> res = new ArrayList<>();

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Arrays.fill(visited, false);
        visited[sr][sc] = true;
        res.add(grid[sr][sc]);

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            int cr = curr[0];
            int cc = curr[1];

            for(int d=0; d<4; d++){
                // if((d == 0 && cr == 0) || (d == grid.length-1 && cr == 1) ||
                // (d == 2 && cc == 0) || (d == 3 && cc == grid[0].length)) continue;

                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length) continue;

                if(!visited[nr][nc]){
                    visited[nr][nc] = true;
                    res.add(grid[nr][nc]);
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return res;
    }
}

class GraphRel extends GraphUtils{
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