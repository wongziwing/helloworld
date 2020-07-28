package sortDemo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SortTest {

    private final int ARRAY_LENGTH = (int) 1e6;

    void print(int[] arr){
        for (int i = 0; i < arr.length; i++){
            if (i == arr.length - 1){
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }

    int[] getArrayByASC(){
        int[] arr = new int[ARRAY_LENGTH];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
        return arr;
    }

    int[] getArrayByDES(){
        int[] arr = new int[ARRAY_LENGTH];
        int len = arr.length;
        for (int i = 0; i < arr.length; i++){
            arr[i] = len--;
        }
        return arr;
    }


    int[] getRandomArray(){
        int[] arr = new int[ARRAY_LENGTH];
        for (int i = 0; i < arr.length; i++){
            int num = (int) (Math.random() * 1000000 + 1);
            arr[i] = num;
        }
        return arr;
    }

    @Test
    void start(){
        //int[] arr = getRandomArray();
        //int[] arr = getArrayByASC();
        int[] arr = getArrayByDES();
        print(arr);
    }

    @Test
    void bubbleSortTest(){
        int[] arr = getRandomArray();
        ArraySort.bubbleSort(arr);
        print(arr);
    }

    @Test
    void selectSortTest(){
        int[] arr = getRandomArray();
        ArraySort.selectSort(arr);
        print(arr);
    }

    @Test
    void insertSortTest(){
        int[] arr = getRandomArray();
        //int[] arr = getArrayByASC();
        //int[] arr= getArrayByDES();
        ArraySort.insertSort(arr);
        print(arr);
    }

    @Test
    void mergeSortTest(){
        int[] arr = getRandomArray();
//        int[] arr = getArrayByASC();
//        int[] arr =getArrayByDES();
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        print(arr);
    }

    @Test
    void quickSortTest(){
//        int[] arr = getRandomArray();
//        int[] arr = getArrayByASC();
        int[] arr = getArrayByDES();
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        print(arr);
    }

    @Test
    void ranQuickSortTest(){
        int[] arr = getRandomArray();
//        int[] arr = getArrayByASC();
//        int[] arr = getArrayByDES();
        QuickSort quickSort = new QuickSort();
        quickSort.randomSort(arr);
        print(arr);
    }

    @Test
    void countSortTest(){
        int[] arr = getRandomArray();
//        int[] arr = getArrayByASC();
//        int[] arr = getArrayByDES();
        ArraySort.countSort(arr);
        print(arr);
    }

    @Test
    void radixSortTest(){
        int[] arr = getRandomArray();
        ArraySort.radixSort(arr);
        print(arr);
    }

}
