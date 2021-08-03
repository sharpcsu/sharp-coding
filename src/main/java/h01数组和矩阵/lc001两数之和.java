package h01数组和矩阵;

import org.junit.Test;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target  的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 *  示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 *  示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 *  示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 *
 *  提示：
 *
 *  2 <= nums.length <= 104
 *  -109 <= nums[i] <= 109
 *  -109 <= target <= 109
 *  只会存在一个有效答案
 *
 *  进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 *  Related Topics 数组 哈希表
 *  👍 11707 👎 0 难度：简单
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 *
 * 思路：
 * 使用哈希表，将寻找target - x 的时间复杂度降低到 O(1)
 *
 * Create by @author 杨威 on 2021/8/1 0001 - 20:01
 */
public class lc001两数之和 {

    @Test
    public void test() {
        int[] ints1 = twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i : ints1) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] ints2 = twoSum(new int[]{3, 2, 4}, 6);
        for (int i : ints2) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] ints3 = twoSum(new int[]{3, 3}, 6);
        for (int i : ints3) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 哈希表法
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }

            hashMap.put(nums[i], i);
        }

        return new int[0];
    }
}
