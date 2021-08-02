package h01数组;

import org.junit.Test;

import java.util.Scanner;

/**
 * 题目:
 * 在一个二维数组中, 每一行都按照从左到右递增的顺序排序, 每一列都按照从上到下递增的循序排序.
 * 请完成一个函数, 输入这样一个二维数组和一个整数, 判断数组中是否含有该整数.
 * Create by @author sharpyangwei on 2021/8/2 - 下午8:35
 */
public class jz03二维数组中的查找 {
    @Test
    public void test() {
        Scanner scanner = new Scanner(System.in);

        int[][] arr = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println("请输入一个整数:");
        int num = scanner.nextInt();

        method(arr, num);
    }

    public void method(int[][] arr, int num) {
        int row = arr.length - 1;
        int column = arr[0].length - 1;

        int i = 0;
        int j = column;

        while (true) {
            if (i < 0 || i >= row || j < 0 || j >= column) {
                System.out.println("矩阵不包含该数组");
                break;
            }

            if (arr[i][j] > num) {
                j--;
            } else if (arr[i][j] < num) {
                i++;
            } else {
                System.out.println("矩阵为:");
                for (int m = 0; m < arr.length; m++) {
                    for (int n = 0; n < arr[0].length; n++) {
                        System.out.print(arr[m][n] + "\t");
                    }
                    System.out.println();
                }
                System.out.println("数组包含该整数, 下标为" + i + " ," + j);
                return;
            }
        }
    }

}
