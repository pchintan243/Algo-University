package Contest.Contest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RiverHunting {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int q = Integer.parseInt(br.readLine());
        while(q != 0) {
            int n = Integer.parseInt(br.readLine());
            int ans = (int) Math.ceil((Math.log(n) / Math.log(2)));
            System.out.println(ans);
            q--;
        }

    }
}