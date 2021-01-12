package disjointSetUnion;

import java.util.Scanner;

/**
 * 题目简述：
 *      判断x和y是否为亲戚
 */
public class P1551 {

    static int[] members;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int p = in.nextInt();
        members = new int[n+1];
        for (int i = 1; i <= n; i++) members[i] = i;
        for (int i = 0; i < m; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            union(x, y);
        }
        for (int i = 0; i < p; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            if (find(x) == find(y)){
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    static int find(int x){
        if (x != members[x]){
            members[x] = find(members[x]);
        }
        return members[x];
    }

    static void union(int x, int y){
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) return;
        members[xRoot] = yRoot;
    }

}
