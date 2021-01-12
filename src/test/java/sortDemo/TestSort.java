package sortDemo;

import org.junit.Test;

/**
 * @author ziwing
 * @date 2021/1/12
 */
public class TestSort {

    private final int ARRAY_LENGTH = (int) 1e6;

    /** 打印数组 */
    void print(int[] arr){
        for (int i = 0; i < arr.length; i++){
            if (i == arr.length - 1){
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }

    /** 获取一个正序数组 */
    int[] getArrayByASC(){
        int[] arr = new int[ARRAY_LENGTH];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
        return arr;
    }

    /** 获取一个倒序数组 */
    int[] getArrayByDES(){
        int[] arr = new int[ARRAY_LENGTH];
        int len = arr.length;
        for (int i = 0; i < arr.length; i++){
            arr[i] = len--;
        }
        return arr;
    }

    /** 测试是否排好序，正序 */
    boolean checkSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }

    /** 随机产生数组 */
    int[] getRandomArray(){
        int[] arr = new int[ARRAY_LENGTH];
        for (int i = 0; i < arr.length; i++){
            int num = (int) (Math.random() * 1000000 + 1);
            arr[i] = num;
        }
        return arr;
    }

    @Test
    public void start(){
        int[] arr = getArrayByDES();
        print(arr);
    }

    /**
     * 测试冒泡排序
     */
    @Test
    public void bubbleSortTest(){
        int[] arr = getRandomArray();
        ArraySort.bubbleSort(arr);
        System.out.println(checkSort(arr));
    }

    /**
     * 选择排序
     */
    @Test
    public void selectSortTest(){
        int[] arr = getRandomArray();
        ArraySort.selectSort(arr);
//        print(arr);
        System.out.println(checkSort(arr));
    }

    /**
     * 插入排序
     */
    @Test
    public void insertSortTest(){
        int[] arr = getRandomArray();
        //int[] arr = getArrayByASC();
        //int[] arr= getArrayByDES();
        ArraySort.insertSort(arr);
//        print(arr);
        System.out.println(checkSort(arr));
    }

    @Test
    public void mergeSortTest(){
        int[] arr = getRandomArray();
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        print(arr);
    }

    /**
     *  快速排序
     */
    @Test
    public void quickSortTest(){
//        int[] arr = getRandomArray();
//        int[] arr = getArrayByASC();
        int[] arr = getArrayByDES();
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        print(arr);
    }

    @Test
    public void ranQuickSortTest(){
        int[] arr = getRandomArray();
//        int[] arr = getArrayByASC();
//        int[] arr = getArrayByDES();
        QuickSort quickSort = new QuickSort();
        quickSort.randomSort(arr);
//        print(arr);
        System.out.println(checkSort(arr));
    }

    /**
     * 计数排序
     */
    @Test
    public void countSortTest(){
        int[] arr = getRandomArray();
//        int[] arr = getArrayByASC();
//        int[] arr = getArrayByDES();
        ArraySort.countSort(arr);
//        print(arr);
        System.out.println(checkSort(arr));
    }

    /**
     * 基数排序
     */
    @Test
    public void radixSortTest(){
        int[] arr = getRandomArray();
        ArraySort.radixSort(arr);
//        print(arr);
        System.out.println(checkSort(arr));
    }
}
