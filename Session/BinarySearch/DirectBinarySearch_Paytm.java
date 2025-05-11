import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DirectBinarySearch_Paytm {
  
  public static int binarySearch(int[] nums, int low, int high, int k) {
    while(low <= high) {
      int mid = low + (high - low) / 2;
      if(nums[mid] == k) {
        return mid;
      } else if(nums[mid] < k) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    
    return -1;
  }
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(
      new InputStreamReader(System.in));
      
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    
    int[] nums = new int[n];
    int[] queries = new int[m];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < m; i++) {
      queries[i] = Integer.parseInt(st.nextToken());
    }

    for(int i = 0; i < m; i++) {
      System.out.println(binarySearch(nums, 0, n - 1, queries[i]));
    }
  }
}