import java.util.Scanner;

public class PascalsTriangle {
    public static void bruteForceApproach(int n){
        int[][] resultArray = new int[n+1][];
        for(int i=1; i<=n; i++){
            resultArray[i] = new int[i+1];
            for(int j=1; j<=i; j++){
                if(j==1 || j==i){
                    resultArray[i][j] = 1;
                }
                else{
                    resultArray[i][j] = resultArray[i-1][j] + resultArray[i-1][j-1];
                }
            }
        }

        for(int i=1; i<=n; i++){
            for(int space=n-i+1; space>=1; space--){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print(resultArray[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);
        n=s.nextInt();

       bruteForceApproach(n);
    }
}
