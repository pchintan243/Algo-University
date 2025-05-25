package MinMaxHard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EmptyThePiles {
    static boolean isEmptyPiles(long[] arr, long h, long mid) {
    long cnt = 0;
    for(int i = 0; i < arr.length; i++) {
      cnt += (long) Math.ceil((double) arr[i] / mid);
    }
    return cnt <= h;
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader
          (new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    long h = Long.parseLong(st.nextToken());
    long[] arr = new long[n];
    st = new StringTokenizer(br.readLine());
    
    long low = 1;
    long high = 0;
    for(int i = 0; i < n; i++) {
      arr[i] = Long.parseLong(st.nextToken());
      high = Math.max(arr[i], high);
    }
    
    long ans = -1;
    
    while(low <= high) {
      long mid = low + (high - low) / 2;
      
      if(isEmptyPiles(arr, h, mid)) {
        high = mid - 1;
        ans = mid;
      } else {
        low = mid + 1;
      }
    }
    
    System.out.println(ans);

  }
}
