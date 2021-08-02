package 程序员代码面试指南.main;

import java.util.Scanner;

public class Main9
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int res = 0;
        for(int i=5; i<=n; i*=5)
        {
            res += n/i;
        }

        System.out.println(res);
    }
}