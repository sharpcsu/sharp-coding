package 程序员代码面试指南.main;

import java.util.Scanner;

public class Main10 {

    static int startI = 1, startJ = 1;  // 入口
    static int endI = 5, endJ = 5;  // 出口
    static int success = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int p = scanner.nextInt();
//
//        int[][] arr = new int[n][m];
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                arr[i][j] = scanner.nextInt();
//            }
//        }
    
        int[][] maze = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }

        int i, j;
        System.out.println("显示迷宫：\n");
        for(i = 0; i < 7; i++)
        {
            for(j = 0; j < 7; j++)
            {
                if(maze[i][j] == 2)
                    System.out.println("█");
                else
                    System.out.println("  ");
            }
            System.out.println("\n");
        }
        if(visit(startI, startJ, maze) == 0)
        {
            System.out.println("\n没有找到出口！\n");
        }
        else
        {
            System.out.println("\n显示路径：\n");
            for(i = 0; i < 7; i++)
            {
                for(j = 0; j < 7; j++)
                {
                    if(maze[i][j] == 2)
                        System.out.println("█");
                    else if(maze[i][j] == 1)
                        System.out.println("◇");
                    else
                        System.out.println("  ");
                }
                System.out.println("\n");
            }
        }

    }

    public static int visit(int i, int j, int[][] maze)
    {
        //该点走过，标记为1
        maze[i][j] = 1;
        //走到终点，成功
        if(i == endI && j == endJ)
            success = 1;
        //向四个方向递归调用函数visit()
        if(success != 1 && maze[i][j+1] == 0) visit(i, j+1, maze);
        if(success != 1 && maze[i+1][j] == 0) visit(i+1, j, maze);
        if(success != 1 && maze[i][j-1] == 0) visit(i, j-1, maze);
        if(success != 1 && maze[i-1][j] == 0) visit(i-1, j, maze);

        //该点走过，但没成功，则该点重新置为0
        if(success != 1)
            maze[i][j] = 0;

        return success;
    }
}
