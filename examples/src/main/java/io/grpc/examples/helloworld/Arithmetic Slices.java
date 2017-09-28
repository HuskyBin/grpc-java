/*
A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequence:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.

1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of array A is called arithmetic if the sequence:
A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.


Example:

A = [1, 2, 3, 4]

return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
*/
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }       
        int result = 0;
        boolean[][] dp = new boolean[A.length][A.length];
        for (int i = 0; i + 2 < A.length; i++) {
            if (A[i + 1] - A[i] == A[i + 2] - A[i + 1]) {
                dp[i][i + 2] = true;
                result++;
            }
        }
        for (int len = 3; len < A.length; len++) {
            for (int i = 0; i + len < A.length; i++) {
                int j = i + len;

                if (dp[i][j - 1] && dp[i + 1][j]) {
                    dp[i][j] = true;
                    result++;
                }
            }
        }
        return result;
    }
}
