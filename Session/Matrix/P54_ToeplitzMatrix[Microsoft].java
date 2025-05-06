import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P54_ToeplitzMatrix[Microsoft] {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader
          (new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    
    if(n == 0 || m == 0) {
      System.out.print(1);
      return;
    }
    
    if(n == 1 || m == 1) {
      System.out.print(1);
      return;
    }
    
    int[][] mat = new int[n][m];
    for(int i = 0; i < n; i++) {
      StringTokenizer sb = new StringTokenizer(br.readLine());
      for(int j = 0; j < m; j++) {
        mat[i][j] = Integer.parseInt(sb.nextToken());
      }
    }

    // for(int i = 0; i < n; i++) {
    //   for(int j = 0; j < m; j++) {
    //     System.out.print(mat[i][j] + " ");
    //   }
    // }
    // System.out.print(n + " " + m);
    boolean flag = true;
    for(int i = 1; i < n; i++) {
      for(int j = i; j < m; j++) {
        if(mat[i][j] != mat[i - 1][j - 1]) {
          flag = false;
          System.out.print(0);
          break;
        }
      }
      if(!flag) {
        break;
      }
      for(int j = 1; j < i; j++) {
        if(mat[i][j] != mat[i - 1][j - 1]) {
          flag = false;
          System.out.print(0);
          break;
        }
      }
      if(!flag) {
        break;
      }
    }
    
    if(flag) {
      System.out.print(1);
    }
    
  }
}