package Contest.Contest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class UnfairMultiverse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        long totalUnfairness = calculateTotalUnfairness(A, N);
        System.out.println(totalUnfairness);
    }

    public static long calculateTotalUnfairness(int[] A, int N) {
        long sumOfMax = 0;
        long sumOfMin = 0;

        // Arrays to store indices of Nearest Greater/Smaller Elements
        int[] L_max = new int[N]; // Nearest Greater Element to the Left
        int[] R_max = new int[N]; // Nearest Greater or Equal Element to the Right (for duplicates)
        int[] L_min = new int[N]; // Nearest Smaller Element to the Left
        int[] R_min = new int[N]; // Nearest Smaller or Equal Element to the Right (for duplicates)

        Stack<Integer> stack = new Stack<>();

        // 1. Calculate L_max (Nearest Greater Element to the Left)
        // For A[k] to be max, elements to its left must be <= A[k].
        // So we look for the first element > A[k] to the left.
        // If multiple equal elements, consider the leftmost one as the "primary" max to avoid overcounting.
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) { // For strictly greater, use < A[i]
                stack.pop();
            }
            L_max[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();

        // 2. Calculate R_max (Nearest Greater or Equal Element to the Right)
        // For A[k] to be max, elements to its right must be < A[k].
        // So we look for the first element >= A[k] to the right.
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) { // For strictly greater or equal, use <= A[i]
                stack.pop();
            }
            R_max[i] = stack.isEmpty() ? N : stack.peek();
            stack.push(i);
        }
        stack.clear();

        // 3. Calculate L_min (Nearest Smaller Element to the Left)
        // For A[k] to be min, elements to its left must be >= A[k].
        // So we look for the first element < A[k] to the left.
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) { // For strictly smaller, use > A[i]
                stack.pop();
            }
            L_min[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();

        // 4. Calculate R_min (Nearest Smaller or Equal Element to the Right)
        // For A[k] to be min, elements to its right must be > A[k].
        // So we look for the first element <= A[k] to the right.
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) { // For strictly smaller or equal, use >= A[i]
                stack.pop();
            }
            R_min[i] = stack.isEmpty() ? N : stack.peek();
            stack.push(i);
        }

        // 5. Calculate total sum of unfairness
        for (int i = 0; i < N; i++) {
            // Number of subarrays where A[i] is the maximum
            long countMaxSubarrays = (long) (i - L_max[i]) * (R_max[i] - i);
            sumOfMax += (long) A[i] * countMaxSubarrays;

            // Number of subarrays where A[i] is the minimum
            long countMinSubarrays = (long) (i - L_min[i]) * (R_min[i] - i);
            sumOfMin += (long) A[i] * countMinSubarrays;
        }

        return sumOfMax - sumOfMin;
    }
}