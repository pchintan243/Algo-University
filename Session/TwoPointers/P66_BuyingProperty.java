package Session.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P66_BuyingProperty {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] a = new long[n];
        long sum = 0;
        for(int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
            sum += a[i];
        }

        if(sum < k) {
            System.out.println(-1);
            return;
        }
        if(sum == k) {
            System.out.println(n);
            return;
        }

        int ans = Integer.MAX_VALUE;
        int i = 0;
        long acre = 0;
        for (int j = 0; j < n; j++) {
            acre += a[j];

            // Shrink from left while still >= k
            while (acre >= k) {
                ans = Math.min(ans, j - i + 1);
                acre -= a[i++];
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}