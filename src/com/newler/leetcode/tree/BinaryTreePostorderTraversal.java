package com.newler.leetcode.tree;
// [145]、二叉树的后序遍历
// 2020年7月15日21:54:07
//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


import com.newler.leetcode.data.TreeNode;

import java.util.*;

public class BinaryTreePostorderTraversal {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    // 递归
    class Solution {
        private List<Integer> results = new ArrayList<>();

        public List<Integer> postorderTraversal(TreeNode root) {
            travesal(root);
            return results;
        }

        public void travesal(TreeNode root) {
            if (root == null) return;
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            results.add(root.val);
        }
    }

    // 非递归，模拟栈
    class Solutionn {
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) return  Collections.emptyList();

            Stack<TreeNode> stack = new Stack<TreeNode>();
            List<Integer> results = new ArrayList<>();
            stack.push(root);

            while(!stack.isEmpty()) {
                TreeNode top = stack.pop();
                if (top != null) {
                    stack.push(top);
                    stack.push(null);
                    if (top.right != null) stack.push(top.right);
                    if (top.left != null) stack.push(top.left);
                } else {
                    results.add(stack.pop().val);
                }
            }
            return results;
        }
    }
}
