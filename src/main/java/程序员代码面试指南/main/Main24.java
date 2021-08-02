package 程序员代码面试指南.main;

/**
 * Created by 杨威 on 9/29 0029 - 16:08
 */
public class Main24 {
    public static void main(String[] args) {
        String arr = "abcd";
        String res = reverse(arr);
        System.out.println(res);
    }

    private static String reverse(String arr) {
        if (arr == null || arr.length() <= 1) {
            return arr;
        }

        return reverse(arr.substring(1)) + arr.charAt(0);
    }
}
