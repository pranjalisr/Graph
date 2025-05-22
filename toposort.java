class Solution {
    public static void topoSortUtil(int v, List<Integer>[] adj, boolean[] visited,
                                    Stack<Integer> stack) {
        visited[v] = true;

        for (int i : adj[v]) {
            if (!visited[i]) {
                topoSortUtil(i, adj, visited, stack);
            }
        }

        stack.push(v);
    }

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        List<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoSortUtil(i, adj, visited, stack);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        int index = 0;
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }
}