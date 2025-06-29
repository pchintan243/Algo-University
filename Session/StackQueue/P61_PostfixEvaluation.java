package Session.StackQueue;

import java.io.*;
import java.util.*;

public class P61_PostfixEvaluation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        s = s.replaceAll("\\s+", "");

        char[] ch = s.toCharArray();
        Stack<Integer> st = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (ch[i] >= 48 && ch[i] <= 57) {
                st.push((int) ch[i] - 48);
            } else {
                int firstNum = st.pop();
                int secondNum = st.pop();
                if (ch[i] == '+') {
                    st.push(firstNum + secondNum);
                } else if (ch[i] == '-') {
                    st.push(secondNum - firstNum);
                } else if (ch[i] == '*') {
                    st.push(firstNum * secondNum);
                } else {
                    st.push(secondNum / firstNum);
                }
            }
        }

        System.out.println(st.pop());

    }
}
