package 程序员代码面试指南.main;

import java.util.Scanner;

/**
 * 有n个人围成一圈, 顺序排号,从第一个人人开始报数(从1到4报数), 凡报到4的人退出圈子, 问n=78,
 * 最后留下来的是原来第几号
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个正整数：");
        int num = input.nextInt();
        int[] nums = new int[num];
        for (int i = nums.length - 1; i >= 0; i--) {
            nums[i] = i + 1;
        }
        // 数组定义完毕
        int i = 0;
        int count = 0;

        boolean flag = false;
        int temp1 = -1, temp2 = -1;
        while (!flag) {

            if (nums[i] == 0) {
                i++;
                if (i == nums.length)// 到头循环
                    i = 0;

                continue;
            }
            count++;// 计数还在游戏中的人所报的数

            if (count == 1)// 报数时报到1的人
                temp1 = i;

            if (count == 2)// 报数时报到2的人
                temp2 = i;

            if (temp1 == temp2) {// 如果报数报到1的人等于报数报到2的人 只剩1人，退出，输出此人
                flag = true;
                continue;
            }

            if (count == 4) { // 报到4的人退出
                count = 0;
                nums[i] = 0;
                // num--;

            }
            // if(num == 1)
            // break;

            i++;
            if (i == nums.length)// 到头循环
                i = 0;

        }
        System.out.println(nums[i]);
    }
}