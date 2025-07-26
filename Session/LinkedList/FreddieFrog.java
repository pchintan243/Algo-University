package Session.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class FreddieFrog {

    // Main method where the program execution begins
    public static void main(String[] args) throws IOException {
        // BufferedReader for faster input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer to parse space-separated integers
        StringTokenizer st = new StringTokenizer(br.readLine());

        // Read N (number of leaves) and M (number of commands)
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // TreeMap to store leaves indexed by (x-y) value.
        // Inner TreeMap maps x-coordinate to y-coordinate for leaves with the same (x-y) difference.
        TreeMap<Integer, TreeMap<Integer, Integer>> diff = new TreeMap<>();
        // TreeMap to store leaves indexed by (x+y) value.
        // Inner TreeMap maps x-coordinate to y-coordinate for leaves with the same (x+y) sum.
        TreeMap<Integer, TreeMap<Integer, Integer>> sum = new TreeMap<>();

        // Read the string of commands
        String commands = br.readLine();

        // Array to store initial leaf coordinates. We need this to get Freddy's starting position.
        int[][] leaves = new int[n][2];

        // Loop through all N leaves to read their coordinates and populate the TreeMaps
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()); // Get new tokenizer for each line

            leaves[i][0] = Integer.parseInt(st.nextToken()); // Read x-coordinate
            leaves[i][1] = Integer.parseInt(st.nextToken()); // Read y-coordinate

            int x = leaves[i][0];
            int y = leaves[i][1];

            int diffCo = x - y; // Calculate x-y difference
            int sumCo = x + y;  // Calculate x+y sum

            // Add the leaf to the 'diff' map.
            // computeIfAbsent: If diffCo key doesn't exist, create a new TreeMap for it.
            // Then, put the x and y coordinates into that inner TreeMap.
            diff.computeIfAbsent(diffCo, k -> new TreeMap<>()).put(x, y);

            // Add the leaf to the 'sum' map, similar to 'diff' map.
            sum.computeIfAbsent(sumCo, k -> new TreeMap<>()).put(x, y);
        }

        // Freddy starts from the first leaf (index 0)
        int currentX = leaves[0][0];
        int currentY = leaves[0][1];

        // Process each command one by one
        for(char ch: commands.toCharArray()) {
            int nextX = -1; // Initialize nextX and nextY to -1 to indicate no valid jump found yet
            int nextY = -1;

            // Store Freddy's current position before attempting a jump.
            // This is the leaf that will collapse if Freddy successfully jumps from it.
            int prevX = currentX;
            int prevY = currentY;

            // Use a switch statement to handle different command types
            switch (ch) {
                case 'A': // Direction A: (a + Z, b + Z) => x-y constant, x increases, y increases
                    int aDiff = currentX - currentY; // The (x-y) value must remain constant
                    if(diff.containsKey(aDiff)) { // Check if there are any leaves with this difference
                        TreeMap<Integer, Integer> mp = diff.get(aDiff); // Get the inner map for this difference
                        // higherKey(currentX) finds the smallest key strictly greater than currentX.
                        // This gives us the x-coordinate of the 'first' leaf in direction A.
                        Integer probablyNext = mp.higherKey(currentX);

                        if(probablyNext != null) { // If such a leaf exists
                            nextX = probablyNext;
                            nextY = mp.get(probablyNext); // Get its corresponding y-coordinate
                        }
                    }
                    break;
                case 'B': // Direction B: (a + Z, b - Z) => x+y constant, x increases, y decreases
                    int bSum = currentX + currentY; // The (x+y) value must remain constant
                    if(sum.containsKey(bSum)) { // Check if there are any leaves with this sum
                        TreeMap<Integer, Integer> mp = sum.get(bSum); // Get the inner map for this sum
                        // higherKey(currentX) finds the smallest x-coordinate greater than currentX
                        Integer probablyNext = mp.higherKey(currentX);

                        if(probablyNext != null) {
                            nextX = probablyNext;
                            nextY = mp.get(probablyNext);
                        }
                    }
                    break;
                case 'C': // Direction C: (a - Z, b + Z) => x+y constant, x decreases, y increases
                    int cSum = currentX + currentY; // The (x+y) value must remain constant
                    if(sum.containsKey(cSum)) { // Check if there are any leaves with this sum
                        TreeMap<Integer, Integer> mp = sum.get(cSum); // Get the inner map for this sum
                        // lowerKey(currentX) finds the largest key strictly less than currentX.
                        // This gives us the x-coordinate of the 'first' leaf in direction C.
                        Integer probablyNext = mp.lowerKey(currentX);

                        if(probablyNext != null) {
                            nextX = probablyNext;
                            nextY = mp.get(probablyNext);
                        }
                    }
                    break;
                case 'D': // Direction D: (a - Z, b - Z) => x-y constant, x decreases, y decreases
                    int dDiff = currentX - currentY; // The (x-y) value must remain constant
                    if(diff.containsKey(dDiff)) { // Check if there are any leaves with this difference
                        TreeMap<Integer, Integer> mp = diff.get(dDiff); // Get the inner map for this difference
                        // lowerKey(currentX) finds the largest x-coordinate less than currentX
                        Integer probablyNext = mp.lowerKey(currentX);

                        if(probablyNext != null) {
                            nextX = probablyNext;
                            nextY = mp.get(probablyNext);
                        }
                    }
                    break;
            }

            // If a valid next leaf was found (nextX and nextY are not -1)
            if(nextX != -1 && nextY != -1) {
                currentX = nextX; // Update Freddy's current x-coordinate
                currentY = nextY; // Update Freddy's current y-coordinate
                // Remove the leaf Freddy just jumped FROM (prevX, prevY)
                removeLeaf(diff, sum, prevX - prevY, prevX + prevY, prevX);
            }
            // If nextX and nextY are still -1, it means no leaf was found in that direction,
            // so Freddy doesn't move, and the current leaf (prevX, prevY) is NOT removed.
        }
        // Print Freddy's final coordinates
        System.out.print(currentX + " " + currentY);
    }

    // Helper method to remove a leaf from both 'diff' and 'sum' TreeMaps
    private static void removeLeaf(TreeMap<Integer, TreeMap<Integer, Integer>> diff,
                                   TreeMap<Integer, TreeMap<Integer, Integer>> sum,
                                   int diffCo, int sumCo, int x) {

        // Get the inner TreeMap for the given difference
        TreeMap<Integer, Integer> diffMap = diff.get(diffCo);
        // Get the inner TreeMap for the given sum
        TreeMap<Integer, Integer> sumMap = sum.get(sumCo);

        // Remove the x-coordinate (and its corresponding y) from both inner TreeMaps
        if (diffMap != null) { // Defensive check in case the map was already removed
            diffMap.remove(x);
            // If the inner TreeMap becomes empty after removal, remove the outer key as well
            if(diffMap.isEmpty()) {
                diff.remove(diffCo);
            }
        }

        if (sumMap != null) { // Defensive check
            sumMap.remove(x);
            // If the inner TreeMap becomes empty after removal, remove the outer key as well
            if(sumMap.isEmpty()) {
                sum.remove(sumCo);
            }
        }
    }
}