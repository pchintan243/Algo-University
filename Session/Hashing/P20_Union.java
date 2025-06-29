package Session.Hashing;

import java.io.*;
import java.util.*;

public class P20_Union {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
        }
        for (int num : set) {
            System.out.print(num + " ");
        }
    }
}