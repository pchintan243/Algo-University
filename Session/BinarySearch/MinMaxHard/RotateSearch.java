package MinMaxHard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class RotateSearch {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
      new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    
    int low = 0;
    int high = n - 1;
    
    int[] arr = new int[n];
    if (n == 0) {
      System.out.println(-1);
      return;
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int ans = Integer.MAX_VALUE;
    while(low <= high) {
      
      if(arr[low] <= arr[high]) {
        // Whole segment is sorted, take the min
        ans = Math.min(ans, arr[low]);
        break;
      }
      
      int mid = low + (high - low) / 2;
      if(arr[low] <= arr[mid]) {
        ans = Math.min(ans, arr[low]);
        low = mid + 1;
      } else {
        ans = Math.min(ans, arr[mid]);
        high = mid - 1;
      }
    
    }
    
    System.out.println(ans);
  }
}