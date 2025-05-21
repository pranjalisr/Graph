// Function to find BFS of Graph from given source s
import java.util.*;

class Gf {

    // BFS from given source s
    static ArrayList<Integer> bfs(
        ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        
        int s = 0; // source node
        // create an array to store the traversal
        ArrayList<Integer> res = new ArrayList<>();
        
        // Create a queue for BFS
        Queue<Integer> q = new LinkedList<>();
        
        // Initially mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        
        // Mark source node as visited and enqueue it
        visited[s] = true;
        q.add(s);
        
        // Iterate over the queue
        while (!q.isEmpty()) {
            
            // Dequeue a vertex from queue and store it
            int curr = q.poll();
            res.add(curr);
            
            // Get all adjacent vertices of the dequeued 
            // vertex curr If an adjacent has not been 
            // visited, mark it visited and enqueue it
            for (int x : adj.get(curr)) {
                if (!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                }
            }
        }
        return res;
        }
}