package h01数组和矩阵;

import org.junit.Test;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *  初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *  示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 *
 *  示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 *  提示：
 *  nums1.length == m + n
 *  nums2.length == n
 *  0 <= m, n <= 200
 *  1 <= m + n <= 200
 *  -109 <= nums1[i], nums2[i] <= 109
 *
 *  Related Topics 数组 双指针 排序
 *  👍 1039 👎 0 难度：简单
 *  https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * Create by @author sharpyangwei on 2021/8/2 - 下午4:30
 */
public class lc088合并两个有序数组 {

    @Test
    public void test() {
        int[] nums11 = {1, 2, 3, 0, 0, 0};
        int[] nums12 = {2, 5, 6};
        merge(nums11, 3, nums12, 3);
        ArrayUtil.print(nums11);

        int[] nums21 = {1};
        int[] nums22 = {};
        merge(nums21, 1, nums22, 0);
        ArrayUtil.print(nums21);
    }

    /**
     * 逆向双指针
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(1)
     *
     * 思路：指针从后向前遍历，每次取两者之中较大者放进nums1的最后面
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;

        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                nums1[tail--] = nums2[p2--];
            } else if (p2 == -1) {
                nums1[tail--] = nums1[p1--];
            } else if (nums1[p1] >= nums2[p2]) {
                nums1[tail--] = nums1[p1--];
            } else {
                nums1[tail--] = nums2[p2--];
            }
        }
    }
}
