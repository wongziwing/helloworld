package disjointSetUnion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P1396 {

    static int[] parent;
    static int cnt, ans;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        int t = in.nextInt();
        parent = new int[n+1];
        List<Street> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) parent[i] = i;
        for (int i = 0; i < m; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            Street street = new Street(u, v, w);
            list.add(street);
        }
        Collections.sort(list);
        for (Street street : list){
            if (find(street.v) != find(street.u)){
                union(street.v, street.u);
                ans = Math.max(ans, street.w);
                cnt++;
                if (cnt == n - 1) break;
                if (find(s) == find(t)) break;
            }
        }
        System.out.println(ans);
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

class Street implements Comparable<Street>{
    int u;
    int v;
    int w;

    public Street(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Street o) {
        return this.w - o.w;
    }

}
