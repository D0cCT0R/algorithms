package leetcode.Find_the_Difference_of_Two_Arrays_2215;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    static void main() {

    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> setNums1 = new HashSet<>();
        HashSet<Integer> setNums2 = new HashSet<>();
        for (int n : nums1) {
            setNums1.add(n);
        }
        for (int n : nums2) {
            setNums2.add(n);
        }
        List<Integer> result1 = new ArrayList<>();
        for (int n : setNums1) {
            if (!setNums2.contains(n)) {
                result1.add(n);
            }
        }
        List<Integer> result2 = new ArrayList<>();
        for (int n : setNums2) {
            if (!setNums1.contains(n)) {
                result2.add(n);
            }
        }
        result.add(result1);
        result.add(result2);
        return result;
    } // Простая задача, где мы просто сначала сеты перебираем, а потом значения из этих сетов, что бы не было повторов
}
