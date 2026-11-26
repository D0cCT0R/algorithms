package leetcode.Find_the_Highest_Altitude_1732;

public class Solution {


    static void main() {
        int[] arr = {-4,-3,-2,-1,4,3,2};
        System.out.println(largestAltitude(arr));
    }

    public static int largestAltitude(int[] gain) {
        int prevPrefixSum = 0;
        int result = prevPrefixSum;
        for (int j : gain) {
            prevPrefixSum = prevPrefixSum + j;
            result = Math.max(result, prevPrefixSum);
        }
        return result;
    }
} // Простая задача, где используется подход префиксных сумм, но тут даже не нужно сохранять всеп остальные, достаточно найти максимавльную префиксную сумму которая получится в массиве
