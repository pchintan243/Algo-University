package Session.Hashing;

import java.io.*;
import java.util.*;

public class P23_FrequencySort {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // Step 1: Frequency Map using Hashing
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Get unique elements from map
        List<Integer> uniqueNums = new ArrayList<>(freqMap.keySet());

        // Step 3: Sort by frequency descending, value ascending
        uniqueNums.sort((a, b) -> {
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);
            if (freqA != freqB) {
                return freqB - freqA;
            } else {
                return a - b;
            }
        });

        // Step 4: Print elements by frequency
        for (int num : uniqueNums) {
            int freq = freqMap.get(num);
            for (int i = 0; i < freq; i++) {
                System.out.print(num + " ");
            }
        }
    }
}
