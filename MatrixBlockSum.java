import java.util.Arrays;
import java.util.Scanner;

public class MatrixBlockSum {
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
        k=s.nextInt();

        //generate prefix sum matrix
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
                    prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] + array[i][j] - prefixSum[i-1][j-1];
                }
            }
        }

        //calculate the resultant matrix
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int i1, j1, i2, j2;
                i1 = (i-k)>=0 ? i-k : 0;
                j1 = (j-k)>=0 ? j-k : 0;
                i2 = (i+k)<m ? i+k : m-1;
                j2 = (j+k)<n ? j+k : n-1;
                int sum = prefixSum[i2][j2];
                if(i1>0){
                    sum -= prefixSum[i1-1][j2];
                }
                if(j1>0){
                    sum -= prefixSum[i2][j1-1];
                }
                if(i1>0 && j1>0){
                    sum += prefixSum[i1-1][j1-1];
                }
                array[i][j] = sum;
            }
        }
        for(int[] result : array)
            System.out.println(Arrays.toString(result));

    }
}
