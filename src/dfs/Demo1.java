package dfs;

import java.util.*;

/**
 * 输入N,找出()得嵌套组合
 */
public class Demo1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> brackets = new Demo1().getBrackets(n);
        for (String s : brackets){
            if (check(s)){
                System.out.println(s);
            }
        }
        in.close();
    }

    public static boolean check(String str){
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()){
            if (stack.empty() && ')' == c) return false;
            if ('(' == c){
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        return stack.size() == 0;
    }

    public List<String> getBrackets(int n){
        List<String> list = new ArrayList<>();
        bracket(list, "", 0, 0, n);
        return list;
    }

    private void bracket(List<String> list, String s, int left, int right, int n) {
        if (s.length() == n * 2){
            list.add(s);
            return;
        }
        if (left < n){
            bracket(list, s + "(", left + 1, right, n);
        }
        if (right < n){
            bracket(list, s + ")", left, right + 1, n);
        }
    }

}
