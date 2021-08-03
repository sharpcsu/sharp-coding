package h01数组和矩阵;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如如果输入如下矩阵：
 *
 * @author sharp
 * 时间:2017-5-30 上午10:52:18
 */
public class jz20顺时针打印矩阵 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<String>();
        
        String str = scanner.nextLine();
        if(str == null || "".equals(str))
            return;
        
        while (!(str == null || "".equals(str))) {
            list.add(str);
            str = scanner.nextLine();
        }
        
        int rows = list.size();
        int columns = list.get(0).length() / 2 + 1;
        int[][] arr = new int[rows][columns];
        
        for(int i = 0; i < rows; i++) {
            String[] strs = list.get(i).split(" ");
            for(int j = 0; j < columns; j++) {
                arr[i][j] = Integer.parseInt(strs[j]);
            }
        }
        
        打印矩阵(arr, rows, columns);
    }
    
    private static void 打印矩阵(int[][] arr, int rows, int columns) {
        if(arr == null || rows < 1 || columns < 1)
            return;
        
        int start = 0;
        while(start * 2 < rows && start * 2 < columns) {
            打印一环(arr, rows, columns, start);
            
            start++;
        }
    }
    
    private static void 打印一环(int[][] arr, int rows, int columns, int start) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;
        
        //从左到右打印
        for(int i = start; i <= endX; i++) {
            System.out.print(arr[start][i] + "\t");
        }
        
        //从上到下打印
        if(start < endY) {
            for(int i = start + 1; i <= endY; i++) {
                System.out.print(arr[i][endX] + "\t");
            }
        }
        
        //从右到左打印
        if(start < endY && start < endX) {
            for(int i = endX - 1; i >= start; i--) {
                System.out.print(arr[endY][i] + "\t");
            }
        }
        
        //从下到上打印
        if(start < endY - 1 && start < endX) {
            for(int i = endY - 1; i >= start + 1; i--) {
                System.out.print(arr[i][start] + "\t");
            }
        }
    }
}
