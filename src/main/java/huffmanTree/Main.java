package huffmanTree;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 测试哈夫曼树
 */
class Main{
    static int MAX = 0x3f3f3f3f;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("" +sc.nextLine());
    }

    public static void dijkstra(List<HeapNode>[] map, int s, int t){
        int[] distance = new int[map.length];
        PriorityQueue<HeapNode> queue = new PriorityQueue<>();
        for (int i = 1; i <= map.length; i++) distance[i] = MAX;
        distance[s] = 0;
        queue.add(new HeapNode(s, distance[s]));

        while (!queue.isEmpty()){
            HeapNode node = queue.poll();
            int from = node.from;
            if (node.from == t) break;
            if(node.weight != distance[from]) continue;
            for (HeapNode heapNode : map[from]){

            }
        }
    }

    static class HeapNode implements Comparable<HeapNode>{
        int from;
        int weight;

        @Override
        public int compareTo(HeapNode o) {
            return weight - o.weight;
        }

        public HeapNode(int from, int weight) {
            this.from = from;
            this.weight = weight;
        }
    }

}















