package Session.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P15_CowArrival {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        long[][] cow = new long[t][2];

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cow[i][0] = Integer.parseInt(st.nextToken());
            cow[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cow, Comparator.comparingLong(a -> a[0]));

        long ans = 0;
        for (int i = 0; i < t; i++) {
            long arrivalTime = cow[i][0];
            long healthCheckTime = cow[i][1];
            if(ans < arrivalTime) {
                ans += arrivalTime - ans + healthCheckTime;
            } else {
                ans += healthCheckTime;
            }
        }
        System.out.println(ans);
    }
}