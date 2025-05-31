package Contest.Contest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P27_Candies {
    static boolean predicate(int[] arr, int m, int mid, int n) {
        long sum = 0;
        int cnt = 1;
        for(int i = 0; i < n; i++) {
            if(sum + arr[i] <= mid) {
                sum += arr[i];
            } else {
                cnt++;
                sum = arr[i];
            }
        }

        return cnt <= m;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int high = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            high += arr[i];
            max = Math.max(max, arr[i]);
        }
        if (n < m) {
            System.out.println(-1);
            return;
        }
        if (m == 1) {
            System.out.println(high);
            return;
        }
        if (n == m) {
            System.out.println(max);
            return;
        }
        int low = max;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (predicate(arr, m, mid, n)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
