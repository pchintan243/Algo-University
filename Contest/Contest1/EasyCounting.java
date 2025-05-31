package Contest.Contest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

public class EasyCounting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String s = br.readLine();

        Map<Character, Long> mp = new HashMap<>();

        for(char ch : s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0L) + 1);
        }

        long ans = 0;

        for (Map.Entry<Character, Long> entry : mp.entrySet()) {
            long value = entry.getValue();
            ans += (value * value);
        }

        System.out.println(ans);
    }
}
