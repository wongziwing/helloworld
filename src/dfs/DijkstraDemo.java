package dfs;

import java.util.*;

public class DijkstraDemo {
    private static final int MAX = 0x3f3f3f3f; //不连通状态

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        List<Edge>[] map = new List[(int) 1e4 + 1];
        for (int i = 0; i <= n; i++) map[i] = new ArrayList<>();
        for (int i = 1; i <= m; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            map[x].add(new Edge(x, y ,z));
        }
        // print(map);
        int[] resolve = reslove(map, s);
        for (int i = 1; i < resolve.length; i++){
            if (resolve[i] == MAX) {
                System.out.print(Integer.MAX_VALUE + " ");
            } else {
                System.out.print(resolve[i] + " ");
            }
        }
    }

    public static void print(List<Edge>[] map){
        for (int i = 1; i < map.length; i++){
            for (Edge e : map[i]){
                System.out.print("e.from = " + e.from + " ");
                System.out.print("e.to = " + e.to + " ");
                System.out.print("e.weight = " + e.weight);
                System.out.println();
            }
        }
    }

    /**
     * 在用邻接矩阵adjMat表示的图中，求解从点s到点t的最短路径
     * @param map 邻接矩阵
     * @param s 起点
     * @return
     */
    public static int[] reslove(List<Edge>[] map, int s) {
        // 存放源点都各个顶点的距离,从1开始
        int[] distance = new int[map.length];
        // 是否已经访问过节点
        boolean[] isVisited = new boolean[map.length];
        for (int i = 1; i < map.length; i++){
            isVisited[i] = false;
            distance[i] = MAX;
        }
        for (Edge e : map[s]){
            distance[e.to] = e.weight;
        }
        distance[s] = 0;
        isVisited[s] = true;
        int index = s;
        for (int i = 1; i < map.length; i++){
            int min = MAX;
            // 获取这个顶点的最近邻边
            for (Edge e : map[index]){
                if (!isVisited[e.to] && min > e.weight){
                    min = e.weight;
                    index = e.to;
                }
            }

            for (Edge e : map[index]){
                if (distance[e.from] + e.weight < distance[e.to]){
                    distance[e.to] = distance[e.from] + e.weight;
                }
            }
            isVisited[index] = true;
        }
        return distance;
    }

    static class Edge{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

}














