import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P36_RowColSumEqual {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader
          (new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    
    if(n == 0) {
      System.out.print(0);
      return;
    }
    
    int[][] mat = new int[n][n];
    long[] row = new long[n];
    long[] col = new long[n];

    long target = 0;
    for(int i = 0; i < n; i++) {
      StringTokenizer sb = new StringTokenizer(br.readLine());
      for(int j = 0; j < n; j++) {
        mat[i][j] = Integer.parseInt(sb.nextToken());
        row[i] += mat[i][j];
        col[j] += mat[i][j];
        target = Math.max(target, row[i]);
        target = Math.max(target, col[j]);
      }
    }
    long ans = 0;
    for(int i = 0; i < n; i++) {
      ans += target - row[i];
    }
    System.out.println(ans);
  }
}