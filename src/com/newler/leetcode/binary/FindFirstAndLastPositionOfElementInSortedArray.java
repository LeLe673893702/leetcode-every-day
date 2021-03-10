package com.newler.leetcode.binary;
// [34]、在排序数组中查找元素的第一个和最后一个位置

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 887 👎 0


public class FindFirstAndLastPositionOfElementInSortedArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            int findIndex = l;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (target < nums[mid]) {
                    r = mid - 1;
                } else if (target > nums[mid]){
                    l = mid + 1;
                } else {
                    findIndex = mid;
                    break;
                }
            }
            int startIndex = findIndex;
            int endIndex = findIndex;
            while (true) {
                boolean a = startIndex >= 0 && nums[startIndex] != target;
                if (a) {
                    startIndex--;
                }
                boolean b = endIndex < nums.length && nums[endIndex] != target;
                if (b) {
                    endIndex++;
                }

                if (!a && !b) {
                    return new int[]{startIndex, endIndex};
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}