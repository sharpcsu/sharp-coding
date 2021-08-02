package 程序员代码面试指南.main;

import java.util.Scanner;

/**
 * 二分查找强化
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int index = method(arr, n, x);
        System.out.println(index);
    }

    private static int method(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

            mid = (low + high) / 2;
        }
        return -1 - low;
    }
}
