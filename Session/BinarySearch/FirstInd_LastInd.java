import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FirstInd_LastInd {
  
  public static int findFirstInd(int[] nums, int low, int high, int k) {
    int ans = -1;
    while(low <= high) {
      int mid = low + (high - low) / 2;
      if(nums[mid] == k) {
        high = mid -1;
        ans = mid;
      } else if(nums[mid] > k) {
        high = mid -1;
      } else {
        low = mid + 1;
      }
    }
    
    return ans;
  }
  
  public static int findLastInd(int[] nums, int low, int high, int k) {
    int ans = -1;
    while(low <= high) {
      int mid = low + (high - low) / 2;
      if(nums[mid] == k) {
        ans = mid;
        low = mid + 1;
      } else if(nums[mid] < k) {
        low = mid + 1;
      } else {
        high = mid -1;
      }
    }
    
    return ans;
  }
  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(
      new InputStreamReader(System.in));
      
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    int q = Integer.parseInt(st.nextToken());
    
    st = new StringTokenizer(br.readLine());
    int[] nums = new int[n];
    
    for(int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }
    
    while(q != 0) {
      q--;
      int k = Integer.parseInt(br.readLine());
      
      int firstInd = findFirstInd(nums, 0, n - 1, k);
      if(firstInd == -1) {
        System.out.println(-1 + " " + -1);
        continue;
      }
      int lastInd = findLastInd(nums, 0, n - 1, k);
      System.out.println(firstInd + " " + lastInd);
    }

  }
}