package sortDemo;

/**
 * 归并排序
 */
public class MergeSort {

    public void sort(int[] elem){
        mergeSortUp2Down(elem, 0, elem.length - 1);
    }

    /**
     * 从上到下分割数组
     * @param elem 数组
     * @param start 开始下标
     * @param end 结束下标
     */
    void mergeSortUp2Down(int[] elem, int start, int end){
        if (elem == null || start >= end) {
            return;
        }
        // 从中间分割
        int mid = (start + end) / 2;
        // 分割左边
        mergeSortUp2Down(elem, start, mid);
        // 分割右边
        mergeSortUp2Down(elem, mid + 1, end);
        // 将左右两边排序
        merge(elem, start, mid, end);
    }

    /**
     *
     * @param elem 排序数组
     * @param start 开始下标
     * @param mid 中间下标
     * @param end 结束下标
     */
    void merge(int[] elem, int start, int mid, int end){
        int left = start;
        int right = mid + 1;
        int[] temp = new int[end - start + 1];
        int index = 0;
        while (left <= mid && right <= end){
            // 每次将左右两边中较小的数添加到数组
            if (elem[left] > elem[right]){
                temp[index++] = elem[right++];
            } else {
                temp[index++] = elem[left++];
            }
        }
        // 如果左边的数组还有剩余，全部添加到临时数组中
        while (left <= mid){
            temp[index++] = elem[left++];
        }
        // 如果右边数组有剩余，全部添加到临时数组中
        while (right <= end){
            temp[index++] = elem[right++];
        }
        for (int i = 0; i < index; i++){
            elem[start++] = temp[i];
        }
    }
}
