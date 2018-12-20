import java.util.Scanner;

public class Fibo {

    public static void main(String[] args) {
        System.out.println("Podaj liczbę z zakresu 1 - 45: ");
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

    public static int fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }
}