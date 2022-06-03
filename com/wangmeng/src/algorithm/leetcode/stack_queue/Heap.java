package algorithm.leetcode.stack_queue;

import java.util.PriorityQueue;

/**
 * @ClassName Heap
 * @Description Java中大顶堆和小顶堆
 *
 * PriorityQueue优先队列
 * 优先队列的作用是能保证每次取出的元素都是队列中权值最小的
 * Java的优先队列每次取最小元素（默认小顶堆），C++的优先队列每次取最大元素（默认大顶堆）
 *
 * 方法：
 * 1. add() 和 offer() 语义相同，都是向优先队列插入元素，
 * 只是是Queue接口规定二者对插入失败时的处理不同，前者在插入失败时抛出异常，后则则会返回false
 *
 * 2. element() 和 peek() 语义完全相同，都是获取但不删除队首元素
 * 二者唯一的区别是当方法失败时前者抛出异常，后者返回null
 *
 * 3. remove() 和 poll()
 * remove()和poll()方法的语义也完全相同，都是获取并删除队首元素
 * 区别是当方法失败时前者抛出异常，后者返回null
 *
 * 实现大堆
 * PriorityQueue实际上是一个堆（不指定Comparator时默认为最小堆）
 * 通过传入自定义的Comparator函数可以实现大顶堆。
 *
 *
 * @Author wangmeng
 * @Date 2021/10/15
 */
public class Heap {
    public static void main(String[] args) {
        new Heap().test1();
    }

    public void test1() {
        PriorityQueue<Integer> integers = new PriorityQueue<>((o1, o2) -> o2 - o1);
        integers.add(1);
        integers.add(2);
        System.out.println(integers.poll());
    }
}
