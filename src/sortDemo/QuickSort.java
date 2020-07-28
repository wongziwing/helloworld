package sortDemo;

/**
 * 快速排序
 */
public class QuickSort {

    public void sort(int[] elem){
        quickSort(elem, 0, elem.length - 1);
    }

    void quickSort(int[] elem, int low, int high){
        if (elem == null || low >= high) return;
        int left = low;
        int right = high;
        int flag = elem[low];
        while (left < right){
            // 从右向左寻找小于flag的数
            while (left < right && elem[right] >= flag) right--;
            // 将右边小的数放到左边，左指针向右移
            if (left < right) elem[left++] = elem[right];
            // 从左向右寻找大于flag的数
            while (left < right && elem[left] <= flag) left++;
            // 将左边较大的数放到右边
            if (left < right) elem[right--] = elem[left];
        }
        elem[left] = flag;

        quickSort(elem, low, left);
        quickSort(elem, left + 1, high);
    }

    public void randomSort(int[] elem) {
        randomQuickSort(elem, 0, elem.length - 1);
    }

    void randomQuickSort(int[] elem, int low, int high){
        if (elem == null || low >= high) return;
        int left = low;
        int right = high;
        int index = (int)(Math.random() * (high - low + 1)) + low;
        // 取数组中随机一个数
        int flag = elem[index];
        elem[index] = elem[low];
        elem[low] = flag;
        while (left < right){
            while (left < right && elem[right] >= flag) right--;
            if (left < right) elem[left++] = elem[right];
            while (left < right && elem[left] <= flag) left++;
            if (left < right) elem[right--] = elem[left];
        }
        elem[left] = flag;

        randomQuickSort(elem, low, left);
        randomQuickSort(elem, left + 1, high);
    }

}
