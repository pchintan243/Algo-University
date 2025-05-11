import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SearchSortedMat {
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
    int q = Integer.parseInt(st.nextToken());
    
    int[][] mat = new int[n][m];
    
    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < m; j++) {
        mat[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < q; i++) {
      int k = Integer.parseInt(st.nextToken());
      for(int j = 0; j < n; j++) {
        if(mat[j][m - 1] >= k) {
          System.out.println(j + " " + binarySearch(mat[j], 0, m - 1, k));
          break;
        }
      }
    }

  }
}