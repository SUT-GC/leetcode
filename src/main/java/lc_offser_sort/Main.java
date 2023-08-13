package lc_offser_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] l = new int[]{9, 1, 4, 2, 3, 6, 4, 7, 1, 8};

        Solution solution = new Solution();

        System.out.println("bubbleSort: " + Arrays.toString(solution.bubbleSort(Arrays.copyOf(l, l.length))));
        System.out.println("selectSort: " + Arrays.toString(solution.selectSort(Arrays.copyOf(l, l.length))));
        System.out.println("insertSort: " + Arrays.toString(solution.insertSort(Arrays.copyOf(l, l.length))));
        System.out.println("shellSort: " + Arrays.toString(solution.shellSort(Arrays.copyOf(l, l.length))));
        System.out.println("mergeSort: " + Arrays.toString(solution.mergeSort(Arrays.copyOf(l, l.length))));
        System.out.println("quickSort: " + Arrays.toString(solution.quickSort(Arrays.copyOf(l, l.length))));
        System.out.println("heapSort: " + Arrays.toString(solution.heapSort(Arrays.copyOf(l, l.length))));
    }
}
