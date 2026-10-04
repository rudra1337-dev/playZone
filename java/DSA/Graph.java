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








    //DFS

    void dfsRec(<List<Integer>> graph, int source, List<Integer> res, boolean[] visited){
        if(visited[source]) return;
        visited[source] = true;
        res.add(source);
        
        for(int neighbor : graph.get(source)){
            if(!visited[neighbor]){
                visited[neighbor] = true;
                dfsRec(graph, neighbor, res, visited);
            }
        }

    }

    //TC = O(v+e)
    //SC = O(v)


    List<Integer> dfsIte(List<List<Integer>> graph, int source){
        if(graph.size() <= 0) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        Queue<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.size()];

        stack.push(source);
        visited[source] = true;

        while(!stack.isEmpty()){
            int curr = stack.pop();
            res.add(curr);

            for(int neighbor : graph.get(curr)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }

        return res;
    }
    //Tc = O(v+e)
    //SC = O(v)


    // DFS on disconnected graph
    
    List<List<Integer>> dfsDisconnected(List<List<Integer>> graph){
        if(graph.size() <= 0 ) return new ArrayList<>();

        boolean[] visited = new boolean[graph.size()];
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<graph.size(); i++){
            if(!visited[i]){
                List<Integer> list = new ArrayList<>();
                dfsRec(graph, i, list, visited);
                res.add(list);
            }
        }

        return res;
    }

    //TC = O(v+e)
    //SC = O(v)

    // Count connected components

    int dfsConnectedCount(List<List<Integer>> graph){
        if(graph.size() <= 0 ) return 0;

        boolean[] visited = new boolean[graph.size()];
        int count = 0;

        for(int i=0; i<graph.size(); i++){
            if(!visited[i]){
                count++;
                dfsRec(graph, i, new ArrayList<>(), visited);
            }
        }

        return count;
    }


    //DFS on grid

    void dfsGrid(int[][] grid, int r, int c, boolean[][] visited, List<Integer> res){
        int row = grid.length, col = grid[0].length;

        if(r < 0 || r >= row || c < 0 || c >= col) return;
        if(visited[r][c]) return;

        visited[r][c] = true;
        res.add(grid[r][c]);

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for(int d = 0; d < 4; d++){

            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(nr < 0 || nr >= row || nc < 0 || nc >= col) continue;

            if(!visited[nr][nc]){
                visited[nr][nc] = true;
                dfsGrid(grid, nr, nc, visited, res);
            }
        }
    }

    // TC = O(v+e)
    // SC = O(v)


    // Cycledection

    // Undirected graph

    private boolean hasCycleDfs(List<List<Integer> graph, int source, int parent, boolean visited){
        visited[source] = true;

        for(int neighbor : graph.get(source)){

            if(!visited[neighbor]){
                if(hasCycleDfs(graph, neighbor, source, visited))  return true;
            }else if(neighbor != parent) return true;
        }

        return false;
    }
    //TC = O(v+e)
    //SC = (v)

    boolean hasCycleUndirectedDFS(List<List<Integer>> graph){
        int n = graph.size();
        if(n <= 0) return false;

        boolean[] visited = new boolean[n];


        for(int v=0; v<n; v++){
            if(!visited[v]) if(hasCycleDfs(graph, v, -1, visited)) return true;
        }

        return false;
    }

    //TC = O(v+e)
    //SC = (v)


    private class Node{
        int p, v;
        Node(int v, int p){
            this.v = v;
            this.p = p;
        }
    }

    boolean hasCycleUndirectedBFS(List<List<Integer> graph){
        int n = graph.size();
        if(n <= 0) return false;

        int[] visited = new int[n];
        Queue<Node> queue = new ArrayDeque<>();



        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            queue.offer(new Node(i, -1));
            visited[i] = true;

            while(!queue.isEmpty()){
                Node curr = queue.poll();
                int v = curr.v;
                int parent = curr.p;

                for(int neighbor : graph.get(v)){
                    if(!visited[neighbor]){
                        visited[neighbor] = true;
                        queue.offer(new Node(neighbor, v));
                    }else if(neighbor != parent) return true;
                }
            }
        }

        return false;
    }

    //TC = O(v+e)
    //SC = O(v)



    // Directed graph

    // state[x] = 0 → not visited
    // state[x] = 1 → currently visiting
    // state[x] = 2 → completely processed

    private boolean hasCycleDirected(List<List<Integer>> graph, int source, int[] state){
        state[source] = 1;

        for(int neighbor : graph.get(source)){
            if(state[neighbor] == 0){
                if(hasCycleDirected(graph, neighbor, state)) return true;
            }else if(state[neighbor] == 1) return true;
        }

        state[source] = 2;
        return false;
    }

    // TC = O(v+e)
    // SC = O(v)



    boolean hasCycleDirectedDFS(List<List<Integer>> graph){
        int n = graph.size();
        if(n <= 0) return false;

        int[] state = new int[n];

        for(int v=0; v<n; v++){
            if(state[v] == 0) if(hasCycleDirected(graph, v, state)) return true;
        }

        return false;
    }

    // TC =O(v+e)
    // SC = O(v)


    boolean hasCycleKahn(List<List<Integer>> graph){
        int n = graph.size();
        if(n <= 0) return false;

        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        int[] indegree = new int[n];


        //Degree calculation
        for(int i=0; i<n; i++){
            for(int neighbor : graph.get(i)){
                indegree[neighbor]++;
            }
        }

        // adding all the 0th degree elements to queue
        for(int i=0; i<n; i++){
            if(indegree[i] == 0) queue.offer(i);
        }


        while(!queue.isEmpty()){
            int curr = queue.poll();
            count++;

            for(int neighbor : graph.get(curr)){
                indegree[neighbor]--;

                if(indegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        return count != n;
    }

    // TC = O(v+e)
    // SC = O(v)
    

    // Bipartite Graph
    // 1. BFS Bipartite Check ⭐⭐⭐

    boolean bipartiteBFS(List<List<Integer>> graph, int[] color, int source){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);

        while(!queue.isEmpty()){
            int curr = queue.poll();

            for(int neighbor : graph.get(curr)){
                if(color[neighbor] == -1){
                    color[neighbor] = 1 - color[curr];
                    queue.offer(neighbor);
                }else if(color[neighbor] == color[curr]) return false;
            }
        }

        return true;
    }

    // TC = O(v+e)
    // SC = O(v)

    boolean isBipartiteBFS(List<List<Integer>> graph){
        int n = graph.size();
        if(n <= 0) return true;

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i=0; i<n; i++){
            if(color[i] == -1){
                color[i] = 0;
                if(!bipartiteBFS(graph, color, i)) return false;
            }
        }

        return true;
    }

    // TC = O(v+e)
    // SC = O(v)



    // 2. DFS Bipartite Check ⭐⭐⭐

    boolean bipartiteDFS(List<List<Integer>> graph, int color[], int source){

        for(int neighbor : graph.get(source)){
            if(color[neighbor] == -1){
                color[neighbor] = 1 - color[source];
                if(!bipartiteDFS(graph, color, neighbor)) return false;
            }else if(color[neighbor] == color[source]) return false;
        }

        return true;
    }

    //TC = O(v+e)
    //SC = O(v)

    boolean isBipartiteDFS(List<List<Integer>> graph){
        int n = graph.size();
        if(n <= 0) return true;

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i=0; i<n; i++){
            if(color[i] == -1){
                color[i] = 0;
                if(!bipartiteDFS(graph, color, i)) return false;
            }
        }

        return true;
    }

    //TC = O(v+e)
    //SC = O(v)


    // 3. DFS Bipartite-Directed Check ⭐⭐⭐

    boolean isBipartiteDirectedBFS(List<List<Integer>> graph){
        int n = graph.size();
        if(n <= 0) return true;

        //Create undirected graph

        List<List<Integer>> graphA = new ArrayList();

        for(int i=0; i<n; i++) graphA.add(new ArrayList<>());

        for(int from=0; from<n; from++){
            for(int to : graph.get(from)){
                graphA.get(from).add(to);
                graphA.get(to).add(from);
            }
        }


        int color[] = new int[n];
        Arrays.fill(color, -1);

        for(int i=0; i<n; i++){
            if(color[i] == -1){
                color[i] = 0;
                if(!bipartiteBFS(graphA, color, i)) return false;
            }
        }

        return true;
    }

    //TC = O(v+e)
    //SC = O(2e+v)



    //  Topological Sort

    // 1. Kahn's Algorithm — Topological Ordering ⭐⭐⭐

    List<Integer> topologicalSortKahn(List<List<Integer>> graph){
        int n = graph.size();
        if(n <= 0) return new ArrayList<>();

        //Find indegree
        int[] indegree = new int[n];
        for(int i=0; i<n; i++){
            for(int neighbor : graph.get(i)){
                indegree[neighbor]++;
            }
        }

        // Add the elements whose indegree are 0
        Queue<Integer> queue = new ArrayDeque<>();

        for(int i=0; i<n; i++) if(indegree[i] == 0) queue.offer(i);

        List<Integer> res = new ArrayList<>();
        int count = 0;

        while(!queue.isEmpty()){
            int curr = queue.poll();
            res.add(curr);
            count++;

            for(int neighbor : graph.get(curr)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                     queue.offer(neighbor);
                }
            }
        }

        if(count != n) return new ArrayList<>();

        return res;
    }

    // TC = O(v+e)
    // SC = O(v)


    // 2. Kahn's Algorithm — Cycle Detection ⭐⭐⭐

    boolean hasCycleKahn(List<List<Integer> graph){
        int n = graph.size();
        if(n <= 0) return false;

        // Calculate indegree
        int[] indegree = new int[n];

        for(int i=0; i<n; i++){
            for(int neighbor : graph.get(i)){
                indegree[neighbor]++;
            }
        }

        //Add all indegree 0 elements to queue
        Queue<Integer> queue = new ArrayDeque<>();

        for(int i=0; i<n; i++) if(indegree[i] == 0) queue.offer(i);

        int count = 0;


        while(!queue.isEmpty()){
            int curr = queue.poll();
            count++;

            for(int neighbor : graph.get(curr)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        return count != n;
    }

    //TC = O(v+e)
    //SC = O(v)


    // 3. DFS Topological Sort ⭐⭐⭐

    boolean hasCycleTopologicalDFS(List<List<Integer>> graph, int[] state, int curr, Deque<Integer> stack){
        

        for(int neighbor : graph.get(curr)){
            if(state[neighbor] == 0){
                state[neighbor] = 1;
                if(hasCycleTopologicalDFS(graph, state, neighbor, stack)) return true;
            }else if(state[neighbor] == 1) return true;
        }

        stack.push(curr);
        state[curr] = 2;
        return false;
    }


    List<Integer> topologicalSortDFS(List<List<Integer>> graph){
        int n = graph.size();
        if(n <= 0) return new ArrayList<>();

        int[] state = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            if(state[i] == 0){
                state[i] = 1;
                if(hasCycleTopologicalDFS(graph, state, i, stack)) return new ArrayList<>();
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!stack.isEmpty()) res.add(stack.pop());


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