package 剑指offer.h1公共类;

/**
 * Created by sharp on 2017/7/7 - 14:01
 */

import java.util.List;

/**
 * 二叉树的一些公共操作
 *
 * Created by sharp on 2017/7/7 - 13:42
 */
public class TreeUtils {
    
    
    /**
     * 字符串转二叉树
     *
     * @param str 二叉树的字符串表示
     * @return 二叉树的根
     */
    public static Tree str2tree(String str) {
        // TODO: 2017/7/7 需要实现
        return null;
    }
    
    /**
     * 先序打印二叉树
     *
     * @param head 二叉树根结点
     */
    public static void printTreeByPre(Tree head) {
        // TODO: 2017/7/7 没有实现
    }
    
    /**
     * 公共类
     * Created by sharp on 2017/7/6 - 19:11
     */
    public static class ComUtils {
        
        /**
         * 打印二维数组
         *
         * @param array 二维数组
         */
        private static void printTwoArrays(int[][] array) {
            System.out.println("打印结果为: ");
            
            int size = array.length;
            int length = array[0].length;
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < length; j++) {
                    System.out.print(array[i][j] + "\t");
                }
                
                System.out.println();
            }
        }
        
        /**
         * 多行字符串转二维数组
         *
         * @param list 二维字符串
         * @return 二维数组
         */
        public static int[][] strToTwoArrays(List<String> list) {
            int size = list.size(); //行数
            int[][] array = new int[size][];
            
            for (int i = 0; i < size; i++) {
                String[] ss = list.get(i).split(" ");
                int len = ss.length;
                array[i] = new int[len];
                for (int j = 0; j < len; j++) {
                    array[i][j] = Integer.valueOf(ss[j]);
                }
            }
            
            return array;
        }
    }
}