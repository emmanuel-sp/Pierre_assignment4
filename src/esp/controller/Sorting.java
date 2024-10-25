package esp.controller;

public class Sorting {
    public static long comparisons = 0; // tracking comparisons
    public static String piv = ""; // pivot to use
    public static void selectionSort(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int index = 0; // Moving pointer
        int min = nums[0]; // Current min
        int hold = 0; // Pointer to index of min for swapping
        for (int i = 0; i < nums.length; i++) {
            min = nums[index]; // Make min the first element
            for (int j = index; j < nums.length; j++) {
                comparisons++; // Increment comparison for the comparison below v
                if (nums[j] <= min) {
                    min = nums[j];
                    hold = j;
                }
            }
            // Swap and increment index
            nums[hold] = nums[index];
            nums[index] = min;
            index++;
        }
    }

    public static void mergeSort(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int mid = nums.length / 2;
        int[] left = new int[mid]; // Left side (ends with nums[mid - 1])
        int[] right = new int[nums.length - mid]; // Right side (starts with nums[mid])

        for (int i = 0; i < mid; i++) {
            left[i] = nums[i]; // Copy elements to array
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = nums[mid + i]; // Copy elements to array
        }

        mergeSort(left); // Break down left segment
        mergeSort(right); // Break down right segment
        merge(nums, left, right); // Merge!!
    }
    private static void merge(int[] nums, int[] left, int[] right) {
        int leftPointer = 0, rightPointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftPointer < left.length && rightPointer < right.length) {
                comparisons++; // for below comparison
                if (left[leftPointer] < right[rightPointer]) {
                    nums[i] = left[leftPointer++];
                } else {
                    nums[i] = right[rightPointer++];
                }
            } else if (rightPointer >= right.length) {
                nums[i] = left[leftPointer++]; // Rest of elements in unfinished array
            } else if (leftPointer >= left.length) {
                nums[i] = right[rightPointer++];
            }
        }
    }

    public static void heapSort(int nums[]) {
        int lastIndex = nums.length;
        // Build heap (rearrange array)
        for (int i = lastIndex / 2 - 1; i >= 0; i--)
            heapify(nums, lastIndex, i);
        // One by one extract an element from heap
        for (int i = lastIndex - 1; i > 0; i--) {
            // Move current root to end
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            // call max heapify on the reduced heap
            heapify(nums, i, 0);
        }
    }
    private static void heapify(int nums[], int lastIndex, int index) {
        int largest = index; // Initialize largest as root
        int left = 2 * index + 1; // left = 2*i + 1
        int right = 2 * index + 2; // right = 2*i + 2
        // If left child is larger than root
        comparisons++;
        if (left < lastIndex && nums[left] > nums[largest])
            largest = left;
        // If right child is larger than largest so far
        comparisons++;
        if (right < lastIndex && nums[right] > nums[largest])
            largest = right;
        // If largest is not root
        if (largest != index) {
            int swap = nums[index];
            nums[index] = nums[largest];
            nums[largest] = swap;
            // Recursively heapify the affected sub-tree
            heapify(nums, lastIndex, largest);
        }
    }

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }
    private static void quickSort(int[] nums, int first, int last) {
        if (first < last) {
            int pi = partition(nums, first, last); // returns partition point
            quickSort(nums, first, pi - 1);
            quickSort(nums, pi + 1, last);
        }
    }
    private static int partition(int[] nums, int first, int last) {
        int random = (int) ((Math.random() * (last - first)) + first); // Index of random pivot
        if (piv.equalsIgnoreCase("RP")) { // Decides pivot point
            swap(nums, random, last);
        } else {
            swap(nums, first, last);
        }
        int pivot = nums[last];
        int i = (first - 1);
        for (int j = first; j < last; j++) {
            comparisons++;
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, last);
        return (i + 1);
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void print(int[] nums) { // For testing purposes
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
    }
}
