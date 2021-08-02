package 程序员代码面试指南.第5章字符串问题;


import java.util.Scanner;

/**
 * 题目: 给定一个字符串str, 返回str的统计字符串. 例如, "aaabbadddffc"的统计字符串为"a_3_b_2_a_1_d_3_f_2_c_1"
 * Created by sharp on 2016/8/29 - 11:15
 */
public class _7字符串的统计字符串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        
        String res = getCountString(str);
        System.out.println("计算结果是: " + res);
    }
    
    public static String getCountString(String str) {
        if (str == null || str.equals(""))
            return "";
        
        char[] charStr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(charStr[0]);
        int count = 1;
        
        for (int i = 1; i < charStr.length; i++) {
            if (charStr[i] == charStr[i - 1]) {
                count++;
            } else {
                sb = sb.append("_" + count + "_" + charStr[i]);
                count = 1;
            }
        }
        
        sb.append("_" + count);
        return sb.toString();
    }
}
