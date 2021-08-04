package h01数组和矩阵;

/**
 * Create by @author 杨威 on 2021/8/3 0003 - 22:34
 */
public class ArrayUtil {
    public static void print(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
