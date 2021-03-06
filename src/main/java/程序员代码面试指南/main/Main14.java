package 程序员代码面试指南.main;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 题目描述：
 * 头条的2017校招开始了！为了这次校招，我们组织了一个规模宏大的出题团队。
 * 每个出题人都出了一些有趣的题目，而我们现在想把这些题目组合成若干场考试出来。
 * 在选题之前，我们对题目进行了盲审，并定出了每道题的难度系数。一场考试包含3道开放性题目，
 * 假设他们的难度从小到大分别为a, b, c，我们希望这3道题能满足下列条件：
 * a <= b <= c
 * b - a <= 10
 * c - b <= 10
 * 所有出题人一共出了n道开放性题目。现在我们想把这n道题分布到若干场考试中（1场或多场，
 * 每道题都必须使用且只能用一次），然而由于上述条件的限制，可能有一些考试没法凑够3道题，
 * 因此出题人就需要多出一些适当难度的题目来让每场考试都达到要求。然而我们出题已经出得很累了，
 * 你能计算出我们最少还需要再出几道题吗？
 * <p>
 * <p>
 * 输入
 * 输入的第一行包含一个整数n，表示目前已经出好的题目数量。
 * 第二行给出每道题目的难度系数 d1, d2, …, dn。
 * <p>
 * 输出
 * 输出只包括一行，即所求的答案。
 * <p>
 * 样例输入
 * 4
 * 20 35 23 40
 * 样例输出
 * 2
 * Created by 杨威 on 9/21 2016 - 20:13
 */
public class Main14 {
    public static LinkedList<Integer> queue = new LinkedList<>();
    public static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            queue.add(arr[i]);
        }

        for (int i = 3; i < n; i++) {
            countPP(arr[i]);
        }
    }

    private static void countPP(int i) {
    }


}
