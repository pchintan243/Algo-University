import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P33_MatrixRotation {
  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(
      new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    
    if(n == 0)
      return;
    int[][] mat = new int[n][n];
    
    for(int i = 0; i < n; i++) {
      StringTokenizer sm = new StringTokenizer(br.readLine());
      for(int j = 0; j < n; j++) {
        mat[i][j] = Integer.parseInt(sm.nextToken());
      }
    }
    for(int i = 0; i < n; i++) {
      for(int j = i + 1; j < n; j++) {
          int temp = mat[i][j];
          mat[i][j] = mat[j][i];
          mat[j][i] = temp;
      }
    }
    
    for(int i = 0; i < n / 2; i++) {
        int[] temp = mat[i];
        mat[i] = mat[n - i - 1];
        mat[n - i - 1] = temp;
    }
    
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        System.out.print(mat[i][j] + " ");
      }
      System.out.println();
    }
    
    
  }
}