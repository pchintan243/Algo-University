package Session.Hashing;

import java.io.*;
import java.util.*;

public class P24_Consecutiveness {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }


        int prevNum = 0;
        int ans = 0;
        int tempCnt = 0;
        for (int num : set) {
            if (prevNum + 1 == num) {
                tempCnt++;
            } else {
                tempCnt = 1;
            }
            prevNum = num;
            ans = Math.max(ans, tempCnt);
        }

        System.out.println(ans);
    }
}