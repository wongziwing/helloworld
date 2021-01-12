package skills;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 稀疏数组:
 *      解决数据中某个数据重复量大的问题
 */
public class SparseArray {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 0, 0, 8, 0},
                {0, 10, 0, 0, 9},
                {0, 0, 0, 0, 2},
        };
        int target = 0;
        //int[][] result = zipArr(arr, target);
        //print(result);

        //int[][] unzipArr = unzipArr(result, target);
        //print(unzipArr);
        streamDome();
    }

    static void streamDome(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list = list.stream().map(e -> e-1).filter(e -> e > 0).collect(Collectors.toList());
        System.out.println(list.toString());
    }

    static void print(int[][] arr){
//        for (int[] i : arr){
//            for (int j : i){
//                System.out.print(j + ", ");
//            }
//            System.out.println();
//        }
        // java 流操作
        Arrays.stream(arr).forEach(a -> {
            Arrays.stream(a).forEach(e -> System.out.print(e + ", "));
            System.out.println();
        });

    }



    /**
     * 传入数组，输入需要去除的数据
     * @param arr 原本的数组
     * @param target 去除的数据
     * @return 稀疏数组， int[n][0] 为第几行， int[n][1] 为第几列， int[n][2] 为具体数据
     */
    public static int[][] zipArr(int[][] arr, int target){
        int count = 0;

        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt != target) {
                    count++;
                }
            }
        }

        int[][] temp = new int[count+1][3];
        temp[0][0] = arr.length;
        temp[0][1] = arr[0].length;
        temp[0][2] = count;
        int index = 1;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (arr[i][j] != target){
                    temp[index][0] = i;
                    temp[index][1] = j;
                    temp[index][2] = arr[i][j];
                    index++;
                }
            }
        }
        return temp;
    }

    /**
     * 解压稀疏数组
     * @param arr 需要解压的数组
     * @param target 出现最多的数字
     * @return
     */
    public static int[][] unzipArr(int[][] arr, int target){
        int[][] temp = new int[arr[0][0]][arr[0][1]];
        int index = 1;
        for (int i = 0; i < temp.length; i++){
            for (int j = 0; j < temp[i].length; j++){
                if (arr[index][0] == i && arr[index][1] == j){
                    temp[i][j] = arr[index][2];
                    index++;
                } else {
                    temp[i][j] = target;
                }
            }
        }
        return temp;
    }

}













