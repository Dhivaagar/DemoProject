package DSA.LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class LeetCodeSolution {
    public static long find(int A, int B, int C, int N)
    {

        // Stores the last three terms in the series
        long prev1 = A, prev2 = B, prev3 = C;
        long curr = 0;

        // Iterate over the range [4, N]
        for (int i = 4; i <= N; i++)
        {
            // Calculate the current term as the sum of previous 3 terms
            curr = prev1 + prev2 + prev3;

            // Update the previous terms for the next iteration
            prev1 = prev2;
            prev2 = prev3;
            prev3 = curr;
        }

        // Return the N-th term
        return curr;
    }
    public static void main (String[] args) {
        int[] nums = new int[]{5,2,6,2};
        System.out.println(isPerfectSquare(808201));
    }
    public static boolean isPerfectSquare(int num) {
        if(num == 1)
            return true;

        int l = 1, r = num/2;
        while(l <= r){
            int mid = (l + r)/2;
            long sq = (long) mid * mid;
            if(sq == num)
                return true;
            else if(sq > num)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }
}
