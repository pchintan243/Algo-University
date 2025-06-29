package Session.StackQueue;

import java.io.*;
import java.util.*;

public class P62_MaxRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] heights = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        long maxArea = 0; // Use long for area to prevent overflow

        // Use a stack to store indices of bars in increasing order of height
        Stack<Integer> stack = new Stack<>();

        // Iterate through all bars, including processing for a virtual bar of height 0 at the end
        // This virtual bar ensures all elements remaining in the stack are processed.
        // We iterate up to and including 'n' to trigger the final pops.
        for (int i = 0; i <= n; i++) {
            // Determine the height to compare against.
            // If i == n, we use a virtual height of 0 to clear the stack.
            // Otherwise, we use the actual height from the array.
            int currentHeight = (i == n) ? 0 : heights[i];

            // While the stack is not empty AND the current height is shorter than the bar at stack's top
            // This means we've found the right boundary for the bar at stack.peek()
            while (!stack.isEmpty() && heights[stack.peek()] >= currentHeight) {
                int hIndex = stack.pop(); // Index of the bar whose area we are calculating
                long height = heights[hIndex];

                // Calculate width:
                // If the stack is empty after popping, it means 'height' is the smallest bar from index 0 up to 'i-1'.
                // So, its left boundary is effectively at -1, and its width is 'i'.
                // Otherwise, the element now at 'stack.peek()' is the first bar to the left that is shorter than 'height'.
                // The width is then 'current_index (i) - stack.peek() - 1'.
                long width = stack.isEmpty() ? i : (long) i - stack.peek() - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            // Only push valid indices (0 to n-1) onto the stack.
            // When i == n, we just use it to clear the stack, not to push an invalid index.
            if (i < n) {
                stack.push(i);
            }
        }

        System.out.println(maxArea);
    }
}