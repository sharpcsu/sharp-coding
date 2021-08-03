package h02链表;

import java.util.Scanner;
import java.util.Stack;

/**
 * 题目:
 
 请编写一个函数，检查链表是否为回文。
 
 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 
 测试样例：
 {1,2,3,2,1}
 返回：true
 {1,2,3,2,3}
 返回：false
 
 解析思路:
 1. 全部放进栈中,出栈后进行比较
 2. 后半部分放进栈中, 出栈后进行比较
 3. 后半部分进行逆转, 然后进行比较。但在返回之前需要对链表恢复原状,否则后序无法使用
 
 * Created by sharp on 2017/7/18 - 15:46
 */
public class nk09链表回文结构 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
    
        SingleNode head = SingleNodeUtils.str2link(str);
//        boolean res1 = isPalindrome1(head);
        boolean res2 = isPalindrome2(head);
//        boolean res3 = isPalindrome3(head);

//        System.out.println(res1);
        System.out.println(res2);
//        System.out.println(res3);
    }
    
    /**
     * 全部放进栈中,出栈后进行比较, 时间复杂度是O(n), 空间复杂度是O(n)
     * @param head 链表头结点
     * @return 是否是回文
     */
    private static boolean isPalindrome1(SingleNode head) {
        if (head == null) {
            return false;
        }
        
        Stack<Integer> stack = new Stack<>();
        SingleNode index = head;
    
        while (index != null) {
            stack.push(index.value);
            index = index.next;
        }
        
        //判断是否是回文
        index = head;
        while (index != null) {
            if (index.value != stack.pop()) {
                return false;
            }
            
            index = index.next;
        }
        
        return true;
    }
    
    /**
     * 后半部分放进栈中, 出栈后进行比较, 时间复杂度是O(n), 空间复杂度是O(n)
     * @param head 链表头结点
     * @return 是否是回文
     */
    private static boolean isPalindrome2(SingleNode head) {
        //合法性检查
        if (head == null) {
            return false;
        }
        
        SingleNode index = head;
        int num = 0;
        Stack<Integer> stack = new Stack<>();
    
        while (index != null) {
            num++;
            index = index.next;
        }
        
        //链表后半部分入栈
        index = head;
        int i;
        for(i = 0; i < (num + 1) / 2; i++) {
            index = index.next;
        }
        
        for(; i < num ; i++) {
            stack.push(index.value);
            index = index.next;
        }
        
        //链表前半部分比较
        index = head;
        for(i = 0; i < num / 2; i++) {
            if (index.value != stack.pop()) {
                return false;
            }
            
            index = index.next;
        }
        
        return true;
    }
    
    /**
     * 后半部分进行逆转, 然后进行比较。但在返回之前需要对链表恢复原状,否则后序无法使用
     * 时间复杂度是O(n), 空间复杂度是O(1)
     * @param head 链表头结点
     * @return 是否是回文
     */
    // TODO: 2017/7/18 太复杂, 没有完成
    private static boolean isPalindrome3(SingleNode head) {
        if (head == null) {
            return false;
        }
        
        SingleNode index = head;
        SingleNode indexPost = head;
        
        int num = 0;
        while (index != null) {
            num++;
            index = index.next;
        }
        
        //
        index = head;
        
        
        return false;
    }
}
