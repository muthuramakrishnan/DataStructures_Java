import java.util.Scanner;

public class OpenCloseDoor {
    public static void main(String[] args){
        int noOfDoors;
        Scanner s = new Scanner(System.in);
        noOfDoors = s.nextInt();

        //You want to do noOfDoors iteration and toggle the doors
        //condition for each iteration, multiples of i should be toggled
        //at last you need to find out the number of open doors
//        int openDoors = 0;
//        for(int i=1; i<=noOfDoors; i++){
//            //perfect square contains odd factors
//            //else it contains even factors
//            int root = (int) Math.sqrt((double) i);
//            if(root*root == i){
//                openDoors++;
//            }
//        }
        //optimization 1

        int noOfPerfectSquares = (int) Math.sqrt(noOfDoors);
        System.out.println(noOfPerfectSquares);
    }
}
