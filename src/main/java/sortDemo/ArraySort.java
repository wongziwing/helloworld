package sortDemo;

import java.util.ArrayList;

/**
 * 排序
 */
public class ArraySort {

    /**
     * 冒泡排序
     */
    static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = i+1; j < arr.length; j++){
                if (arr[i] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     */
    static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int min = arr[i];
            int index = i;
            for (int j = i+1; j < arr.length; j++){
                if (arr[j] < min){
                    min = arr[j];
                    index = j;
                }
            }
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * 插入排序
     * @param arr 数组
     */
    static void insertSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = i-1; j >= 0; j--){
                if (arr[i+1] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i+1];
                    arr[i+1] = temp;
                    break;
                }
            }
        }
    }

    /**
     * 计数排序, 只能排大于等于0的数
     * @param arr 排序数组
     */
    static void countSort(int[] arr){
        int max = -1;
        // 找出数组中最大的数
        for (int i : arr){
            if (max < i){
                max = i;
            }
        }
        int[] temp = new int[max + 1];
        for (int i : arr){
            temp[i]++;
        }
        int index = 0;
        for (int i = 0; i < temp.length; i++){
            while (temp[i]-- > 0){
                arr[index++] = i;
            }
        }
    }

    /**
     * 基数排序
     * @param arr 排序数组
     */
    static void radixSort(int[] arr){
        int max = arr[0];
        for (int i : arr){
            if (max < i)
                max = i;
        }
        int exp;
        for (exp = 1; max / exp > 0; exp *= 10){
            int[] temp = new int[arr.length];
            int[] buckets = new int[10];

            for (int value : arr){
                buckets[(value / exp) % 10]++;
            }

            for (int i = 1; i < 10; i++){
                buckets[i] += buckets[i - 1];
            }

            for (int i = arr.length - 1; i >= 0; i--){
                temp[buckets[(arr[i] / exp) % 10] - 1] = arr[i];
                buckets[(arr[i] / exp) % 10]--;
            }
            System.arraycopy(temp, 0, arr, 0, arr.length);
        }
    }

}
