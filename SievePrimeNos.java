import java.util.Scanner;

public class SievePrimeNos {
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        boolean[] array = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            array[i] = true;
        }
        for (int i = 2; i*2 <= n; i++) {
            if (array[i]) {
                for (int j = i * i; j <= n && j>0; j += i) {
                    array[j] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (array[i]) {
                System.out.println(i);
            }
        }
    }
}
