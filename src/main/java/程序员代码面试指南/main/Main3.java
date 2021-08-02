package 程序员代码面试指南.main;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int count = 0;
            int[] arr = new int[n];
            for (int i = 0; i < (int)Math.pow(3, n); i++) {
                int t = i;
//                System.out.println(i);
                for (int j = 0; j < n; j++) {
                    arr[j] = t % 3;
                    t /= 3;
                }

                boolean b = method(arr);
                if (!b) {
                    count++;
                }

            }
            System.out.println(count);
        }
    }

    private static boolean method(int[] arr) {
//        System.out.println("shuchushuzu");
//        for(int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
        for (int i = 0; i < arr.length - 2; i++, i++) {
            if ((arr[i] != arr[i + 1]) && (arr[i + 1] != arr[i + 2]) && (arr[i] != arr[i + 2])) {
                return true;
            }
        }
        return false;
    }
}
