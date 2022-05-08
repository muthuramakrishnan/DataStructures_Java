/* package codechef; // don't place package name! */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
public class CountNumberofUniqPrimeFactors
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        int t, n = 1000000;
        int [] sieve = new int[n+1];
        Scanner s = new Scanner(System.in);

        sieve[0] = sieve[1] = 0;
        for(int i=2; i<=n; i++){
            sieve[i] = 1;
        }
        for(int i=2; i*i<=n; i++){
            if(sieve[i]==1){
//                sieve[i]=i;
                for(int j=i*i; j<=n; j+=i){
                    if(sieve[j]==1){
                        sieve[j]=i;
                    }
                }
            }
        }
        t = s.nextInt();
        while(t>=1){
            int size = s.nextInt();
            for(int i=0; i<size; i++){
                int element = s.nextInt();
                int origElement = element;
                Map<Integer, Integer> counts = new HashMap<>();
                while(element>1){
                   if(sieve[element]!=1) {
                        if (counts.containsKey(sieve[element])) {
                            int value = counts.get(sieve[element]);
                            counts.put(sieve[element], ++value);
                        } else {
                            counts.put(sieve[element], 1);
                        }
                    }
                    if(element/sieve[element] == element){
                        element=1;
                    }
                    else element = element/sieve[element];
                }
                int ans= counts.size();
                ans = sieve[origElement]==1 ? ans+1: ans;
                System.out.print(ans +" ");
            }
            System.out.println();
            t--;
        }
    }
}