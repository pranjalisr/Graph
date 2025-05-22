class Solution {

    // 2D array for the storing the horizontal and vertical
    // directions. (Up, left, down, right}
    int R[] = {0, 0, 1, -1};
    int C[] = {1, -1, 0, 0};
    int D[] = {1, 2, 3, 4};

    // Function to perform bfs of the input grid
    String layout(int i, int j, int grid[][]) {
        StringBuilder sb = new StringBuilder();
        Queue<int[]> queue = new LinkedList<>();
        int size, current[], nR, nC;
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size != 0) {
                size--;
                current = queue.poll();
                for (int k = 0; k < R.length; k++) {
                    nR = current[0] + R[k];
                    nC = current[1] + C[k];
                    if (nR < 0 || nR == grid.length || nC < 0 ||
                        nC == grid[0].length || grid[nR][nC] != 1) {
                        sb.append(0);
                        continue;
                    }
                    if (grid[nR][nC] == 1) {
                        queue.add(new int[]{nR, nC});
                        grid[nR][nC] = 2;
                        sb.append(D[k]);
                    }
                }
            }
        }
        return sb.toString();
    }

    int countDistinctIslands(int[][] grid) {
        Set<String> distinct = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    distinct.add(layout(i, j, grid));
                }
            }
        }
        return distinct.size();
    }
}