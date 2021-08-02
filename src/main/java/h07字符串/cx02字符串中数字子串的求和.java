package h07字符串;

import java.util.Scanner;

/**
 * 题目: 给定一个字符串str, 求其中全部数字串所代表的数字之和
 * 要求: 忽略小数点字符, 如果紧贴数字子串的左侧出现字符"-", 当连续出现的数量为奇数时, 则数字为负,
 * 连续出现的数字为偶数时, 则数字为正. 例如"a-1bc-12"包含-1和12
 * Created by sharp on 2016/8/22 - 10:20
 */
public class cx02字符串中数字子串的求和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String str = scanner.nextLine().trim();
        
        int result = numSum(str);
        System.out.println("计算结果是: " + result);
    }
    
    public static int numSum(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        
        int sum = 0;//总和
        int num = 0;//当前结果
        boolean posi = true;//标记正负
        int cur = 0;
        
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            cur = charArr[i] - '0';
            if (cur < 0 || cur > 9) {
                if (posi) {
                    sum += num;
                } else {
                    sum -= num;
                }
                
                num = 0;
                
                if (charArr[i] == '-') {
                    posi = !posi;
                } else {
                    posi = true;
                }
            } else {
                num = num * 10 + cur;
            }
        }
        
        sum += num;
        return sum;
    }
}

