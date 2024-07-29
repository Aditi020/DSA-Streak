// Consider a rat placed at (0, 0) in a square matrix mat of order n* n. It has to reach the destination at (n - 1, n - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
// Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell. In case of no path, return an empty list. The driver will output "-1" automatically.

// Examples:

// Input: mat[][] = [[1, 0, 0, 0],
//                 [1, 1, 0, 1], 
//                 [1, 1, 0, 0],
//                 [0, 1, 1, 1]]
// Output: DDRDRR DRDDRR
// Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.
// Input: mat[][] = [[1, 0],
//                 [1, 0]]
// Output: -1
// Explanation: No path exists and destination cell is blocked.

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (String path : res) System.out.print(path + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> paths = new ArrayList<>();
        
        // Check if the starting or ending cell is blocked
        if (mat[0][0] == 0 || mat[mat.length - 1][mat.length - 1] == 0) {
            return paths;
        }

        boolean[][] visited = new boolean[mat.length][mat.length];
        findPaths(mat, 0, 0, "", visited, paths);
        return paths;
    }

    private void findPaths(int[][] mat, int i, int j, String path, boolean[][] visited, ArrayList<String> paths) {
        int n = mat.length;

        // If we reach the destination, add the path to the list
        if (i == n - 1 && j == n - 1) {
            paths.add(path);
            return;
        }

        // Mark the cell as visited
        visited[i][j] = true;

        // Possible movements: Down, Left, Right, Up
        int[] rowMove = {1, 0, 0, -1};
        int[] colMove = {0, -1, 1, 0};
        char[] move = {'D', 'L', 'R', 'U'};

        // Explore all possible directions
        for (int k = 0; k < 4; k++) {
            int nextRow = i + rowMove[k];
            int nextCol = j + colMove[k];

            // Check if the next move is safe
            if (isSafe(nextRow, nextCol, mat, visited)) {
                findPaths(mat, nextRow, nextCol, path + move[k], visited, paths);
            }
        }

        // Unmark the cell (backtrack)
        visited[i][j] = false;
    }

    private boolean isSafe(int i, int j, int[][] mat, boolean[][] visited) {
        int n = mat.length;
        return i >= 0 && i < n && j >= 0 && j < n && mat[i][j] == 1 && !visited[i][j];
    }
}
