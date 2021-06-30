package algorithm.leetcode.basic;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName StackAndQueue
 * @Description java对栈和队列的封装
 * @Author wangmeng
 * @Date 2021/6/28
 */
public class StackAndQueue {
    public static void main(String[] args) {
        new StackAndQueue().stack2();
    }

    /**
     * stack
     */
    public void stack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }

    /**
     * stack 2
     *
     * 用LinkedList实现栈
     */
    public void stack2() {
        Deque<Integer> stack = new LinkedList<>();
        stack.offerLast(1);
        stack.offerLast(2);
        System.out.println(stack.pollFirst());
    }

    /**
     * 队列
     */
    public void queue() {
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
//        System.out.println(queue.peek());
//        System.out.println(queue.poll());
//        System.out.println(queue.peek());
//        System.out.println(queue.isEmpty());
        for (Integer i : queue) {
            System.out.println(i);
        }
    }
}
