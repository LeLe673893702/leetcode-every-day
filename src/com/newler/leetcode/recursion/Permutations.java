package com.newler.leetcode.recursion;
// [46]、全排列
// 2020年8月24日10:02:23
//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 852 👎 0


import com.newler.leetcode.utils.Swaps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2};
        solution.permute(nums);
    }

    static class Solution {
        private List<List<Integer>> results = new LinkedList<>();
        public List<List<Integer>> permute(int[] nums) {
            backTrack(0, nums, new ArrayList<>());
            return results;
        }

        private void backTrack(int cur, int[] nums, List<Integer> paths) {
            if (paths.size() == nums.length) {
                results.add(new ArrayList<>(paths));
                return;
            }

            for (int i = cur; i < nums.length; i++) {
                paths.add(nums[i]);
                Swaps.swapIntArray(nums, i, cur);
                int tmp = i;
                i = cur;
                cur = tmp;
                backTrack(i+1, nums, paths);
                paths.remove(paths.size() - 1);
                Swaps.swapIntArray(nums, i, cur);
                tmp = i;
                i = cur;
                cur = tmp;
            }
        }


    }
}

