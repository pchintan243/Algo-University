package Session.BitManipulation;

import java.io.*;

public class P46_LongestConsecutiveOne {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int num = Integer.parseInt(br.readLine());
            int ones = 0;
            int ans = 0;
            while (num != 0) {
                if ((num & 1) == 1) {
                    ones++;
                } else {
                    ones = 0;
                }
                num = num >> 1;
                ans = Math.max(ans, ones);
            }
            System.out.println(ans);
        }

    }
}
