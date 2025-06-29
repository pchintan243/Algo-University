package Session.Hashing;

import java.io.*;
import java.util.*;

public class P22_ZeroSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if (nums[i] == 0) {
                System.out.println("YES");
                return;
            }
        }
        long prefixSum = 0;

        HashSet<Long> seenSums = new HashSet<>();
        for (int num : nums) {
            prefixSum += num;

            // Case 1: prefix sum is 0 (subarray from start sums to 0)
            if (prefixSum == 0) {
                System.out.println("YES");
                return;
            }

            // Case 2: we've seen this prefix sum before
            if (seenSums.contains(prefixSum)) {
                System.out.println("YES");
                return;
            }

            seenSums.add(prefixSum);
        }

        System.out.println("NO");
    }
}