class Solution {
    public boolean isCycleUtil(int v, List<Integer>[] adj, boolean[] visited,
                               int parent) {
        visited[v] = true;

        for (int i : adj[v]) {
            if (!visited[i]) {
                if (isCycleUtil(i, adj, visited, v)) return true;
            } else if (i != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean isCycle(int V, int[][] edges) {
        List<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[V];

        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                if (isCycleUtil(u, adj, visited, -1)) return true;
            }
        }
        return false;
    }
}