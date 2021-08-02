package 程序员代码面试指南.main;

import java.util.Scanner;

public class Main25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int res = method(num);
        System.out.println(res);
    }

    private static int method(int num) {
        int maxIndex = 0;
        int minIndex = 0;
        int[] arr = new int[8];
        for (int i = 7; i >= 0; i--) {
            int t = num % 10;
            arr[i] = t;
            if (arr[maxIndex] < t) {
                maxIndex = i;
            }

            if (arr[minIndex] > t) {
                minIndex = i;
            }

            num /= 10;
        }

        int t = arr[0];
        arr[0] = arr[maxIndex];
        arr[maxIndex] = t;

        if(!(maxIndex == 7 && minIndex == 0)) {
            t = arr[7];
            arr[7] = arr[minIndex];
            arr[minIndex] = t;
        }

        int res = 0;
        for (int i = 0; i < 8; i++) {
            res = res * 10 + arr[i];
        }
        return res;
    }
}
