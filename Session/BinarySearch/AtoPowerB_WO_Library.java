import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AtoPowerB_WO_Library {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
      new InputStreamReader(System.in));
    
    double num = Double.parseDouble(br.readLine());
    double low = 0;
    double high = num >= 1 ? num : 1;
    double eps = 1e-7;
    double ans = 0;
    while((high - low) > eps) {
      double mid = low + (high - low) / 2;
      if((mid * mid) <= num) {
        ans = mid;
        low = mid;
      } else {
        high = mid;
      }
    }
    
    System.out.printf("%.6f", ans);

  }
}