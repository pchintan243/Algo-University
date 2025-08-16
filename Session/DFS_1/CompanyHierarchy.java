package Session.DFS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CompanyHierarchy  {

    static int dfs(List<List<Integer>> employee, int emp, int[] boss) {
        for(int i: employee.get(emp)) {
            boss[emp] +=  1 + dfs(employee, i, boss);
        }
        return boss[emp];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] boss = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 1; i < n; i++) {
            int curr = Integer.parseInt(st.nextToken()) - 1;
            adj.get(curr).add(i);
        }

        dfs(adj, 0, boss);

        for(int i : boss) {
            System.out.print(i + " ");
        }

    }
}