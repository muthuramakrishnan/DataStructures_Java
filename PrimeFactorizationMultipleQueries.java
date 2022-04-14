/* package codechef; // don't place package name! */

import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
public class PrimeFactorizationMultipleQueries
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        int t, n = 1000000;
        Scanner s = new Scanner(System.in);
        t=s.nextInt();

        int[] spf = new int[n+1];
        spf[0] = spf[1] = 0;
        for(int i=2; i<=n; i++){
            spf[i] = 1;
        }
        for(int i=2; i*i<=n; i++){
            if(spf[i]==1){
                spf[i] = i;
                for(int j=i*i; j<=n; j+=i){
                    if(spf[j]==1)
                        spf[j] = i;
                }
            }
        }
        while(t>=1){
            int num = s.nextInt();
            int count = 0;
            int currentDivisor = spf[num];
            while(num>1){
                if(currentDivisor != spf[num]){
                    System.out.println(currentDivisor +" "+ count);
                    currentDivisor = spf[num];
                    count=1;
                }
                else count++;
                num = num/spf[num];
            }
            System.out.println(currentDivisor +" "+ count);
            t--;
        }
    }
}