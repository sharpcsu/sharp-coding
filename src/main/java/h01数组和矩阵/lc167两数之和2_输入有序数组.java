package h01数组和矩阵;

import org.junit.Test;

/**
 * 给定一个已按照升序排列的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 *  函数应该以长度为2的整数数组的形式返回这两个数的下标值。numbers 的下标从1开始计数 ，所以答案数组应当满足
 *  1 <= answer[0] < answer[1] <= numbers.length 。
 *  你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 *  示例 1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 *  示例 2：
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 *
 *  示例 3：
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 *
 *  提示：
 *  2 <= numbers.length <= 3 * 104
 *  -1000 <= numbers[i] <= 1000
 *  numbers 按 递增顺序 排列
 *  -1000 <= target <= 1000
 *  仅存在一个有效答案
 *
 *  Related Topics 数组 双指针 二分查找
 *  👍 560 👎 0 难度：简单
 *  https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Create by @author sharpyangwei on 2021/8/2 - 下午4:52
 */
public class lc167两数之和2_输入有序数组 {

    @Test
    public void test() {

    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * 借助有序数组的特性
     */
    public int[] twoSum(int[] numbers, int target) {
       int head = 0;
       int tail = numbers.length - 1;


    }

}
