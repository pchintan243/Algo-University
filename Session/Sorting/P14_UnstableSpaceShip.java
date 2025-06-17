package Session.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14_UnstableSpaceShip {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        int[] heights = new int[x * 2];
        int ind = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < x * 2; i++) {
            heights[ind++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(heights);
        System.out.println(minUnstability(heights, x));
    }

    public static int minUnstability(int[] heights, int x) {
        int n = x * 2;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = 0;
                boolean flag = true;
                for (int k = 0; k < n; k++) {
                    if (i != k && j != k) {
                        if (flag)
                            temp -= heights[k];
                        else
                            temp += heights[k];
                        flag = !flag;
                    }
                }
                ans = Math.min(ans, temp);
            }
        }
        return ans;
    }
}