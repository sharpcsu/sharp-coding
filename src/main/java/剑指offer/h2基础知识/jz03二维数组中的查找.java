package 剑指offer.h2基础知识;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import 剑指offer.h1公共类.TreeUtils;

/**
 * 题目:
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 思路:
 * 从右上角或者左下角开始, 简化数组的复杂性
 * <p>
 * Created by sharp on 2017/7/6 - 16:32
 */
public class jz03二维数组中的查找 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String str;
        System.out.println("请输入二维数组:");
        
        while (!(str = scanner.nextLine()).equals("")) {
            list.add(str);
        }
        
        //字符串转二维数组
        int[][] arr = TreeUtils.ComUtils.strToTwoArrays(list);
        
        System.out.println("请输入要查找的数值:");
        int num = scanner.nextInt();
        
        //查找二维数组中是否包含num
        boolean res = checkNumFromArrays(arr, num);
        System.out.println("执行结果为: " + res);
        
        //打印二维数组
//        printArrays(arr);
    }
    
    /**
     * 判断二维数组中是否包含num
     *
     * 思路:
     * 从右上角或者左下角开始, 简化数组的复杂性
     *
     * @param arr
     * @param num
     * @return
     */
    private static boolean checkNumFromArrays(int[][] arr, int num) {
        //合法性判断
        if (arr == null) {
            throw new RuntimeException("数组为空");
        }
        
        int beginI = 0;
        int endI = arr[0].length - 1;
        int beginJ = 0;
        int endJ = arr.length - 1;
        
        //从右上角或者左下角开始, 简化数组的复杂性
        while (beginI <= endI && beginJ <= endJ) {
            if (num < arr[beginI][endJ]) {
                endJ--;
            } else if (num > arr[beginI][endJ]) {
                beginI++;
            } else {
                return true;
            }
        }
        
        return false;
        
    }

}
