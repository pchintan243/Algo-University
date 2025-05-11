import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SortedBinaryArray {
  public static int findFirstOne(int[] nums, int low, int high) {
    int ans = high + 1;
    while(low <= high) {
      int mid = (low + high) >> 1;
      
      if(nums[mid] == 1) {
        high = mid - 1;
        ans = mid;
      } else {
        low = mid + 1;
      }
    }
    
    return ans;
  }
  
  
  public static int findLastZero(int[] nums, int low, int high) {
    int ans = -1;
    while(low <= high) {
      int mid = (low + high) >> 1;
      
      if(nums[mid] == 0) {
        low = mid + 1;
        ans = mid;
      } else {
        high = mid - 1;
      }
    }
    
    return ans;
  }
  
  
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader
          (new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    int[] nums = new int[n];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }
    int firstOne = findFirstOne(nums, 0, n - 1);
    int lastZero = findLastZero(nums, 0, n - 1);
    System.out.print(firstOne + " " + lastZero);

  }
}