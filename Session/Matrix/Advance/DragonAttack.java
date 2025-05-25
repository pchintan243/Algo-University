package Advance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DragonAttack {
    static int[] cHome = new int[1];

    static void binarySearch(long[] preSum, int direction, long distance, int n) {

        distance = distance % n;
        if(distance == 0) {
            System.out.println(0);
            return;
        }

        long answer = -1;
        if(cHome[0] == 0) {
            cHome[0] = 1;
        }
        int currentHome = cHome[0];
        int nextAttackHome;

        if(direction == 1) {
            nextAttackHome = (currentHome + (int) (distance)) % n;
        } else {
            nextAttackHome = (currentHome + n - (int) distance) % n;
        }
        nextAttackHome = nextAttackHome == 0 ? n : nextAttackHome;
        long costClockWise = 0;
        long costAntiClockWise = 0;

        if(nextAttackHome > currentHome) {
            costClockWise = preSum[nextAttackHome] - preSum[currentHome];
        } else {
            costClockWise = preSum[n] - preSum[currentHome] + preSum[nextAttackHome];
        }

        if(nextAttackHome > currentHome) {
            costAntiClockWise = preSum[currentHome] + preSum[n] - preSum[nextAttackHome];
        } else {
            costAntiClockWise = preSum[currentHome] - preSum[nextAttackHome];
        }
        answer = Math.min(costClockWise, costAntiClockWise);
        cHome[0] = nextAttackHome;
        System.out.println(answer);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cost = new int[n];
        long[] preSum = new long[n + 1];

        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            preSum[i + 1] += cost[i] + preSum[i];
        }

        int q = Integer.parseInt(br.readLine());

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            long distance = Long.parseLong(st.nextToken());

            binarySearch(preSum, direction, distance, n);
        }
    }

}