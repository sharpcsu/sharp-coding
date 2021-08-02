package 剑指offer.h2基础知识;

import java.util.Scanner;

/**
 * 题目:
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * <p>
 * 解析:
 * 需要手动写算法, 不能使用String.replaceAll()
 * Created by sharp on 2017年7月6日19:10:31
 */
public class jz04替换空格 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串: ");
        String str = scanner.nextLine();
        
        String res = strReplace1(str);
        System.out.println("结果为: " + res);
    }
    
    /**
     * 字符串替换为%20
     * <p>
     * 单开一个空间
     *
     * @param str 输入字符串
     * @return 替换后的字符串
     */
    private static String strReplace1(String str) {
        if (str == null) {
            throw new RuntimeException("字符串为空");
        }
        
        //        String res = str.replaceAll(" ", "%20");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    
    
    /**
     * 字符串替换为%20
     * <p>
     * 不开辟额外的空间
     * <p>
     * 解析:每个空格增加额外的两个空间,前一个指针一次移动一格,后一个指针遇到空格移动三格
     *
     * @param str 输入的字符串
     * @return 替换后的字符串
     */
    //TODO:2017/7/6 指针方式适合cpp实现, 考虑idea插件或者直接cpp编译器
    private static String strReplace2(String str) {
        //合法性检查
        if (str == null) {
            throw new RuntimeException("字符串为空");
        }
        
        int num = 0; //空格的个数
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                num++;
            }
        }
        
        int len = num * 2 + str.length();
        char[] arr = new char[len];
        
        return null;
    }
}
