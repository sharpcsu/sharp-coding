package 程序员代码面试指南.main;

public class Main15 {
    public static void main(String[] args) {
        for (int i = 2; i < 1000; i++) {
            int j;
            for(j = 2; j < i / 2 + 1; j++) {
                if (i % j == 0) {
                    break;
                }
            }

            if (!(j < i / 2 + 1)) {
                System.out.println(i);
            }
        }
    }
}
