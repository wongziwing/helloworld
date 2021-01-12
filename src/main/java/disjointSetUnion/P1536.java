package disjointSetUnion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1536 {

    static int[] citys;

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String[] temp = br.readLine().split(" ");
            if (temp.length == 1) break;
            int n = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);
            citys = new int[n+1];
            for (int i = 1; i <= n; i++) citys[i] = i;
            for (int i = 1; i <= m; i++){
                String[] s = br.readLine().split(" ");
                int x = Integer.parseInt(s[0]);
                int y = Integer.parseInt(s[1]);
                if (union(x, y)) count++;
            }
            if (count >= n - 1){
                System.out.println(0);
            } else {
                System.out.println(n - 1 - count);
            }
            count = 0;
        }
    }

    static int find(int x){
        if (x != citys[x]){
            citys[x] = find(citys[x]);
        }
        return citys[x];
    }

    static boolean union(int x, int y){
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) return false;
        citys[xRoot] = yRoot;
        return true;
    }
}
