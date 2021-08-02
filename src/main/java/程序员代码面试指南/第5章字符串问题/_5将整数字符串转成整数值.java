package 程序员代码面试指南.第5章字符串问题;

import java.util.Scanner;

/**
 * 题目: 给定一个字符串str, 如果str符合日常书写的整数格式,
 * 并且属于32位整数的范围, 返回str所代表的整数值, 否则返回0.
 * Created by sharp on 2016/8/22 - 21:04
 */
public class _5将整数字符串转成整数值 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        
        int result = convert(str);
        System.out.println("计算结果是: " + result);
    }
    
    public static int convert(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        
        char[] charArr = str.toCharArray();
        
        if (!isValid(charArr))
            return 0;
        
        boolean posi = charArr[0] == '-' ? false : true;
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;
        int res = 0;
        int cur = 0;
        for(int i = posi ? 0 : 1; i < charArr.length; i++) {
            cur = '0' - charArr[i];
            if((res < minq) || (res == minq && cur < minr)) {
                return 0; //不能转, 下溢
            }
            res = res * 10 + cur;
        }
        
        if(posi && res == Integer.MIN_VALUE) {
            return 0; //不能转, 上溢
        }
        
        return posi ? -res : res;
    }
    
    private static boolean isValid(char[] charArr) {
        if (charArr[0] != '-' && (charArr[0] < '0' || charArr[0] > '9')) {
            return false;
        }
        
        if (charArr[0] == '-' && (charArr.length == 1 || charArr[1] == '0')) {
            return false;
        }
        
        if (charArr[0] == '0' && charArr.length > 1) {
            return false;
        }
        
        for(int i = 1; i < charArr.length; i++) {
            if(charArr[i]<'0' || charArr[i] > '9')
                return false;
        }
        
        return true;
    }
}

