package leetcode.Subarray_Sum_Equals_K;

import java.util.HashMap;

public class Solution {

    static void main() {
        int[] arr = new int[]{1, 2, 3};
        System.out.println(subarraySum(arr, 3));
    }

    public static int subarraySum(int[] nums, int k) { // [-1,-1,1] k = 0,
        HashMap<Integer, Integer> pref = new HashMap<>(); // префиксные суммы
        pref.put(0, 1); // добавляем первый элемент, что бы ничего не потерять
        int result = 0; // сколько отрезков подходит
        int sum = 0; // наша текущая сумма (нужна для расчета префиксных сумм)
        for (int num : nums) {
            sum += num; // считаем префиксную сумму
            result += pref.getOrDefault(sum-k, 0); // смотрим, есть ли для нашего right подходящие left, если есть то получае подходящее кол-во left, если нет то ничего не прибавляем
            pref.put(sum, pref.getOrDefault(sum, 0) + 1); // просто добавляем нашу префиксную сумму в map, если уже есть значение то прибавляем просто езе один отрезок
        }
        return result;
    }
}

/*
Данную задачу можно решить 2-мя способами, либо сделать массив префиксных сумм, а потом вложенными массивами пройтись по каждому значению и если num[right] - num[left]==k, то значит мы нашли отрезок, который нужен и прибавляем result, o(n^2)
Есть более производительный метод через HashMap. В HashMap мы складываем наши префиксные суммы и дальше sum - это наша текущая позиция и дальше мы должны искать сколько left префиксных сумм подходят под наш right. Если k = right-left, то left = right - k
и получается что мы должны просто имея на руках k и имея на руках right просто найти подходящий left в map
 */

/*

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2

 */
