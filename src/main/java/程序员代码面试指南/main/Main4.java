package 程序员代码面试指南.main;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] tt = new int[999];
        int count = 0;
        for(int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] arr = new int[n][m];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    arr[j][k] = scanner.nextInt();
                }
            }

            int max = 0;
            for (int p = 0; p < n; p++) {
                for (int q = p; q < n; q++) {
                    for (int r = 0; r < m; r++) {
                        for (int s = r; s < m; s++) {
                            int temp = sum(arr, p, q, r, s);
                            if (max < temp) {
                                max = temp;
                            }
                        }
                    }
                }
            }
            tt[count++] = max;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(tt[i]);
        }
    }

    private static int sum(int[][] arr, int p, int q, int r, int s) {
        int res = 0;
        for (int i = p; i <= q; i++) {
            for (int j = r; j <= s; j++) {
                res += arr[i][j];
            }
        }
        return res;
    }
}
