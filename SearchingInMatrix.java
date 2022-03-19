import java.util.Scanner;

public class SearchingInMatrix {
    public static void main(String[] args){
        //this is a sorted matrix
        //each row is sorted
        //each column is sorted
        //perform search
        int m, n, k;
        Scanner s = new Scanner(System.in);
        m = s.nextInt();
        n = s.nextInt();
        k = s.nextInt();

        int[][] array = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                array[i][j] = s.nextInt();
            }
        }

        int i = m-1;
        int j = 0;
        while(i>=0 && j<n){
            if(k == array[i][j]){
                System.out.println(i +" " + j);
                return;
            }
            if(k<array[i][j]){
                i--;
            }
            else j++;
        }
    }
}
