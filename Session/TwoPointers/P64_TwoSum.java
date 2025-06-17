package Session.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P64_TwoSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        long ans = 0;
        int i = 0;
        int j = n - 1;
        while(i < j) {
            if(a[i] + a[j] == k) {
                System.out.print(1);
                return;
            } else if(a[i] + a[j] < k) {
                i++;
            } else {
                j--;
            }
        }
        System.out.print(0);
    }
}