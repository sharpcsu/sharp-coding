package 程序员代码面试指南.main;

import java.util.Scanner;

public class Main11 {
    public static int[][] arr = new int[10][10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        while (scanner.hasNextInt()) {
            String s = scanner.nextLine();
            String[] ss = s.split(" ");
            int[] nums = new int[ss.length];
            for (int i = 0; i < ss.length; i++) {
                nums[i] = new Integer(ss[i]);
            }

            for (int num : nums) {
                int i = num / 10;
                int j = num % 10 - 1;
                remove(i, j);
                move();
            }
        }
    }

    private static void move() {
        //下移
        for (int j = 0; j < 10; j++) {
            for (int i = 9; i >= 0; i--) {
                if (arr[i][j] == -1) {
                    moveToDown(i, j);
                }
            }
        }
        //左移
//        i
    }

    private static void moveToDown(int i, int j) {
        for (; i < 0; i--) {
            int t = arr[i - 1][j];
            arr[i - 1][j] = -2;
            arr[i][j] = t;
        }
    }

    private static void remove(int i, int j) {
        int t = arr[i][j];
        //上
        if (i > 0) {
            if (t == arr[i - 1][j]) {
                remove(i - 1, j);
            } else {
                return;
            }
        }
        //下
        if (i < 9) {
            if (t == arr[i + 1][j]) {
                remove(i + 1, j);
            } else {
                return;
            }
        }
        //左
        if (j > 0) {
            if (t == arr[i][j - 1]) {
                remove(i, j - 1);
            } else {
                return;
            }
        }
        //右
        if (j < 9) {
            if (t == arr[i][j + 1]) {
                remove(i, j + 1);
            } else {
                return;
            }
        }

        arr[i][j] = -1;
    }

}
