package 程序员代码面试指南.main;

import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();

            if (null == str || "".equals(str)) {
                return;
            }
            String[] strList = str.split(",");

            int result = 0;

            int cur = 0;
            for (int i = 1; i < strList.length; i++) {
                if (i % 2 != 0) {
                    cur = Integer.parseInt(strList[i]) - Integer.parseInt(strList[i - 1]);
                }

                if (cur > result) {
                    result = cur;
                }
            }

            System.out.println(result);
        }
    }
}
