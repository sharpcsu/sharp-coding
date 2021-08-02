package 程序员代码面试指南.main;

/**
 * ?????????????????????????????????????????????
 * Created by 杨威 on 9/19 0019 - 19:10
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.print(getNumber(0));
        System.out.print(getNumber(1));
        System.out.print(getNumber(2));
        System.out.print(getNumber(3));
    }

    public static int getNumber(int num) {
        try {
        int result = 2 / num;
            return result;
        } catch (Exception e) {
            return 0;
        } finally {
            if (num == 0) {
                return -1;
            }

            if (num == 1) {
                return 1;
            }
        }
    }
}
