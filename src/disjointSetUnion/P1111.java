package disjointSetUnion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 题目简述：
 *      找出连接修复所有村庄的最短时间
 * 注意点：
 *      题目输入数据量大，需要使用BufferReader
 */
public class P1111 {

    static int[] fat;
    static int[] weight;
    static int count = 0;
    static int minTime = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        if (n > m+1){
            return;
        }
        fat = new int[n+1];
        weight = new int[n+1];
        for (int i = 1; i <= n; i++) fat[i] = i;
        for (int i = 1; i <= n; i++) weight[i] = 1;
        List<CZ> list = new ArrayList<>();
        for (int i = 0; i < m; i++){
            String[] temp = br.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            int t = Integer.parseInt(temp[2]);
            CZ cz = new CZ(x, y ,t);
            list.add(cz);
        }
        Collections.sort(list);
        for (CZ cz : list){
            if (count >= n - 1 && check()){
                System.out.println(minTime);
                return;
            }
            if (find(cz.from) != find(cz.to)){
                union(cz.from, cz.to);
                count++;
                minTime = cz.time;
            }
        }
        System.out.println(-1);
    }

    static int find(int x){
        if (x != fat[x]){
            fat[x] = find(fat[x]);
        }
        return fat[x];
    }

    static void union(int x, int y){
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) return;
        if (weight[xRoot] > weight[yRoot]){
            fat[yRoot] = xRoot;
            weight[xRoot] += weight[yRoot];
        } else {
            fat[xRoot] = yRoot;
            weight[yRoot] += weight[xRoot];
        }
    }

    static boolean check(){
        int root = find(fat[1]);
        for (int i = 1; i < fat.length; i++){
            if (find(fat[i]) != root) return false;
        }
        return true;
    }

}

class CZ implements Comparable<CZ>{
    int from;
    int to;
    int time;

    public CZ(int from, int to, int time) {
        this.from = from;
        this.to = to;
        this.time = time;
    }

    @Override
    public int compareTo(CZ o) {
        return this.time - o.time;
    }
}
