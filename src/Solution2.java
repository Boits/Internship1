import java.util.HashMap;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String arr[] = new String[n];
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String newS = sc.next();

            if(hashMap.containsKey(newS)){
                int value = hashMap.get(newS);
                hashMap.put(newS, ++value);
                arr[i] = newS + Integer.toString(value-1);
                System.out.println(arr[i]);
            }else {
                hashMap.put(newS,1);
                arr[i] = newS;
                System.out.println("OK");
            }
        }

    }
}