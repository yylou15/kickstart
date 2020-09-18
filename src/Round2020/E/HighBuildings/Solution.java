package Round2020.E.HighBuildings;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        for (int kase = 1; kase <= T; kase++) {
            System.out.println(String.format("Case #%s: %s", kase, solve()));
        }
    }

    private static Object solve() {
        int N = scanner.nextInt(), A = scanner.nextInt(), B = scanner.nextInt(), C = scanner.nextInt();

        Deque<Integer> deque = new LinkedList<>();
        int heightOrder = N;
        for (int i = 0; i < C; i++) {
            deque.addLast(heightOrder);
        }
        int more = N - (A + B - C);
        if (A - C > 0) {
            for (int i = 0; i < more; i++) {
                deque.addFirst(heightOrder - (A - C) - 1);
            }
        } else if (B - C > 0) {
            for (int i = 0; i < more; i++) {
                deque.addLast(heightOrder - (B - C) - 1);
            }
        }
        int leftHeight = heightOrder;
        for (int i = 0; i < A - C; i++) {
            deque.addFirst(--leftHeight);
        }
        int rightHeight = heightOrder;
        for (int i = 0; i < B - C; i++) {
            deque.addLast(--rightHeight);
        }

        if (deque.size() > N){
            return "IMPOSSIBLE";
        }
        return deque.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
