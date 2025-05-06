import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P37_WallPainting {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader
          (new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    
    if(n == 0) {
      System.out.print(0);
      return;
    }
    
    // Direct approach for verification
    int[][] diff = new int[1002][1002];
    
    // Read rectangles and mark directly on grid
    // Step 1: Apply difference array logic
    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      
      diff[x1][y1]++;
      diff[x2][y1]--;
      diff[x1][y2]--;
      diff[x2][y2]++;

    }
      
    // Step 2: Compute 2D prefix sums to build final grid
    for (int i = 0; i <= 1001; i++) {
        for (int j = 1; j <= 1001; j++) {
            diff[i][j] += diff[i][j - 1];
        }
    }
    for (int j = 0; j <= 1001; j++) {
        for (int i = 1; i <= 1001; i++) {
            diff[i][j] += diff[i - 1][j];
        }
    }

    // Step 3: Count cells with exactly k painters
    long count = 0;
    for (int i = 0; i <= 1000; i++) {
        for (int j = 0; j <= 1000; j++) {
            if (diff[i][j] == k) {
                count++;
            }
        }
    }

    System.out.println(count);
  }
}