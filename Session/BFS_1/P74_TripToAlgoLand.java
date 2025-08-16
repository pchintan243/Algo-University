package Session.BFS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P74_TripToAlgoLand {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numberOfCities = Integer.parseInt(st.nextToken());
        int numberOfRoads = Integer.parseInt(st.nextToken());

        Map<String, List<String[]>> adj = new LinkedHashMap<>();
        for (int i = 0; i < numberOfRoads; i++) {
            String input = br.readLine();
            String[] words = input.split(" ");
            adj.putIfAbsent(words[0], new ArrayList<>());
            adj.putIfAbsent(words[1], new ArrayList<>());
            adj.get(words[0]).add(new String[]{words[1], words[2]});
        }

        String input = br.readLine();
        String[] words = input.split(" ");
        String source = words[0];
        String destination = words[1];

        // Check if source and destination are even in the graph
        if (!adj.containsKey(source) || !adj.containsKey(destination)) {
            System.out.println("Impossible");
            return;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(source);

        // A map to store the predecessor of each city to reconstruct the path
        Map<String, String[]> parent = new HashMap<>();
        parent.put(source, null); // Source has no parent


        Set<String> cityVisited = new HashSet<>();
        boolean isDestinationFound = false;

        while (!q.isEmpty()) {
            String currentCity = q.poll();

            if (currentCity.equals(destination)) {
                isDestinationFound = true;
                break;
            }

            if (adj.containsKey(currentCity)) {
                for (String[] data : adj.get(currentCity)) {
                    String city = data[0];
                    String road = data[1];
                    if (!cityVisited.contains(city)) {
                        cityVisited.add(city);
                        q.offer(city);
                        parent.put(city, new String[]{currentCity, road});
                    }
                }
            }
        }

        if (isDestinationFound) {
            List<String> roads = new ArrayList<>();
            String currentCity = destination;

            while (parent.get(currentCity) != null && !currentCity.equals(source)) {
                String[] strings = parent.get(currentCity);
                roads.add(strings[1]);
                currentCity = strings[0];
            }
            System.out.println(roads.size());
            for (int i = roads.size() - 1; i >= 0; i--) {
                System.out.println(roads.get(i));
            }
        } else {
            System.out.print("Impossible");
        }
    }
}