import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RangeSearch {
  public static int findLowerBound(int[] nums, int low, int high, int k) {

    while(low <= high) {
      int mid = low + (high - low) / 2;
      if(nums[mid] >= k) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }
    
  public static int findUpperBound(int[] nums, int low, int high, int k) {
    int ans = high + 1;
    while(low <= high) {
      int mid = low + (high - low) / 2;
      if(nums[mid] > k) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return ans;
  }


  public static void main(String[] args)  throws IOException {
    
    BufferedReader br = new BufferedReader(
      new InputStreamReader(System.in));
      
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    int q = Integer.parseInt(st.nextToken());
    
    int[] nums = new int[n];
    
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(nums);
    for(int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int l = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());
      int lb = findLowerBound(nums, 0, n - 1, l);
      int ub = findUpperBound(nums, 0, n - 1, r);
      
      System.out.println(ub - lb + " ");
    }
  }
}