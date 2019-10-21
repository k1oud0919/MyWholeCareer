package k1oud.career.wholecareer.leetCode;

import java.util.Arrays;

public class Sorts {

    private static int []  array = {82,22,44,65,2,88,41,56,447,33,28,96};
    /**
     * 冒泡排序，每一轮使相邻的两个元素比较
     */
    public static int[] bubbleSort1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                }
            }

        }
        return arr;
    }

    public static void main(String[] args) {

        int [] a = bubbleSort1(array);
        System.out.println(Arrays.toString(a));

    }
}
