package Session.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P65_WaterDrinking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        long amanLitre = 0;
        long bittuLitre = 0;

        int i = 0;
        int j = n - 1;

        int amanCnt = 0;
        int bittuCnt = 0;

        while(i <= j) {
            if(amanLitre <= bittuLitre) {
                amanLitre += a[i++];
                amanCnt++;
            } else {
                bittuLitre += a[j--];
                bittuCnt++;
            }
        }

        System.out.println(amanCnt + " " + bittuCnt);
    }
}