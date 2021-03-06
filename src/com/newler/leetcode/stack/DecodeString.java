package com.newler.leetcode.stack;
// [394]、字符串解码

//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 示例: 
//
// 
//s = "3[a]2[bc]", 返回 "aaabcbc".
//s = "3[a2[c]]", 返回 "accaccacc".
//s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
// 
// Related Topics 栈 深度优先搜索


import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "a2[2[cc]]";
        System.out.println(solution.decodeString(s));
    }
    static class Solution {
        public String decodeString(String s) {
            Stack<String > charStack = new Stack();
            Stack<Integer> numStack = new Stack<>();
            StringBuilder result = new StringBuilder();
            int num = 0;
            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    num = num * 10 + c-'0';
                } else if (c == '[') {
                    // 将括号前的数字和字母全部保存，[没有数字填入0
                    numStack.push(num);
                    // [前没有字母填入""
                    charStack.push(result.toString());
                    result = new StringBuilder();
                    num = 0;
                } else if (c == ']') {
                    int curNum = numStack.pop();
                    StringBuilder tmp = new StringBuilder();
                    // 括号内的字符串 * [前的num
                    for (int i = 0; i < curNum; i++) {
                        tmp.append(result);
                    }
                    // lastResult即[前的字母 + num * char
                    result = new StringBuilder(charStack.pop() + tmp);
                } else {
                    // 括号内字母一直加
                    result.append(c);
                }
            }
            return result.toString();
        }
    }
}