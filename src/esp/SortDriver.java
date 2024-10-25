package esp;

import esp.controller.Sorting;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SortDriver {
    public static void main(String[] args) {
        int[] nums = new int[10000];
        int o = 0;
        Scanner input = new Scanner(System.in);
        try { // When file is given
            if (args.length == 0) {
                throw new FileNotFoundException();
            }
            File file = new File(args[0]);
            input = new Scanner(file);
            while (input.hasNextInt()) {
                int val = input.nextInt();
                nums[o++] = val;
            }
            input.close();
        } catch (FileNotFoundException e) { // For no file given
            System.out.print("Please enter the array size: ");
            input = new Scanner(System.in);
            int n = input.nextInt();
            nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = (int) (Math.random() * n);
            }
        }
        input = new Scanner(System.in);
        System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) quick-sort-fp (q) "+
        "quick-sort-rp (r)");
        System.out.print("Enter the algorithm: ");
        char algo = input.next().charAt(0);
        String algor = "";
        switch (algo) {
        case 's':
            Sorting.selectionSort(nums);
            algor = "#Selection-sort";
            break;
        case 'm':
            Sorting.mergeSort(nums);
            algor = "#Merge-sort";
            break;
        case 'h':
            Sorting.heapSort(nums);
            algor = "#Heap-sort";
            break;
        case 'q':
            Sorting.quickSort(nums);
            algor = "#Quick-sort-fp";
            break;
        case 'r':
            Sorting.piv = "RP";
            Sorting.quickSort(nums);
            algor = "#Quick-sort-rp";
            break;
        default:
            System.exit(0);
            break;
        }
        print(nums);
        System.out.println(algor + " comparisons: " + Sorting.comparisons);
    }
    private static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }


}
