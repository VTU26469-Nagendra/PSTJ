import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            String S = sc.next();
            if (isLapindrome(S)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }

    public static boolean isLapindrome(String S) {
        int n = S.length();
        String left, right;

        if (n % 2 == 0) {
            left = S.substring(0, n/2);
            right = S.substring(n/2);
        } else {
            left = S.substring(0, n/2);
            right = S.substring(n/2 + 1);
        }

        int[] freqLeft = new int[26];
        int[] freqRight = new int[26];

        for (char c : left.toCharArray()) {
            freqLeft[c - 'a']++;
        }
        for (char c : right.toCharArray()) {
            freqRight[c - 'a']++;
        }

        return Arrays.equals(freqLeft, freqRight);
    }
}
