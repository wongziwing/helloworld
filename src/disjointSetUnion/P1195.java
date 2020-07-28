package disjointSetUnion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 洛谷P1195 口袋的天空
 * 就是给你nn个点mm条边， 然后让你把这几个点连成kk个部分.
 */
public class P1195{
    static int[] parent;
    static int count, sum;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        List<Yun> list = new ArrayList<>();
        for (int i = 0; i < m; i++) list.add(new Yun(in.nextInt(), in.nextInt(), in.nextInt()));
        in.close();
        Collections.sort(list);
        for (Yun yun : list){
            if (count >= n - k){
                break;
            }
            if (find(yun.x) != find(yun.y)){
                union(yun.x, yun.y);
                count++;
                sum += yun.l;
            }
        }
        if (count >= n - k){
            System.out.println(sum);
        } else {
            System.out.println("No Answer");
        }

    }

    static int find(int x){
        if (x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y){
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) return;
        parent[xRoot] = yRoot;
    }
}

class Yun implements Comparable<Yun>{
    int x;
    int y;
    int l;

    public Yun(int x, int y, int l) {
        this.x = x;
        this.y = y;
        this.l = l;
    }

    @Override
    public int compareTo(Yun o) {
        return this.l - o.l;
    }
}
