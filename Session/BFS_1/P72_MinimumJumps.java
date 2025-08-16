package Session.BFS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P72_MinimumJumps {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numBuildings = Integer.parseInt(st.nextToken());
        int numPairs = Integer.parseInt(st.nextToken());

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numBuildings; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < numPairs; i++) {
            st = new StringTokenizer(br.readLine());
            int buildingA = Integer.parseInt(st.nextToken()) - 1;
            int buildingB = Integer.parseInt(st.nextToken()) - 1;
            adjList.get(buildingA).add(buildingB);
            adjList.get(buildingB).add(buildingA);
        }

        st = new StringTokenizer(br.readLine());
        int startBuilding = Integer.parseInt(st.nextToken()) - 1;
        int targetBuilding = Integer.parseInt(st.nextToken()) - 1;

        boolean[] visited = new boolean[numBuildings];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startBuilding, 0});
        visited[startBuilding] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentBuilding = current[0];
            int currentJumps = current[1];

            for (Integer neighbor : adjList.get(currentBuilding)) {
                if (!visited[neighbor]) {
                    if (neighbor == targetBuilding) {
                        System.out.print(currentJumps + 1);
                        return;
                    }
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, currentJumps + 1});
                }
            }
        }

        System.out.print(0);
    }
}