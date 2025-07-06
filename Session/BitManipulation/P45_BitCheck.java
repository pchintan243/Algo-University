package Session.BitManipulation;

import java.io.*;
import java.util.*;

public class P45_BitCheck {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int ind = Integer.parseInt(st.nextToken());

        num = num >> ind;

        System.out.print(num & 1);
    }
}
