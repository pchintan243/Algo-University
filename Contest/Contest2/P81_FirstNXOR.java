package Contest.Contest2;

import java.io.*;

public class P81_FirstNXOR {
    static long findXor(long n) {
        if (n % 4 == 0) {
            return n;
        } else if (n % 4 == 1) {
            return 1;
        } else if (n % 4 == 2) {
            return n + 1;
        } else {
            return 0;
        }
    }

    // Main method where the program execution begins
    public static void main(String[] args) throws IOException {
        // BufferedReader for faster input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());
            System.out.println(findXor(n));
        }
    }
}