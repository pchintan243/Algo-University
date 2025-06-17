package Session.TwoPointers;

import java.io.*;
import java.util.*;

public class P67_Points {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long d = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        long ans = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j < n && a[j] - a[i] <= d) {
                j++;
            }

            long count = j - i - 1;
            if (count >= 2) {
                // number of triplets = C(count, 2) = count * (count - 1) / 2
                ans += count * (count - 1) / 2;
            } else if (j == n) {
                break;
            }
        }

        System.out.println(ans);
    }
}
