package Contest.Contest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class LinearProbing {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] hashTable = new int[m];
        Arrays.fill(hashTable, -1);

        Set<Integer> insertedElements = new HashSet<>();
        int currentFilledSlots = 0;

        for (int i = 0; i < n; i++) {
            int element = arr[i];

            if (insertedElements.contains(element)) {
                continue;
            }

            if (currentFilledSlots == m) {
                continue;
            }

            int initialPos = element % m;
            int currentPos = initialPos;
            int probes = 0;

            while (probes < m) {
                if (hashTable[currentPos] == -1) {
                    hashTable[currentPos] = element;
                    insertedElements.add(element);
                    currentFilledSlots++;
                    break;
                }
                currentPos = (currentPos + 1) % m;
                probes++;
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.print(hashTable[i] + " ");
        }
    }
}