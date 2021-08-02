package 程序员代码面试指南.main;

/**
 * Created by 杨威 on 9/19 0019 - 19:16
 */
public class Test2 {
    public static void main(String[] args) {
        int count = 0;
        int num = 0;
        for (int i = 0; i <= 100; i++) {
            num = num + i;
            count = count++;
        }
        System.out.println(num * count);
    }
}
