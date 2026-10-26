package leetcode.contains_dublicate_2_219;

// Задача следующая: Дан массив целых чисел nums и целое число k.
// Верните true, если в массиве есть два различных индекса i и j таких, что nums[i] == nums[j] и abs(i - j) <= k.

// Решение довольно простое. Решать нужно при помощи sliding window. abs(i-j) <= k буджет истино всегда если брать окно которое будет в пределах k
// То есть если массив size = 5, а k = 3, то в таком случае нельзя взять первый и последний элемент массива, так как i-j > k, поэтому нужно брать какой-то промежуток размером меньше k
// Соответственно решение следующее:

import java.util.LinkedHashSet;

public class Main {
    static void main() {
        int[] arr = {1,2,3,1,2,3};
        System.out.println(contains(arr, 2));
    }

    public static boolean contains(int [] arr, int k) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>(); // LinkedHashSet ля того, что бы сохранялся порядок вставки
        for (int j : arr) {
            if (set.contains(j)) { // Проверяем есть ли в нашем окне дубликат, если есть, то возвращаем true
                return true;
            }
            set.add(j); // Добавляем элемент в LinkedHashSet (наше окно)
            if (set.size() > k) {
                 set.removeFirst(); // Если наше окно по размерам становиться больше k, это значит что мы удаляем первый элемент нашего окна ( если размер окна становиться > k, то в таком случае первый и последний элемент окна не будут соблюдать условие abs(i-j) < k)
            }
        }
        return false; // Если после прохождения всего массива не нашлись дубликаты, то просто возвращаем false
    }

}


