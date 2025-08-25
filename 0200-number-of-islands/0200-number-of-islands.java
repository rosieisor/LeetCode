class Solution {

    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int result = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs(i, j, grid, visited);
                    result++;
                }
            }
        }

        return result;    
    }

    void bfs(int x, int y, char[][] grid, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int i=0; i<move.length; i++) {
                int mx = current[0] + move[i][0];
                int my = current[1] + move[i][1];

                if (mx < grid.length && my < grid[0].length && mx > -1 && my > -1 && grid[mx][my] == '1' && !visited[mx][my]) {
                    queue.offer(new int[]{mx, my});
                    visited[mx][my] = true;
                }
            }
        }
    }
}