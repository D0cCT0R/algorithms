package leetcode.range_sum_query_immutable_303;


class Main {
    static void main() {
        int arr[] = new int[] {1,2,3,4,5,6};
        NumArray array = new NumArray(arr);
        System.out.println(array.sumRange(1,3));
    }
}
class NumArray {
    public int[] pref;
    public NumArray(int[] nums) {
        pref = new int[nums.length+1];
        pref[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            pref[i+1] = pref[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return pref[right+1] - pref[left];
    }
}
