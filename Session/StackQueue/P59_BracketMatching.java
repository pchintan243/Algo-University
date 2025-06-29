package Session.StackQueue;

import java.io.*;
import java.util.*;

public class P59_BracketMatching {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int n = s.length();
        char[] ch = s.toCharArray();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stc = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (ch[i] == '(') {
                stc.push(i);
            } else {
                if (!stc.isEmpty()) {
                    int ind = stc.pop();
                    ans[ind] = i;
                    ans[i] = ind;
                }
            }
        }

        for (int ind : ans) {
            System.out.print(ind + " ");
        }
    }
}