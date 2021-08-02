package 程序员代码面试指南.第5章字符串问题;

import java.util.Scanner;

/**
 * 题目: 给定三个字符串str, from和to, 已知from字符串中无重复字符, 把str中所有from的子串全部替换成to
 * 字符串, 对连续出现from的部分要求只替换成一个to字符串, 返回最终的结果字符串.
 * Created by sharp on 2016/8/27 - 17:44
 */
public class _6替换字符串中连续出现的指定字符串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String from = scanner.nextLine();
        String to = scanner.nextLine();
        
        String result = replace(str, from, to);
        System.out.println("计算结果是: " + result);
    }
    
    public static String replace(String str, String from, String to) {
        if (str == null || str.equals("") || from == null || from.equals("") || to == null || to.equals(""))
            return str;
        
        char[] chars = str.toCharArray();
        char[] charf = from.toCharArray();
        int match = 0;
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == charf[match++]) {
                if(match == charf.length) {
                    clear(chars, i, charf.length);
                    match = 0;
                }
            } else {
                if(chars[i] == charf[0]) {
                    i--;
                }
                match = 0;
            }
        }
        
        String res = "";
        String cur = "";
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] != 0) {
                cur = cur + String.valueOf(chars[i]);
            }
            
            if(chars[i] == 0 && (i == 0 || chars[i - 1] != 0)) {
                res = res + cur + to;
                cur = "";
            }
        }
        
        if(!cur.equals("")) {
            res = res + cur;
        }
        
        return res;
    }
    
    public static void clear(char[] chars, int end, int length) {
        while(length-- > 0) {
            chars[end--] = 0;
        }
    }
}

