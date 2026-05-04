package Recursion;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation {

    public String getPermutation(int n, int k) {
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }

        StringBuilder s=new StringBuilder();
        for(int i=1;i<=n;i++){
            long fact=fact(n-i);
            int index=(int) ((k-1)/fact);
            s.append(list.get(index));
            list.remove(index);

            k=(int) (k%fact) +1;
        }
        return s.toString();
    }

    private long fact(int x){
        long factOfX=1;
        for(int i=1;i<=x;i++){
            factOfX*=i;
        }
        return factOfX;
    }

    public static void main(String[] args) {
        KthPermutation p=new KthPermutation();
        String ans=p.getPermutation(4,9);

        System.out.println(ans);
    }

}
