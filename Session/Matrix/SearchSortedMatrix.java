import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SearchSortedMatrix {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader
          (new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    
    if(n == 0 || m == 0) {
      System.out.print("NO");
      return;
    }
    
    int[][] mat = new int[n][m];
    for(int i = 0; i < n; i++) {
      StringTokenizer sb = new StringTokenizer(br.readLine());
      for(int j = 0; j < m; j++) {
        mat[i][j] = Integer.parseInt(sb.nextToken());
      }
    }

    boolean flag = true;
    for(int i = 0; i < n; i++) {
      if(mat[i][0] > k || mat[i][m - 1] < k) {
        continue;
      }
      for(int j = 0; j < m; j++) {
        if(mat[i][j] == k) {
          flag = false;
          System.out.print("YES");
          break;
        }
      }
      if(!flag) {
        break;
      }
    }
    
    if(flag) {
      System.out.print("NO");
    }

  }
}