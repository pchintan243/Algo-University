package Contest.Contest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class DoublingAmoeba {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                ans++;
                n--;
            } else {
                n /= 2;
            }
        }
        System.out.println(ans);
    }
}