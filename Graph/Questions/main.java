import org.w3c.dom.Node;

import java.util.*;
class main {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.insert(0,1);
        g.insert(1,2);
        g.insert(2,3);
        g.insert(0,3);

        int[] vertices = g.shortestPathUnweighted(0);
        System.out.println(Arrays.toString(vertices));
    }
}

class Graph {
    int vertices;
    List<List<Integer>> adjacancyList;

    Graph(int vertices) {
        this.vertices = vertices;
        adjacancyList = new ArrayList<>(vertices);

        for(int i = 0; i < vertices; i++) {
            adjacancyList.add(new ArrayList<>());
        }
    }
    void insert(int src , int dest) {
        adjacancyList.get(src).add(dest);
//        adjacancyList.get(dest).add(src);
    }
    void DFS(int start){
        boolean[] visited = new boolean[vertices];
        rec_dfs(start, visited);

    }
    private void rec_dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for(int ver : adjacancyList.get(v)) {
            if(!visited[ver]) {
                rec_dfs(ver, visited);
            }
        }
    }
    void BFS(int start){
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while(!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            for(int ver : adjacancyList.get(v)) {
                if(visited[ver] == false) {
                queue.add(ver);
                visited[ver] = true;
                }
            }
        }
    }
    public boolean isCyclic() {
        boolean[] visited = new boolean[vertices];
        for(int i = 0; i < vertices; i++) {
            if(!visited[i]){
                if (rec_cycle(i, visited, -1)) return true;
            }
        }
        return false;
    }
    private boolean rec_cycle(int curr, boolean[] visited , int parent) {
        visited[curr] = true;

        for(int ver : adjacancyList.get(curr)){
            if(!visited[ver]) {
                if (rec_cycle(ver, visited, curr)) return true;
            } else if (ver != parent) {
                return true;
            }
        }

        return false;
    }
    boolean isConnected_DFS(){
        boolean[] visited = new boolean[vertices];
        rec_dfs(0, visited);

        for(boolean v : visited) {
            if(!v) return true;
        }
        return false;
    }
    public int[] shortestPathUnweighted(int source) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, -1); // -1 means unreachable
        Queue<Integer> queue = new LinkedList<>();

        distance[source] = 0;
        queue.offer(source);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : adjacancyList.get(current)) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        return distance;
    }
}

class Graph_using_matrix{
    int vertices;
    int[][] adjacency_matrix;
    Graph_using_matrix(int vertices) {
        this.vertices = vertices;
        adjacency_matrix = new int[vertices][vertices];
    }
    void insert(int src , int dest) {
        adjacency_matrix[src][dest] = 1;
        adjacency_matrix[dest][src] = 1;
    }
    boolean isCyclic() {
        boolean[] visited = new boolean[vertices];
        for(int i = 0; i < vertices; i++) {
            if(!visited[i]){
                if (rec_cycle(i, visited, -1)) return true;
            }
        }
        return false;
    }
    boolean rec_cycle(int curr, boolean[] visited, int parent) {
        visited[curr]  = true;
        for(int i = 0; i < vertices; i++) {
            int neighbour = adjacency_matrix[curr][i];
            if(neighbour == 1){
            if(!visited[i]) {
                if (rec_cycle(i, visited, curr)) return true;
            }else if(neighbour != parent){
                return true;
            }
            }
        }
        return  false;
    }
    void BFS (int start){
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            for(int i = 0; i< vertices; i++){
                if(adjacency_matrix[v][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    void DFS(int start){
        boolean[] visited = new boolean[vertices];
        rec_DFS(start, visited);
    }
    void rec_DFS(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println(v + " ");
        for(int i = 0; i < vertices; i++) {
            if(!visited[i] && adjacency_matrix[v][i] == 1) {
                rec_DFS(i, visited);
            }
        }
    }
}
