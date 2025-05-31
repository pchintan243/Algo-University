package Contest.Contest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class SoodlesGoogle {

    static int upperBound(List<Integer> lst, int ind) {
        int low = 0;
        int high = lst.size() - 1;
        int ans = high + 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (lst.get(mid) > ind) {
                high = mid - 1;
                ans = lst.get(mid);
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }


    static int findDestCount(String src, String dest) {
        int ans = 1;
        int n = src.length();
        Map<Character, List<Integer>> mp = new HashMap<>();
        for(int i = 0; i < n; i++) {
            mp.putIfAbsent(src.charAt(i), new ArrayList<>());
            mp.get(src.charAt(i)).add(i);
        }

        int i = 0;
        int lastInd = -1;
        char[] ch = dest.toCharArray();
        int destLength = dest.length();
        while(i < destLength) {
            if(mp.containsKey(ch[i])) {
                List<Integer> lst = mp.get(ch[i]);
                int ub = upperBound(lst, lastInd);
                if(ub > lastInd) {
                    lastInd = ub;
                } else {
                    lastInd = mp.get(ch[i]).get(0);
                    ans++;
                }
            } else {
                return -1;
            }
            i++;
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            String dest = br.readLine();
            String src = br.readLine();

            System.out.println(findDestCount(src, dest));
        }
    }
}