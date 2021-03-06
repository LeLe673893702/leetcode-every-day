package com.newler.leetcode.tree;
// [144]、二叉树的前序遍历
// ${DATE}
//给定一个二叉树，返回它的 前序 遍历。 
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
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


import com.newler.leetcode.data.ListNode;
import com.newler.leetcode.data.TreeNode;

import java.util.*;

public class BinaryTreePreorderTraversal {
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
    class Solution {
        /**
         * 先序遍历 根-左-右
         */
        List<Integer> results = new LinkedList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            traverse(root);
            return results;
        }

        public void traverse(TreeNode root) {
            if (root == null) return;
            results.add(root.val);
            traverse(root.left);
            traverse(root.right);
        }


    }
    class Solution2 {
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) return  Collections.emptyList();
            Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
            List<Integer> results = new ArrayList<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                if (root == null) {
                    root = stack.pop().right;
                    continue;
                }
                results.add(root.val);
                stack.push(root);
                root = root.left;
            }
            return results;
        }
    }

    class Solution3 {
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) return  Collections.emptyList();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            List<Integer> results = new ArrayList<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                root = stack.pop();
                if (root != null) {
                    if (root.right != null) {
                        stack.push(root.right);
                    }
                    if (root.left != null) {
                        stack.push(root.left);
                    }
                    stack.push(root);
                    stack.push(null);
                } else {
                    results.add(stack.pop().val);
                }
            }
            return results;
        }
    }

}

