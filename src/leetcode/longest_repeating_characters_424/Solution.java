package leetcode.longest_repeating_characters_424;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    static void main() {
        System.out.println(characterReplacement("AAAA", 2));
    }

    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        char[] array = s.toCharArray(); // Преобразуем строку в массив чаров
        int left = 0; // левый указатель, для удаления ненужных символов из count
        int best = 0; // лучшй показатель длины окна
        int maxFreqChar = 0; // самый часто повторяющийся символ в окне
        for (int right = 0; right < array.length; right++) {
            char added = array[right]; // то, что добавляем в мапу
            int newCount = count.getOrDefault(added, 0) + 1;
            count.put(added, newCount); // добавляем в мапу символ и количество повторов
            int windowLength = right - left + 1; // расчитываем длину окна для понимания сколько символов нужно заменить
            maxFreqChar = Math.max(maxFreqChar, newCount); // вычисляем самый повторяющийся символ в окне
            int charToSwap = windowLength - maxFreqChar; // вычисляем сколько символов нужно заменить
            if (charToSwap <= k) { // если меньше к, значит что окно нам подходит
                best = Math.max(best, windowLength);
            }
            if (charToSwap > k) {
                count.put(array[left], count.get(array[left]) - 1);  // удаляем выпадающий
                left++;
            } // если больше к - значит, что окно невалидно, и нужно двигать левую границу вправо, что бы окно снова стало валидно по заменам символов
        }
        return best;
    }
}
/*
   Задача не сложная, главное дойти до того, что понять, что бы найти количество символов под замену достаточно найти самый повторяющийся и длину окна и из длины вычесть самый повторяющийся символ
   Ну и простая логика инвалидации окна : когда количество символов под замену больше к
 */
