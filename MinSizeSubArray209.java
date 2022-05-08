import java.util.Scanner;

public class MinSizeSubArray209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i=0;
        int j=0;
        int sum = nums[0];
        int minLength = Integer.MAX_VALUE;
        while(j<n && i<=j){
            if(sum>=target){
                minLength = Math.min(minLength, j-i+1);
                sum -= nums[i];
                i++;
            }
            else {
                j++;
                if(j<n){
                    sum += nums[j];
                }
            }
        }
        return minLength;
    }
    public static void main(String[] args){
        int n, target;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        target = s.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = s.nextInt();
        }
        int ans = minSubArrayLen(target, nums);
        System.out.println(ans);
    }
}
