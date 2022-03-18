import java.util.Scanner;

public class SumOfAllSubarraysMatrix {
    public static int optimizedApproach(int[][] array, int m, int n){
        //o(n2) time
        int sum=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                sum += (i+1) * (j+1) * (m-i) * (n-j) * array[i][j];
            }
        }
        return sum;
    }
    public static int findSumOfSubArraysBruteForce(int[][] array, int m, int n){
        //O(n6) time complexity very slow
        int sum=0;
        for(int i1=0; i1<m; i1++){
            for(int j1=0; j1<n; j1++){
                for(int i2=i1; i2<m; i2++){
                    for(int j2=j1; j2<n; j2++){
                        for(int i=i1; i<=i2; i++){
                            for(int j=j1; j<=j2; j++){
                                sum += array[i][j];
                            }
                        }
                    }
                }
            }
        }
        return sum;
    }
    public static void main(String[] args){
        int m,n;
        Scanner s = new Scanner(System.in);
        m = s.nextInt();
        n = s.nextInt();

        int[][] array = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                array[i][j] = s.nextInt();
            }
        }

//        int sum = findSumOfSubArraysBruteForce(array, m,n);
        int sum = optimizedApproach(array, m, n);
        System.out.println(sum);
    }
}
