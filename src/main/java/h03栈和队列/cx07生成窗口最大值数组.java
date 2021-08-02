package h03栈和队列;

import java.util.Scanner;

/**
 * 题目：
 * 有一个整形数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右边滑动一个位置。
 * 如果数组长度为n，窗口大小为w，则一共产生n-w+1个窗口的最大值。
 *
 * 请实现一个函数。
 * 输入：整型数组arr，窗口大小为w
 * 输出：一个长度为n-w+1的数组res， res[i]表示每一种窗口状态下的最大值。
 *
 * Created by sharp on 7/2 0002 - 13:20
 */
public class cx07生成窗口最大值数组 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[1024];
        int size = 0;
        
        System.out.println("请输入整型数组");
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            arr[i] = new Integer(split[i]);
            size++;
        }
        
        System.out.println("请输入窗口的大小");
        s = scanner.nextLine();
        int w = new Integer(s);
        
        int[] result = method(arr,size,  w);
        System.out.println("窗口最大值数组是:");
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
    
    /**
     * 生成窗口最大值数组
     * @param arr 数组
     * @param size 数组的大小
     * @param w 窗口尺寸
     * @return 窗口最大值数组
     */
    private static int[] method(int[] arr, int size, int w) {
        int[] result = new int[size - w + 1];
        int max = arr[0];
        
        for (int i = w - 1; i < size; i++) {
            max = arr[i];
            for (int j = i - w + 1; j < i; j++) {
                if (max < arr[j]) {
                    max = arr[j];
                }
            }
            
            result[i - w + 1] = max;
        }
        return result;
    }
}