package Session.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P70_PermutationString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String s = br.readLine();

        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        boolean[] used = new boolean[s.length()];
        makePairs(ch, used, new StringBuilder(), s.length());
    }

    public static void makePairs(char[] ch, boolean[] used, StringBuilder res, int n) {
        if(res.length() == n) {
            System.out.println(res);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(used[i])
                continue;
            if(i > 0 && !used[i - 1] && ch[i] == ch[i - 1])
                continue;
            res.append(ch[i]);
            used[i] = true;
            makePairs(ch, used, res, n);

            res.deleteCharAt(res.length() - 1);
            used[i] = false;
        }
    }
}