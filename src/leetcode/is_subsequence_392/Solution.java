package leetcode.is_subsequence_392;

public class Solution {

    public boolean isSubsequence(String s, String t) {
        if (s.isBlank()) {
            return true;
        }
        if (t.isBlank()) {
            return false;
        }
        int leftPointer = 0;
        int rightPointer = 0;
        while (rightPointer < t.length() && leftPointer < s.length()) {
            if (s.charAt(leftPointer) == t.charAt(rightPointer)) {
                leftPointer++;
            }
            rightPointer++;
        }
        return leftPointer == s.length();
    }
} // Задача простая, достаточно сделать 2 указателя, 1 будет смотреть на буквы из первого массива, а второй указатель будет смотреть на 2 строку и если цикл прошел и leftPointer дошел до конца, то ответ true, если нет, то false
