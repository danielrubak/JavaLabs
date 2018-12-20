import java.util.Scanner;

/**
 * Simple class for determining the fibonacci sequence
 */
public class Fibo {

    public static void main(String[] args) {
        System.out.println("Enter a number between 1 and 45:");
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        if ( n < 1 || n > 45 ) {
            return;
        } else {
            int[] tab = new int[n];
            for (int i = 1; i <= n; i++) {
                tab[i-1] = fibonacci(i);
            }

            for (int i = 1; i <= n; i++) {
                System.out.println(tab[i-1] + " ");
            }
        }
    }


    /**
     * @param n - which number from fibonacci sequence want to return
     * @return nth value of the fibonacci sequence
     */
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }
}