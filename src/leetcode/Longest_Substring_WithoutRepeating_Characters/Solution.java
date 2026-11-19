package leetcode.Longest_Substring_WithoutRepeating_Characters;

import java.util.*;

public class Solution {

    static void main() {

    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] string = s.toCharArray();
        int result = 0;
        int left = 0;
        for (int right = 0; right < string.length; right++) {
            char current = string[right];
            while (set.contains(current)) {
                set.remove(string[left]);
                left++;
            }
            set.add(current);
            result = Math.max(result,(right - left) + 1);
        }
        return result; // задача, в которой следующая логика: мы должны удалять все элементы слева до того момента, пока current элемент не будет уникальным в нашем окне
    }

}
