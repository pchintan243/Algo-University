package MinMaxHard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BoxPacking {

    // Checks if 'n' boxes of size w * h can fit into a square of size mid * mid
    static boolean canPlaceBoxes(long w, long h, long n, long mid) {
        long widthBoxCnt = mid / w;   // Boxes can fit horizontally
        long heightBoxCnt = mid / h;  // Boxes can fit vertically

        // If even one dimension can't fit a box, return false
        if (widthBoxCnt == 0 || heightBoxCnt == 0) return false;

        // Instead of multiplying widthBoxCnt * heightBoxCnt (which might overflow),
        // Check if the required rows can be fit vertically
        // Equivalent to: (widthBoxCnt * heightBoxCnt) >= n
        // It's Ceiling of (a / b) === (a + b - 1) / b
        return heightBoxCnt >= (n + widthBoxCnt - 1) / widthBoxCnt;
    }

    // Performs binary search to find the minimum square side length to fit all boxes
    static void binarySearch(long[] boxes) {
        long w = boxes[0], h = boxes[1], n = boxes[2];
        long low = 1;

        // Set a safe upper bound for side length:
        // In worst case, we might need n boxes in a line (either horizontally or vertically)
        long high = Math.max(w, h) * n;
        long answer = -1;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            // Check if we can fit all boxes in a mid * mid square
            if (canPlaceBoxes(w, h, n, mid)) {
                answer = mid;
                high = mid - 1; // try smaller side
            } else {
                low = mid + 1; // need bigger side
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // number of test cases

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] boxes = new long[3];

            // Read box width, height, and number of boxes
            for (int j = 0; j < 3; j++) {
                boxes[j] = Long.parseLong(st.nextToken());
            }

            binarySearch(boxes);
        }
    }
}
