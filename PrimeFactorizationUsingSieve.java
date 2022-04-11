import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactorizationUsingSieve {
    public static void main(String[] args){
        int limit, n;
        Scanner s = new Scanner(System.in);
        limit = s.nextInt();
        n = s.nextInt();

        //compute the sieve array
        int[] sieve = new int[limit+1];
        sieve[1] = -1;
        for(int i=2; i<=limit; i++){
            sieve[i] = 1;
        }
        for(int i=2; i*i<=limit; i++){
            if(sieve[i]==1){
                sieve[i] = i;
                for(int j=i*i; j<=limit & j>=1; j+=i){
                    if(sieve[j]==1)
                    sieve[j] = i;
                }
            }
        }
//        System.out.println(Arrays.toString(sieve));
        while(n>=1){
            int input = s.nextInt();
            List<Integer> factors = new ArrayList<>();
            while(input>=1){
                if(sieve[input]==1) {
                    factors.add(input);
                    break;
                }
                factors.add(sieve[input]);
                input = input / sieve[input];
            }
            System.out.println(factors);
            n--;
        }
    }
}
