package Round2020.E.LongestArithmetic;

import java.util.Scanner;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        for (int kase = 1; kase <= T; kase++) {
            System.out.println(String.format("Case #%s: %s", kase, solve()));
        }
    }

    private static Object solve() {
        int length = scanner.nextInt();
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = scanner.nextInt();
        }

        int step = a[1] - a[0];
        int maxCnt = 2;
        int cnt = 2;
        for (int i = 2; i < length; i++) {
            int gap = a[i] - a[i - 1];
            if (gap == step) {
                cnt++;
            } else {
                step = gap;
                cnt = 2;
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }
}
