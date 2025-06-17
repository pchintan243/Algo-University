package Session.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16_Explosion {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] bombs = new int[n];
        for (int i = 0; i < n; i++) {
            bombs[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        Arrays.sort(bombs);
        for (int i = 0; i < n; i++) {
            int left = leftExplosives(bombs, i, n);
            int right = rightExplosives(bombs, i, n);
            ans = Math.max(ans, left + right + 1);
        }

        System.out.println(ans);
    }

    public static int leftExplosives(int[] bombs, int start, int n) {
        int last = start;
        int jump = 1;
        while (last >= 0 && last < n) {
            int next = last;

            while (next - 1 >= 0 && Math.abs(bombs[next - 1] - bombs[last]) <= jump) {
                next -= 1;
            }
            if (next == last)
                break;
            last = next;
            jump += 1;
        }

        return Math.abs(last - start);
    }

    public static int rightExplosives(int[] bombs, int start, int n) {

        int last = start;
        int jump = 1;
        while (last >= 0 && last < n) {
            int next = last;

            while (next + 1 < n && Math.abs(bombs[next + 1] - bombs[last]) <= jump) {
                next += 1;
            }
            if (next == last)
                break;
            last = next;
            jump += 1;
        }

        return Math.abs(last - start);
    }
}