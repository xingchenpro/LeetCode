package com.stardust.offer;

import java.util.Stack;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @CSDN :blog.csdn.net/Sirius_hly
 * @WeChat :xcvip2021
 * @date :2021/4/22
 * @desc :
 */
public class CQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    public CQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    //进的时候直接进
    public void appendTail(int value) {
        in.push(value);
    }

    //出去的时候，out 有数，就直接弹出
    //out 没有数，in 出栈，放入 out
    //由于栈先进后出，所以新进去的书最后弹出，放到 out 的时候，再弹出，就等于先进去的数先弹出了
    public int deleteHead() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        if (!out.isEmpty()) {
            return out.pop();
        }
        return -1;
    }

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());


    }


}
