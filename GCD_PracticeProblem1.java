import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GCD_PracticeProblem1 {
    public static int findGCD(int n1, int n2){
        int divisor = Math.min(n1,n2);
        int dividend = Math.max(n1,n2);

        while(divisor>=1){
            int remainder = dividend % divisor;
            if(remainder==0){
                return divisor;
            }else{
                dividend = divisor;
                divisor = remainder;
            }
        }
        return divisor;
    }
    public static void main(String[] args){
        //914. X of a Kind in a Deck of Cards
        int t, n;
        Scanner s = new Scanner(System.in);
        t = s.nextInt();
        n = s.nextInt();

        while(t>=1){
            int[] array = new int[n];
            for(int i=0; i<n; i++){
                array[i] = s.nextInt();
            }

            //calculate the number of occurrences
            Map<Integer, Integer> occurrences = new HashMap<>();
            for(int elmt : array){
                if(occurrences.containsKey(elmt)){
                    int value = occurrences.get(elmt);
                    occurrences.put(elmt, ++value);
                }
                else{
                    occurrences.put(elmt, 1);
                }
            }

            //now get only the values
            int gcd = -1;
            int i = 0;
            for(int value : occurrences.values()){
                if(i==0){
                    gcd = value;
                }
                else{
                    gcd = findGCD(gcd, value);
                }
                i++;
            }

            if(n>1 && i==1 && n%2!=0){
                System.out.println(false);
            }
            else if(n==1 || gcd>1){
                System.out.println(true);
            }
            else
                System.out.println(false);

            t--;
        }
    }
}
