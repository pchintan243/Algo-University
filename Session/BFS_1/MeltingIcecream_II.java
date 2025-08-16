package Session.BFS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MeltingIcecream_II {
    static boolean isOutOfBoundary(int i, int j, int n, int m) {
        return i < 0 || j < 0 || i >= n || j >= m;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int xCoOrdinate = Integer.parseInt(st.nextToken());
        int yCoOrdinate = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());

        char[][] grid = new char[xCoOrdinate][yCoOrdinate];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < xCoOrdinate; i++) {
            String s = br.readLine();
            for(int j = 0; j < yCoOrdinate; j++) {
                grid[i][j] = s.charAt(j);
                if(grid[i][j] == 'i') {
                    q.offer(new int[]{i, j});
                }
            }
        }

        boolean[][] isVisited = new boolean[xCoOrdinate][yCoOrdinate];
        int[] delRow = new int[]{-1, 0, 0, 1};
        int[] delCol = new int[]{0, -1, 1, 0};

        while(!q.isEmpty()) {
            if (time == 0) {
                System.out.print("NO");
                return;
            }
            time--;
            int qSize = q.size();
            for(int qs = 0; qs < qSize; qs++) {
                int[] val = q.poll();
                int sr = val[0];
                int sc = val[1];
                for (int k = 0; k < 4; k++) {
                    int row = sr + delRow[k];
                    int col = sc + delCol[k];
                    if (!isOutOfBoundary(row, col, xCoOrdinate, yCoOrdinate) && !isVisited[row][col]) {
                        if (grid[row][col] == 'h') {
                            System.out.print("YES");
                            return;
                        }
                        if (grid[row][col] == '*') {
                            isVisited[row][col] = true;
                            q.offer(new int[]{row, col});
                        }
                    }
                }
            }
        }

        System.out.print("NO");

    }
}
