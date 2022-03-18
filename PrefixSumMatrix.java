import java.util.Scanner;

public class PrefixSumMatrix {
    public static void main(String[] args){
        int m,n, k;
        Scanner s = new Scanner(System.in);
        m = s.nextInt();
        n = s.nextInt();

        int[][] array = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                array[i][j] = s.nextInt();
            }
        }

        int[][] prefixSum = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0){
                    prefixSum[i][j] = array[i][j];
                }
                else if(i==0){
                    prefixSum[i][j] = prefixSum[i][j-1] + array[i][j];
                }
                else if(j==0){
                    prefixSum[i][j] = prefixSum[i-1][j] + array[i][j];
                }
                else{
                    prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + array[i][j];
                }
            }
        }

        k = s.nextInt();
        while(k>=1){
            int i1, j1, i2, j2;
            i1 = s.nextInt();
            j1 = s.nextInt();
            i2 = s.nextInt();
            j2 = s.nextInt();

            int ans = prefixSum[i2][j2];
            if(i1>0){
                ans -= prefixSum[i1-1][j1];
            }
            if(j1>0){
                ans -= prefixSum[i1][j1-1];
            }
            System.out.println(ans);
            k--;
        }
    }
}
