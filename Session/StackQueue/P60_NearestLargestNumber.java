package Session.StackQueue;

import java.io.*;
import java.util.*;

public class P60_NearestLargestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] heights = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stc = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stc.isEmpty() && heights[stc.peek()] <= heights[i]) {
                stc.pop();
            }

            System.out.print((stc.isEmpty() ? -1 : heights[stc.peek()]) + " ");
            stc.push(i);
        }

    }
}