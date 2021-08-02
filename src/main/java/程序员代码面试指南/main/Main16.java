package 程序员代码面试指南.main;

/**
 * Created by 杨威 on 9/22 0022 - 17:28
 */
public class Main16 {
    public static void main(String[] args) {
        for (int i = 1000; i < 10000; i++) {
            if ((i * 4) == reverse(i)) {
                System.out.println(i);
            }
        }
    }

    private static int reverse(int n) {
        int res = n % 10;
        while (n > 10) {
            n = n / 10;
            res = res * 10 + n % 10;
        }

        return res;
    }
}
