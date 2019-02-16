import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        final int size = 26;

        boolean arr[][] = new boolean[size][size];

        String names[] = new String[n];

        for (int i = 0; i < n; i++) {
            String newS = sc.next();

            if (i == 0) {
                names[i] = newS;
                continue;
            }

            for (int j = 0; j < names[i - 1].length() && j < newS.length(); j++) {
                if (names[i - 1].charAt(j) != newS.charAt(j)) {
                    arr[(int) newS.charAt(j) - 97][(int) names[i - 1].charAt(j) - 97] = true;
                    break;
                }
            }

            names[i] = newS;
        }

        ArrayList<Character> chars = new ArrayList<>();
        HashMap<Integer, Integer> levels = new HashMap<>();
        int countOfValues = 0;
        int currientLevel = 1;
        for (int i = 0; i < size; i++) {
            boolean bool = true;
            for (int j = 0; j < size; j++) {
                if (arr[i][j]) {
                    bool = false;
                    break;
                }
            }
            if (!bool) {
                continue;
            }
            levels.put(i, currientLevel);
            countOfValues++;
            chars.add((char) (i + 97));
        }
        while (levels.containsValue(currientLevel)) {
            currientLevel++;
            for (int i = 0; i < size; i++) {
                if (levels.containsKey(i)) {
                    continue;
                }
                boolean bool = true;
                for (int j = 0; j < size; j++) {
                    if (arr[i][j]) {
                        if (!levels.containsKey(j) || !(levels.get(j) < currientLevel)) {
                            bool = false;
                            break;
                        }
                    }
                }
                if (bool) {
                    countOfValues++;
                    chars.add((char) (i + 97));
                    levels.put(i, currientLevel);
                }
            }
        }
        if (countOfValues != size) {
            System.out.println("Impossible");
        } else {
            for (char ch : chars
            ) {
                System.out.println(ch);
            }
        }
    }
}