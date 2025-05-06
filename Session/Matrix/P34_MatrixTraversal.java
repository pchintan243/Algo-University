import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P34_MatrixTraversal {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader
          (new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    
    if(n == 0 || m == 0) {
      return;
    }
    
    int[][] mat = new int[n][m];
    for(int i = 0; i < n; i++) {
      StringTokenizer sb = new StringTokenizer(br.readLine());
      for(int j = 0; j < m; j++) {
        mat[i][j] = Integer.parseInt(sb.nextToken());
      }
    }
    
    int top = 0;
    int bottom = n - 1;
    int left = 0;
    int right = m - 1;
    
    while(top <= bottom && left <= right) {
      for(int j = left; j <= right; j++) {
        System.out.print(mat[top][j] + " ");
      }
      top++;
      for(int j = top; j <= bottom; j++) {
        System.out.print(mat[j][right] + " ");
      }
      right--;
      if(top <= bottom) {
        for(int j = right; j >= left; j--) {
          System.out.print(mat[bottom][j] + " ");
        }
        bottom--;
      }
      if(left <= right) {
        for(int j = bottom; j >= top; j--) {
          System.out.print(mat[j][left] + " ");
        }
        left++;
      }
    }
  }
}