package disjointSetUnion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * kruskal算法示例：
 *      几个城市之间有道路相连，找出连接最短路径
 *      第一行有n个城市，m条路径
 *      接下来有m行, 就是城市x 到城市y 的距离z
 * 解题思路：
 *      创建一个类来存放城市之间边的长度, 实现Comparable接口
 *      按长度对边进行排序
 *      从小到大对边进行判断是否在同一集合
 */
public class KruskalDemo {
    /*
        6 10
        1 2 10
        1 3 16
        1 4 14
        2 4 15
        2 5 24
        3 4 14
        3 6 16
        4 5 23
        4 6 8
        5 6 22
     */
    // 存放所有连接的边
    static int[] fat;
    // 记录已经存放了多少条边
    static int k = 0;
    // 记录最短距离
    static int min = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        fat = new int[n + 1];
        for (int i = 1; i <= n; i++) fat[i] = i;
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < m; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            Node node = new Node(x, y, z);
            list.add(node);
        }
        Collections.sort(list);
        for (Node node : list){
            if (k == n - 1) break;
            if (find(node.from) != find(node.to)){
                min += node.dis;
                union(node.from, node.to);
                k++;
            }
        }
        System.out.println(min);
    }

    /**
     * 查找元素根节点
     * @param x 传入元素
     * @return 返回根节点
     */
    static int find(int x){
        if (x != fat[x]){
            fat[x] = find(fat[x]);
        }
        return fat[x];
    }

    /**
     * 将两个元素联合起来
     * @param x x
     * @param y y
     */
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if (x == y) return;
        fat[x] = y;
    }
}

/**
 * 城市与城市之间的距离
 */
class Node implements Comparable<Node> {

    int from;
    int to;
    int dis;

    public Node(int from, int to, int dis) {
        this.from = from;
        this.to = to;
        this.dis = dis;
    }

    @Override
    public int compareTo(Node o) {
        return this.dis - o.dis;
    }
}

