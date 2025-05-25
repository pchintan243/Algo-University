package MinMaxHard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxCandies {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
      new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());
    
    if(n == 0) {
      System.out.println(0);
      return;
    }
    
    long low = 0;
    long high = (long) Math.sqrt(2*n);
    long ans = 0;
    
    while(low <= high) {
      long mid = low + (high - low) / 2;
      
      long candies = (mid * (mid + 1L)) / 2;
      if(candies <= n) {
        low = mid + 1;
        ans = mid;
      } else {
        high = mid - 1;
      }
    }
    
    System.out.println(ans);

  }
}