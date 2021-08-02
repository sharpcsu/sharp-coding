package 字符串;

import java.util.Scanner;

/**
 * 题目:
 *
 请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，
 并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
 
 给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。
 
 测试样例：
 "Mr John Smith”,13
 返回："Mr%20John%20Smith"
 ”Hello  World”,12
 返回：”Hello%20%20World”
 
 * Created by sharp on 2017年7月13日23:21:23
 */
public class nk10空格替换 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
    
        String res = replaceSpace(str, str.length());
        System.out.println(res);
    }
    
    public static String replaceSpace(String iniString, int length) {
        //合法性检查
        if (iniString == null || length < 0) {
            return null;
        }
        
        int num = 0;
        for(int i = 0; i < length; i++) {
            if (iniString.charAt(i) == ' ') {
                num++;
            }
        }
    
        char[] chs = new char[length + num * 2];
        
        for(int i = length - 1, j = chs.length - 1; i >= 0; i--) {
            if (iniString.charAt(i) == ' ') {
                //替换为为%20
                chs[j--] = '0';
                chs[j--] = '2';
                chs[j--] = '%';
            } else {
                //直接移动
                chs[j--] = iniString.charAt(i);
            }
        }
        
        return new String(chs);
    }
}
