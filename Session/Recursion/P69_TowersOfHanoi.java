package Session.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P69_TowersOfHanoi {

    static void towerOfHanoi(int n, int from, int to, int aux) {
        if(n == 0) {
            return;
        }
        towerOfHanoi(n - 1, from, aux, to);
        System.out.println(n + " " + from + " " + to);
        towerOfHanoi(n - 1, aux, to, from);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println((1 << n) - 1);
        towerOfHanoi(n, 1, 2, 3);

    }
}
