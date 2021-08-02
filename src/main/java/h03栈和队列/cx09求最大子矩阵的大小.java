package h03栈和队列;

import java.util.Scanner;
import java.util.Stack;

/**
 * 题目: 给定一个整形矩阵map, 其中的值只有0和1两种, 求其中全是1的所有矩形区域中,
 * 最大的矩形区域为1的数量.
 * <p>
 * 例如:
 * 1 1 1 0
 * 其中,最大的矩形区域有3个1, 所以返回3.
 * 再如:
 * 1 0 1 1
 * 1 1 1 1
 * 1 1 1 0
 * 其中, 最大的矩形区域有6个1, 所以返回6.
 * <p>
 * <p>
 * Created by 杨威 on 9/18 0018 - 8:06
 */
public class cx09求最大子矩阵的大小 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        
        int res = maxRecSize(arr);
        System.out.println(res);
    }
    
    public static int maxRecSize(int[][] map) {
        if(map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }
        
        return maxArea;
    }
    
    public static int maxRecFromBottom(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        
        return maxArea;
    }
}