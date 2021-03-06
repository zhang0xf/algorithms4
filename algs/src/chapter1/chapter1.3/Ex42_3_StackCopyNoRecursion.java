/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

// No Recursion Method

import edu.princeton.cs.algs4.StdOut;

public class Ex42_3_StackCopyNoRecursion<Item> {

    private int N;
    private Node first;

    public class Node {

        Node() {
            // 默认构造函数
        }

        // 非递归拷贝，只需提供单个节点的拷贝方法！还是递归比较神奇！
        Node(Node x) {
            this.item = x.item;
            this.next = x.next;
        }

        Item item;
        Node next;
    }

    public Ex42_3_StackCopyNoRecursion() {
        // 默认构造函数
    }

    // 拷贝构造函数
    public Ex42_3_StackCopyNoRecursion(Ex42_3_StackCopyNoRecursion<Item> q) {
        if (q.first != null) {
            // first = q.first;
            first = new Node(q.first); // why not "first = q.first;" because we need copy! not 引用
            for (Node x = first; x.next != null; x = x.next) {
                x.next = new Node(x.next);  // 自己拷贝自己，重点是new一块新的内存！把内容拷贝而非引用！
            }
        }
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = null;

        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        Item temp = first.item;
        first = first.next;
        N--;

        return temp;
    }

    public void printStack() {
        Node p = first;
        while (p != null) {
            StdOut.print(p.item + " ");
            p = p.next;
        }
        StdOut.println();
    }

    public static void main(String[] args) {

        Ex42_3_StackCopyNoRecursion<String> queue
                = new Ex42_3_StackCopyNoRecursion<String>();

        queue.push("zhangfei1");
        queue.push("zhangfei2");
        queue.push("zhangfei3");
        queue.push("zhangfei4");
        queue.push("zhangfei5");
        queue.printStack();

        Ex42_3_StackCopyNoRecursion<String> rqueue
                = new Ex42_3_StackCopyNoRecursion<String>(queue);

        rqueue.printStack();
        rqueue.pop();
        rqueue.printStack();
        queue.printStack();
    }
}
