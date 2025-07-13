package com.leetcode.java.by.company.meta;
/**
 * https://leetcode.com/problems/diameter-of-binary-tree/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Best explanation found by NeedCode - https://www.youtube.com/watch?v=bkxqA8Rfv04&ab_channel=NeetCode
class Solution {
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return diameter;
    }

    private int longestPath(TreeNode node) {
        //Return height of the node which is -1
        if(node == null) 
            return -1;

        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);

        // +2 is two edges of the ncurrent node 
        // one edge is for left node and the other one for right node
        // if there is no right or left node then it will be nuetralized 
        // by -1 that were returned when the node is null 
        diameter = Math.max(diameter, leftPath + rightPath + 2);
        
        //This is the height or level of the node returning but not the actual diameter
        return Math.max(leftPath, rightPath) + 1;
    }
}