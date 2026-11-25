package leetcode.maximum_average_subarray_643;


import java.util.Arrays;

public class Solution {

    static void main() {
        int[] array = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(array, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        double best = Integer.MIN_VALUE;
        int sumWindow = 0;
        double averageWindow;
        if (nums.length == k) {
            sumWindow = Arrays.stream(nums).reduce(Integer::sum).getAsInt();
            return (sumWindow * 1.0) / k;
        }
        int left = 0;
        int right = k - 1;
        while (right < nums.length) {
            for (int i = left; i <= right; i++) {
                sumWindow += nums[i];
            }
            averageWindow = (sumWindow * 1.0) / k;
            best = Math.max(best, averageWindow);
            sumWindow = 0;
            left++;
            right++;
        }
        return best;
    }
}
/*
    Задача easy уровня. Довольно простая. Тут решение максимально не эффективное (каждый раз пересчитываю сумму окна для каждого сдвига), но рабочее.
    Более эффективное:
        Так как окно фиксированного размера, то получается что максимальное среднее - это максимальная найденная сумма окна, размером k
        Следовательно мы просто можем заполнить изначальный bestValue суммой первых элементов (цикл for, от 0 до к), а потом просто вторым циклом for
        пройтись по оставлемуся массиву, от k до конца массива (получается что в данном случае i - это right значение, а так как размер окна фиксирован, то left можно вычислить следующим способом:
        left = right-k. Таким образом ищем максимальную сумму окна и в самом конце делем ее на k и получается максимальное среднее
 */
