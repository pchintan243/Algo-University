package Session.Hashing;

import java.io.*;
import java.util.*;

public class P21_UniqueWindow {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] freq = new int[101];

        int[] nums = new int[n];
        int ind = 0;
        int uniqueCount = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if (freq[nums[i]] == 0) {
                uniqueCount++;
            }
            freq[nums[i]]++;
            if (i > k - 2) {
                System.out.print(uniqueCount + " ");
                if (freq[nums[ind]] == 1) {
                    uniqueCount--;
                }
                freq[nums[ind]]--;
                ind++;
            }
        }
    }
}
