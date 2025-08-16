package Session.DFS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MostProfitableTeam {
    static int highestProfit = Integer.MIN_VALUE;

    static int dfs(List<List<Integer>> employee, int emp, int[] profitLoss) {
        if (employee.get(emp).isEmpty()) {
            highestProfit = Math.max(profitLoss[emp], highestProfit);
            return profitLoss[emp];
        }
        int current = profitLoss[emp];
        for (int i : employee.get(emp)) {
            current += dfs(employee, i, profitLoss);
        }
        highestProfit = Math.max(current, highestProfit);
        return current;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            int curr = Integer.parseInt(st.nextToken()) - 1;
            adj.get(curr).add(i);
        }

        int[] profitLoss = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            profitLoss[i] = Integer.parseInt(st.nextToken());
        }

        dfs(adj, 0, profitLoss);
        System.out.print(highestProfit);

    }
}
