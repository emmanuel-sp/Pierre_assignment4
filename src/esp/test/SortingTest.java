package esp.test;

import esp.controller.Sorting;

public class SortingTest {
    public static void main(String[] args) {
        int[] num1 = new int[]{8,2,3,1,9,4};
        print(num1);
        Sorting.quickSort(num1, "");
        print(num1);
    }
    public static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
    }
}
