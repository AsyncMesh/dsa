import java.util.Scanner;

public class CyclicSubstringMaximum {
    public int findSubstringSum(String s) {
        int[] freq = new int[26];
        int n = s.length();
        int i = 0;
        int j = 0;
        int currSum = 0;
        int ans = 0;

        while (j < n) {
            int idx = s.charAt(j) - 'a';
            freq[idx]++;
            currSum += idx + 1;

            while (freq[idx] > 1) {
                int idxAti = s.charAt(i) - 'a';
                freq[idxAti]--;
                currSum -= (idxAti + 1);
                i++;
            }

            ans = Math.max(currSum, ans);
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        CyclicSubstringMaximum c = new CyclicSubstringMaximum();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the STring : ");
        String S= sc.nextLine();

        System.out.print(c.findSubstringSum(S+S));
    }
}
