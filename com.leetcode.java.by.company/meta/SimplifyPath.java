package com.leetcode.java.by.company.meta;
/**
 * https://leetcode.com/problems/simplify-path/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 * 
 */

// 

// https://www.youtube.com/watch?v=qYlHrAKJfyA&ab_channel=NeetCode

class Solution {
    public String simplifyPath(String path) {
        
        // if(path.length() < 1 || path.length() > 3000 )
        //     return null;

        Stack<String> stack = new Stack<String>();

        String[] strArr = path.split("\\/");

        for(String str: strArr) {
            // if("..".equals(str)) {
            //     if(!stack.empty()) {
            //         stack.pop();
            //     }
            // } else if(!".".equals(str) && !"/".equals(str) && !"".equals(str)){
            //     // do nothing
            //     stack.push(str);
            // }

            switch(str) {
                case "..":
                    if(!stack.empty()) {
                        stack.pop();
                    }
                    break;
                case ".":
                case "/":
                case "":
                    break;
                default:
                   stack.push(str);
                   break;
            }
        }
        String result = "";
        while(!stack.isEmpty()) {
            String strVal = stack.pop();
            result = "/"+strVal+result;
        }

        if(result== "") {
            result = "/";
        }

        return result;
    }
}