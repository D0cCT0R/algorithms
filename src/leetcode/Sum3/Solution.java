package leetcode.Sum3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static void main() {
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r  = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--; // обязательно, так как если не сдвинуть то бесконечно будут добавляться те же значения в список
                } else if (sum > 0) {
                    r--;
                } else l++;
            }
        }
        return result;
    } // в этой задаче главное зафиксировать 1 элемент ( делаю при помощи цикла for), а остальные 2 просто необходимо найти при поомщи 2 указателей, в итоге получается сложность - o(n^2). Для 4sum такой же подход, просто необоходимо зафиксировать 2 числа, а остальные найти при помощи 2 указателей.
    // также нам нужно еще отсечь повторы, а для этого достаточно просто взять и после того, как мы нашли нужный триплет - и слевой и с правой стороны пропустить дубли и соотвтетсвенно дойти до уникальных чисел,но нужно после этого обязательно l++, r--, если этого не сделать, то в таком случае будет бесконечнй цикл.
    // также зафиксированное число тоже необходимо пропустить дубликаты
}
