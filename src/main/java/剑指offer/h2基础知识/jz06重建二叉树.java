package 剑指offer.h2基础知识;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import 剑指offer.h1公共类.StrUtils;
import 剑指offer.h1公共类.Tree;
import 剑指offer.h1公共类.TreeUtils;

/**
 * 题目:
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * <p>
 * Created by sharp on 2017年7月7日13:48:00
 */
// TODO: 2017/7/7 测试未通过 需要学习.哎,是的, 没办法啊.是的
public class jz06重建二叉树 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入前序序列: ");
        String preStr = scanner.nextLine();
        System.out.println("请输入中序序列: ");
        String inStr = scanner.nextLine();
        
        int[] pre = StrUtils.str2arrs(preStr);
        int[] in = StrUtils.str2arrs(inStr);
        
        Tree tree = reConstructBinaryTree(pre, in);
        TreeUtils.printTreeByPre(tree);
    }
    
    
    /**
     * 根据前序遍历和中序遍历重建二叉树并返回
     *
     * @param pre 前序遍历
     * @param in  中序遍历
     * @return 二叉树的根结点
     */
    private static Tree reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        
        Tree head = new Tree(pre[0]);
        
        if (pre.length == 1) {
            return head;
        }
        
        List<Integer> leftPre = new ArrayList<>(); //左子树的前序
        List<Integer> leftIn = new ArrayList<>(); //左子树的中序
        List<Integer> rightPre = new ArrayList<>(); //右子树的前序
        List<Integer> rightIn = new ArrayList<>(); //右子树的中序
        
        
        int i = 0;
        while (i < in.length) {
            if (head.value == in[i]) {
                break;
            } else {
                leftPre.add(pre[i + 1]);
                leftIn.add(in[i]);
                
            }
            
            i++;
        }
        
        while (i < in.length - 1) {
            rightPre.add(pre[i++]);
            rightIn.add(in[i++]);
        }
    
        Integer[] a = new Integer[1];
    
        //递归重建左子树和右子树
        head.left = reConstructBinaryTree(list2arr(leftPre), list2arr(leftIn));
        head.right = reConstructBinaryTree(list2arr(rightPre), list2arr(rightIn));
        
        return head;
    }
    
    /**
     * list类型转数组
     *
     * @param list list数据
     * @return int类型的数组
     */
    private static int[] list2arr(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        
        return arr;
    }
    
    
}
