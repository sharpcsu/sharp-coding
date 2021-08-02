package 程序员代码面试指南.main;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            long[] arr = new long[n];
            long[] res = new long[n - 1];
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextLong();
            }

            for (int j = 0; j < n - 1; j++) {
                res[j] = scanner.nextLong();
            }

            for (int j = 0; j < n - 1; j++) {
                for (int k = 0; k < n; k++) {
                    if (res[j] == arr[k]) {
                        arr[k] = 0;
                        break;
                    }
                }
            }

            for (int k = 0; k < n; k++) {
                if (arr[k] != 0) {
                    System.out.println(arr[k]);
                    break;
                }
            }
        }
    }
}
