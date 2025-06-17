package Session.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P71_SubSetSum {

    static void subsetSum(int[] nums, int ind, int n, long sum1, long sum2, long[] ans) {
        if(ind == n) {
            ans[0] = Math.min(Math.abs(sum2 - sum1), ans[0]);
            return;
        }
        subsetSum(nums, ind + 1, n, sum1 + nums[ind], sum2, ans);
        subsetSum(nums, ind + 1, n, sum1, sum2 + nums[ind], ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        long[] ans = new long[1];
        ans[0] = Integer.MAX_VALUE;
        subsetSum(nums, 0, n, 0, 0, ans);
        System.out.println(ans[0]);
    }
}
