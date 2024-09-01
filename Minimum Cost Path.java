// Given a square grid of size N, each cell of which contains an integer cost that represents a cost to traverse through that cell, we need to find a path from the top left cell to the bottom right cell by which the total cost incurred is minimum.
// From the cell (i,j) we can go (i,j-1), (i, j+1), (i-1, j), (i+1, j).  
// Examples :
// Input: grid = {{9,4,9,9},{6,7,6,4},{8,3,3,7},{7,4,9,10}}
// Output: 43
// Explanation: The grid is-
// 9 4 9 9
// 6 7 6 4
// 8 3 3 7
// 7 4 9 10
// The minimum cost is-
// 9 + 4 + 7 + 3 + 3 + 7 + 10 = 43.
// Input: grid = {{4,4},{3,7}}
// Output: 14
// Explanation: The grid is-
// 4 4
// 3 7
// The minimum cost is- 4 + 3 + 7 = 14.


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}


class Solution
{
      static class Cell implements Comparable<Cell> {
        int x, y, cost;
        
        Cell(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        
        public int compareTo(Cell other) {
            return this.cost - other.cost;
        }
    }

    public int minimumCostPath(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        pq.add(new Cell(0, 0, grid[0][0]));
        dist[0][0] = grid[0][0];

        // Directions array for moving up, down, left, and right.
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while (!pq.isEmpty()) {
            Cell current = pq.poll();
            int x = current.x;
            int y = current.y;
            int currentCost = current.cost;

            if (x == n - 1 && y == n - 1) return currentCost;

            for (int d = 0; d < 4; d++) {
                int newX = x + dx[d];
                int newY = y + dy[d];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                    int newCost = currentCost + grid[newX][newY];
                    if (newCost < dist[newX][newY]) {
                        dist[newX][newY] = newCost;
                        pq.add(new Cell(newX, newY, newCost));
                    }
                }
            }
        }
        return dist[n-1][n-1];
    }
}
