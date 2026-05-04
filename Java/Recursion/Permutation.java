package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> up = new ArrayList<>();

        for (int n : nums) {
            up.add(n);
        }

        return permutation(new ArrayList<>(), up);

    }

    public List<List<Integer>> permutation(List<Integer> p, List<Integer> up) {

        if (up.size() == 0) {

            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>(p));
            return ans;
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < up.size(); i++) {

            int val = up.get(i);

            List<Integer> newP = new ArrayList<>(p);
            newP.add(val);

            List<Integer> newUp = new ArrayList<>(up);
            newUp.remove(i);

            result.addAll(permutation(newP, newUp));
        }

        return result;

    }

    public static void main(String[] args) {
        Permutation s=new Permutation();
        List<List<Integer>> l=s.permute(new int[] {1,2,3,4});
        System.out.println(l.toString());
    }
}


