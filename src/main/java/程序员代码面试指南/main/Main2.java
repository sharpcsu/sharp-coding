package 程序员代码面试指南.main;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int x1 = rev(x);
        int y1 = rev(y);
        int res = rev(x1 + y1);
        System.out.println(res);
    }

    private static int rev(int x) {
        while (true) {
            if (x % 10 == 0) {
                x = x / 10;
            } else {
                break;
            }
        }

        int res = 0;
        while (x > 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }

        return res;
    }


}
