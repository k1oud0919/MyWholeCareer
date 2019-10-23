package k1oud.career.wholecareer.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorts {

    private static int[] array = {82, 22, 44, 65, 2, 88, 41, 56, 447, 33, 28, 96};

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

    /**
     * 选择排序，每一轮选择最小的元素放在最左边
     *
     * @param arr
     * @return
     */
    public static int[] selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            //这里需要给minIndex一个初始值，否则下面赋值操作无法通过编译
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[j] < arr[i])
                    minIndex = j;
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
        return arr;
    }

    /**
     * 插入排序
     *
     * @param arr
     * @return
     */
    public static int[] insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > tmp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
        return arr;

    }

    /**
     * shell排序实际上是插入排序的通用情况====》缩减增量变为1
     *
     * @param arr
     * @return
     */

    public static int[] shellSort(int[] arr) {
        int gap;
        /**
         * 希尔排序实际上就是插入排序外面加了一层gap循环
         */
        for (gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i += gap) {
                int tmp = arr[i];
                int j;
                for (j = i; j > 0 && arr[j - 1] > tmp; j -= gap) {
                    arr[j] = arr[j - 1];
                }
                arr[j] = tmp;
            }
        }
        return arr;

    }

    /**
     * 归并排序
     *
     * @param arr
     * @return
     */
    public static int[] mergeSort(int[] arr, int l, int r) {


        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid + 1, r);
        }
        return arr;
    }

    private static int[] merge(int[] arr, int leftPos, int rightPos, int rightEnd) {

        int leftEnd = rightPos - 1;
        int currentPos = leftPos;
        //int numberElements = rightEnd-leftPos+1;
        int[] tempArray = new int[arr.length];

        /**
         * 需要理解的是，这里归并排序利用的是递归的概念，如果leftpos比rightpos大，那自然就把right
         * 的元素加入到临时数组
         */
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (arr[leftPos] <= arr[rightPos])
                tempArray[currentPos++] = arr[leftPos++];
            else
                tempArray[currentPos++] = arr[rightPos++];
        }


        while (leftPos > leftEnd)
            tempArray[currentPos++] = arr[leftPos++];


        while (rightPos > rightEnd)
            tempArray[currentPos++] = arr[rightPos++];

        //把归并排序好的tempArray拷贝给arr
        for (int i = 0; i < arr.length; i++, rightEnd--) {
            arr[rightEnd] = tempArray[rightEnd];
        }

        return arr;
    }

    /**
     * 快速排序
     *
     * @param
     */
    public static int[] quickSort(List<Integer> items) {

        List<Integer> temp = new ArrayList<>();

        if (items.size() > 0) {

            ArrayList<Integer> smaller = new ArrayList<>();
            ArrayList<Integer> same = new ArrayList<>();
            ArrayList<Integer> larger = new ArrayList<>();

            int chosenItem = items.get(items.size() / 2);

            for (int item : items) {
                if (item < chosenItem) {
                    smaller.add(item);
                } else if (item > chosenItem) {
                    larger.add(item);
                } else
                    same.add(item);
            }

            quickSort(smaller);
            quickSort(larger);

            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
        }
        int[] tmp = new int[items.size()];

        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = items.get(i);
        }

        return tmp;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(array));
        //int[] a = bubbleSort1(array);
        //int[] b = selectionSort(array);
        //int[] c = insertionSort(array);
        //int[] d = shellSort(array);
        //int [] e = mergeSort(array,0,array.length-1);
        List<Integer> items = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            items.add(array[i]);
        }
        //System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(b));
        //System.out.println(Arrays.toString(b));
        //System.out.println(Arrays.toString(c));
        //System.out.println(Arrays.toString(d));
        //System.out.println(Arrays.toString(e));
        //System.out.println(items.toString());
        int tmp[] = quickSort(items);
        System.out.println(Arrays.toString(tmp));

    }
}
