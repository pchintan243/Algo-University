package MinMaxHard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Transport {
    static boolean isEmptyPiles(long[] arr, int n, int m, int c, long mid) {
        for(int i = 0; i < n; i++) {
            long temp = arr[i];
            i++;
            int storeC = c - 1;
            m--;
            while(storeC != 0) {
                if(i < n && arr[i] - temp > mid) {
                    break;
                }
                i++;
                storeC--;
            }
            i--;
        }

        return m >= 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader
                (new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());

        long low = 0;
        long high = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            high = Math.max(arr[i], high);
        }
        Arrays.sort(arr);

        long ans = -1;

        while(low <= high) {
            long mid = low + (high - low) / 2;

            if(isEmptyPiles(arr, n, m, c, mid)) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(ans);

    }
}
