
import java.util.Arrays;
import java.util.Scanner;

public class ArrayCost {
    // 2 functions with same approach but one with 1 loop second with 2 loops

    //2pass -- first check all remainders then if same then sort and doing transformation
    public int transformationCost2Pass(int[] A,int K){
        int rem = A[0] % K;
        int len=A.length;

        for (int num : A) {
            if (num % K != rem) {
                return -1;
            }
        }
        Arrays.sort(A);// sorting
        int targetMedian=A[len/2];
        int cost=0;
        for (int num : A) {
            cost += Math.abs(num - targetMedian) / K;
        }

        return cost;

    }

    //1Pass -- pure greedy(check and calculate) but we have to do sorting in each case
    public int transformationCost1Pass(int[] A,int K){
        int rem = A[0] % K;
        int len=A.length;

        Arrays.sort(A);
        int targetMedian=A[len/2];
        int cost=0;

        for (int num : A) {
            if (num % K != rem) return -1;
            cost += Math.abs(num - targetMedian) / K;
        }

        return cost;

    }

    public static void main(String[] args) {
        ArrayCost ac=new ArrayCost();
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter the size of Array N: ");
        int N=sc.nextInt();
        int [] A=new int[N];
        System.out.print("Enter the Array value with space seperated: ");
        for (int i = 0; i < N; i++) {
            A[i]=sc.nextInt();
        }
        System.out.print("Enter the K value for transformation: ");
        int K=sc.nextInt();

        System.out.println(ac.transformationCost2Pass(A,K));

    }

}
