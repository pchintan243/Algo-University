package Session.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P63_MergeArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] b = new int[m];
        for(int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[n + m];
        int ind = 0;
        int i = 0;
        int j = 0;
        while(i < n && j < m) {
            if(a[i] < b[j]) {
                ans[ind++] = a[i++];
            } else {
                ans[ind++] = b[j++];
            }
        }
        while(i < n) {
            ans[ind++] = a[i++];
        }
        while(j < m) {
            ans[ind++] = b[j++];
        }

        for(i = 0; i < n + m; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}