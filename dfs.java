class Solution {

    private void dfsRec(int ch, boolean[] vis, ArrayList<Integer> ans,
                        ArrayList<ArrayList<Integer>> adj) {
        // marking vertex as visited and adding it to output list.
        vis[ch] = true;
        ans.add(ch);

        // iterating over connected components of the vertex and if any
        // of them is not visited then calling the function recursively.
        for (int i = 0; i < adj.get(ch).size(); i++)
            if (!vis[adj.get(ch).get(i)]) dfsRec(adj.get(ch).get(i), vis, ans, adj);
    }

    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        // using a boolean list to mark all the vertices as not visited.
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<Integer>();
        dfsRec(0, vis, ans, adj);

        // returning the output list.
        return ans;
    }
}