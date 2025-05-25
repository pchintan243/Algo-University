package Advance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P7_SphinxRangeSums {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
      new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] nums = new int[n];
    
    for(int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }
    long[] sum = new long[n];
    sum[0] = nums[0];
    for(int i = 1; i < n; i++) {
      sum[i] += sum[i - 1] + nums[i];
    }
    int q = Integer.parseInt(br.readLine());
    
    for(int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int first = Integer.parseInt(st.nextToken()) - 2;
      int second = Integer.parseInt(st.nextToken()) - 1;
      if(first >= 0) {
        System.out.println(sum[second] - sum[first]);
      } else {
        System.out.println(sum[second]);
      }
    }
  }
}
