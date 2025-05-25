package MinMaxHard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Corona {

    // Checks if it's possible to place 'n' people with at least 'mid' distance between them
    static boolean canPlacePeople(long[][] islands, int n, int m, long mid) {
        long count = 0;           // Total people placed
        long lastPlaced = Long.MIN_VALUE; // Last placed person's position

        for (int i = 0; i < m; i++) {
            long start = islands[i][0];
            long end = islands[i][1];

            // Find the first position we can place a person on this island
            long position = Math.max(lastPlaced + mid, start);

            // If we can't place even one person on this island, skip it
            if (position > end) continue;

            // Number of people we can place on this island at 'mid' distance
            long peopleHere = (end - position) / mid + 1;
            count += peopleHere;

            // Update the last placed position
            lastPlaced = position + (peopleHere - 1) * mid;
        }

        return count >= n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        // Read n = number of people, m = number of islands
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] islands = new long[m][2]; // Each island has [start, end] positions

        long low = 1;  // Minimum possible distance (can't be 0)
        long high = 0; // Used to define upper bound for binary search

        // Read the start and end coordinates of each island
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            islands[i][0] = Long.parseLong(st.nextToken());
            islands[i][1] = Long.parseLong(st.nextToken());
            high = Math.max(high, islands[i][1]);
        }

        // Sort islands by starting position
        Arrays.sort(islands, (a, b) -> Long.compare(a[0], b[0]));

        long answer = -1;

        // Binary search to find the largest minimum distance possible
        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canPlacePeople(islands, n, m, mid)) {
                answer = mid;     // Possible, try larger distance
                low = mid + 1;
            } else {
                high = mid - 1;   // Too large, try smaller distance
            }
        }

        // Output the maximum possible minimum distance
        System.out.println(answer);
    }
}