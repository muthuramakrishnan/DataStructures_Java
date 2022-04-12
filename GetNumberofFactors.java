import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GetNumberofFactors {
    public static void main(String[] args){
        int limit, n;
        Scanner s = new Scanner(System.in);
        limit = s.nextInt();
        n = s.nextInt();

        //compute the sieve array - smallest prime factor array
        int[] Spf = new int[limit+1];
        Spf[1] = -1;
        for(int i=2; i<=limit; i++){
            Spf[i] = 1;
        }
        for(int i=2; i*i<=limit; i++){
            if(Spf[i]==1){
                Spf[i] = i;
                for(int j=i*i; j<=limit && j>=1; j+=i){
                    if(Spf[j]==1){
                        Spf[j] = i;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(Spf));
        while(n>=1){
            int num = s.nextInt();
            int ans = 1;
            Map<Integer, Integer> factors = new HashMap<>();
            while(num>1){
                if(factors.containsKey(Spf[num])){
                    int val = factors.get(Spf[num]);
                    factors.put(Spf[num], ++val);
                }
                else factors.put(Spf[num], 1);
                num = num / Spf[num];
            }
            for(int value : factors.values()){
                ans *= (value+1);
            }
            System.out.println(ans);
            n--;
        }
    }
}
