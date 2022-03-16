import java.util.Arrays;
import java.util.Scanner;

public class SmallestDifference {
    public static int[] getSmallestDifference(int[] arrayOne, int[] arrayTwo) {
        int x = 0;
        int y = 0;
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int currentDiff = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        int[] possibleAns = new int[2];
        while(x<arrayOne.length && y<arrayTwo.length){
            int firstNum = arrayOne[x];
            int secondNum = arrayTwo[y];
            currentDiff = Math.abs(arrayOne[x] - arrayTwo[y]);
            if(arrayOne[x] < arrayTwo[y]){
                x++;
            }
            else if(arrayOne[x] > arrayTwo[y]){
                y++;
            }
            else{
                possibleAns = new int[] {firstNum, secondNum};
                break;
            }
            if(minDiff > currentDiff){
                minDiff = currentDiff;
                possibleAns = new int[] {firstNum, secondNum};
            }
        }
        return possibleAns;
    }
    public static void main(String[] args){
        int n, m;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();

        int[] arrayOne = new int[n];
        int[] arrayTwo = new int[m];
        for(int i=0; i<n; i++){
            arrayOne[i] = s.nextInt();
        }
        for(int i=0; i<m; i++){
            arrayTwo[i] = s.nextInt();
        }
        int[] smallestDifference = getSmallestDifference(arrayOne, arrayTwo);
        System.out.println(Arrays.toString(smallestDifference));
    }
}
