package dfs;

import java.util.Scanner;

public class SPFADemo {

    static int[] dis, u, v, w;
    static int MAX = 0x3f3f3f3f;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        dis = new int[n+1];
        u = new int[m+1];
        v = new int[m+1];
        w = new int[m+1];
        for (int i = 0; i <= n; i++){
            dis[i] = MAX;
        }
        for (int i = 1; i <= m; i++){
            u[i] = in.nextInt();
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }
        spfa(n, m, s);
    }

    public static void spfa(int n, int m, int s){
        dis[s] = 0;
        for (int k = 1; k < n; k++){
            boolean check = false;
            for (int i = 1; i <= m; i++){
                if (dis[v[i]] > dis[u[i]] + w[i]){
                    dis[v[i]] = dis[u[i]] + w[i];
                    check = true;
                }
            }
            if (check) break;
        }
        for (int i = 0; i < n; i++){
            System.out.println(dis[i] + " ");
        }
    }


}
