package Contest.Contest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PrimeCycles {
    static List<Integer> primeNums = List.of(2, 3, 5, 7, 11, 13, 17);

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static boolean isCycle(int[] arr) {
        int n = arr.length;
        if (!primeNums.contains(arr[0] + arr[n - 1])) {
            return false;
        }
        for (int i = 1; i < n; i++) {
            if (!primeNums.contains(arr[i] + arr[i - 1])) {
                return false;
            }
        }

        return true;
    }

    static void permutation(int ind, int[] arr, int[] ans) {
        int n = arr.length;
        if (n == ind) {
            if (isCycle(arr)) {
                ans[0]++;
            }
            return;
        }

        for (int i = ind; i < n; i++) {
            swap(arr, i, ind);
            permutation(ind + 1, arr, ans);
            swap(arr, i, ind);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        int[] ans = new int[1];
        permutation(0, nums, ans);

        System.out.print(ans[0] / n);
    }
}