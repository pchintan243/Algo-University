package Session.BFS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AvoidingCities {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numberOfCities = Integer.parseInt(st.nextToken());
        int numberOfRoads = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int source = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        boolean[] isCursedCity = new boolean[numberOfCities];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < numberOfCities; i++) {
            if(Integer.parseInt(st.nextToken()) == 1)
                isCursedCity[i] = true;
        }

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numberOfCities; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < numberOfRoads; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            adj.get(first).add(second);
            adj.get(second).add(first);
        }

        boolean[] isVisited = new boolean[numberOfCities];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{source, 1});
        while(!q.isEmpty()) {
            int[] val = q.poll();
            int vertices = val[0];
            int jump = val[1];

            for(Integer v: adj.get(vertices)) {
                // If not visited then mark it as visited
                if(!isVisited[v] && !isCursedCity[v]) {
                    if(v == destination) {
                        System.out.print(jump);
                        return;
                    }
                    isVisited[v] = true;
                    q.offer(new int[]{v, jump + 1});
                }
            }
        }

        System.out.print(-1);

    }
}
