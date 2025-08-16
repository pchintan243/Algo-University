package Session.DFS_1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P75_RedAlert {
    static int leafCount = 0;

    static void dfs(List<List<Integer>> adj, int u, int parent, int consRed, int[] color, int c) {
        if (consRed > c) {
            return;
        }
        if (adj.get(u).size() == 1 && u != 0) {
            leafCount++;
            return;
        }

        for (int v : adj.get(u)) {
            if (v != parent) {
                int nextRedCount = color[v] == 1 ? consRed + 1 : 0;
                dfs(adj, v, u, nextRedCount, color, c);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (n == 1) {
            System.out.println(1);
            return;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] color = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            color[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;
            adj.get(first).add(second);
            adj.get(second).add(first);
        }
        if (color[0] == 1)
            dfs(adj, 0, -1, 1, color, c);
        else
            dfs(adj, 0, -1, 0, color, c);

        System.out.print(leafCount);
    }
}