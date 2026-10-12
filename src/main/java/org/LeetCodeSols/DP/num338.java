package org.LeetCodeSols.DP;

/***
 * ans[i] holds how many 1 bits sit in the binary representation of i, built up from smaller values already solved
 * shifting i right by one drops its last bit, landing on i / 2, whose popcount has already been computed and stored in ans
 * i & 1 pulls out exactly that dropped bit on its own, either 0 or 1, since it's just checking the lowest bit of i directly
 * adding the two back together gives the popcount of i itself, since dropping the last bit only ever removes that one bit from the count
 * ans[0] stays at its default of zero since zero has no set bits, and every ans[i] after it is found the same way as i climbs up to n
 */

public class num338 {
    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }
}
