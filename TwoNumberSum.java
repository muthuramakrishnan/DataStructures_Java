import java.util.Scanner;

public class TwoNumberSum {

    public static int[] bruteForceTwoNumberSum(int[] array, int target){
        for(int i=0; i<array.length; i++){
            for(int j=i+1; j<array.length; j++){
                if(array[i] + array[j] == target){
                    return new int[] {array[i], array[j]};
                }
            }
        }
        return new int[] {};
    }

    public static void main(String[] args){
        int n, target;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        target = s.nextInt();

        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = s.nextInt();
        }

        int[] result;
        result = bruteForceTwoNumberSum(array, target);
        if(result.length == 0){
            System.out.println("No such numbers");
        }
        for(int item : result){
            System.out.println(item+" ");
        }
    }
}
