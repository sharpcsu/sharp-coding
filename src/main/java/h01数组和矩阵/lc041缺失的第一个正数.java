package h01数组和矩阵;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 *
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 *
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 *
 *  提示：
 *  1 <= nums.length <= 5 * 105
 *  -231 <= nums[i] <= 231 - 1
 *
 *  Related Topics 数组 哈希表
 *  👍 1152 👎 0 难度：高
 *  https://leetcode-cn.com/problems/first-missing-positive/
 *
 * Create by @author 杨威 on 2021/8/1 0001 - 18:19
 */
// TodoSharp: 2021/8/3 不太懂
public class lc041缺失的第一个正数 {

    @Test
    public void test() {
        int[] ints1 = {1,2,0};
        int[] ints2 = {3,4,-1,1};
        int[] ints3 = {7,8,9,11,12};

        int result1 = firstMissingPositive1(ints1);
        Assert.assertEquals(result1, 3);
        int result2 = firstMissingPositive1(ints2);
        Assert.assertEquals(result2, 2);
        int result3 = firstMissingPositive1(ints3);
        Assert.assertEquals(result3, 1);
    }


    /**
     * 哈希表法
     */
    public int firstMissingPositive1(int[] nums) {
        int n = nums.length;
        //将负数变为 n + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        //将 <= n 的元素对应的位置变为负数
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        //返回第一个大于0的元素下标 + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

}
