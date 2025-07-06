package Session.BitManipulation;

import java.io.*;
import java.util.*;

public class P47_MaxAND {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, (arr[i - 1] & arr[i]));
        }
        System.out.println(ans);
    }
}
