import java.util.Scanner;
import java.util.Locale;

/**
 * Problem 115A from http://codeforces.com/problemset/problem/115/A
 */
public class Party {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        int n = scan.nextInt();
        int[] parent;
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = scan.nextInt();
        }

        int ans = 0;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            count = 0;
            int x = parent[i];
            while (x != -1) {
                x = parent[x];
                count = count + 1;
            }
            ans = Math.max(ans, count);
        }

        System.out.println(ans + 1);
    }
}