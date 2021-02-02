package com.newler.leetcode.binary;
// [153]、寻找旋转排序数组中的最小值

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。 
//
// 请找出其中最小的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -5000 <= nums[i] <= 5000 
// nums 中的所有整数都是 唯一 的 
// nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转 
// 
// Related Topics 数组 二分查找 
// 👍 338 👎 0


public class FindMinimumInRotatedSortedArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            int left = 0, right = nums.length - 1;

            // 单调递增
            if (nums[right] > nums[left]) {
                return nums[0];
            }
            while (left < right) {
                int mid = (right + left) / 2;

                if (nums[mid] > nums[right]) {
                    // 如果左边单调递增，找右边
                    left = mid + 1;
                } else {
                    // 如果右边单调递增，找左边
                    // 由于mid也小于边界值，mid可能也是最小值
                    right = mid;
                }
            }
            return nums[left];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}