package h03栈和队列;


import java.util.Scanner;
import java.util.Stack;

/**
 * 题目:定义栈的数据结构,请在该类型中实现一个能够得到栈的最小元素的min函数。
 * 在该栈中，调用min、push及pop的时间复杂度都是O(1)。
 *
 * @author sharp
 * 时间:2017-5-30 下午12:14:33
 */
public class jz21包含min函数的栈 {
    public static void main(String[] args) {
        
        Stack<Integer> data = new Stack<Integer>();
        Stack<Integer> min = new Stack<Integer>();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入1, 2, 3分别表示入栈, 出栈, 最小值");
        String str = scanner.nextLine();
        while(!(str == null || "".equals(str))) {
            String[] strs = str.split(" ");
            int n = Integer.parseInt(strs[0]);
            switch (n) {
                case 1:
                    入栈(data, min, Integer.parseInt(strs[1]));
                    break;
                case 2:
                    int num = 出栈(data, min);
                    System.out.println("出栈: " + num);
                    break;
                case 3:
                    int minNum = min(min);
                    System.out.println("最小值: " + minNum);
                    break;
                default :
                    
                    break;
            }
            
            str = scanner.nextLine();
        }
    }
    
    private static void 入栈(Stack<Integer> data, Stack<Integer> min, int value) {
        if(data ==null || min == null) {
            return;
        }
        
        if(min.size() == 0 || value < min.peek()) {
            min.push(value);
        } else {
            min.push(min.peek());
        }
        
        data.push(value);
    }
    
    private static int 出栈(Stack<Integer> data, Stack<Integer> min) {
        if(data == null || min == null || data.size() == 0 || min.size() == 0) {
            return -1;
        }
        
        min.pop();
        return data.pop();
    }
    
    private static int min(Stack<Integer> min) {
        if(min == null || min.size() == 0) {
            return -1;
        }
        
        return min.peek();
    }
}
