package Contest.Contest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P39_EqualZeroOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if (A[i] == 0) {
                A[i] = -1;
            }
        }

        long count = countSubarrays(A, N);
        System.out.println(count);
    }

    public static long countSubarrays(int[] A, int N) {
        long totalCount = 0;
        int currentSum = 0;
        Map<Integer, Integer> sumCounts = new HashMap<>();

        sumCounts.put(0, 1);

        for (int i = 0; i < N; i++) {
            currentSum += A[i];

            if (sumCounts.containsKey(currentSum)) {
                totalCount += sumCounts.get(currentSum);
            }

            sumCounts.put(currentSum, sumCounts.getOrDefault(currentSum, 0) + 1);
        }

        return totalCount;
    }
}