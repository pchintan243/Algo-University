package Contest.Contest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FlowerPots {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] diff = new int[n + 2];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            diff[l] += 1;
            if (r + 1 <= n) {
                diff[r + 1] -= 1;
            }
        }

        int[] waterFilled = new int[n + 1];
        waterFilled[0] = diff[0];
        for (int i = 1; i <= n; i++) {
            waterFilled[i] = waterFilled[i - 1] + diff[i];
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(waterFilled[i] + " ");
        }
    }

}

