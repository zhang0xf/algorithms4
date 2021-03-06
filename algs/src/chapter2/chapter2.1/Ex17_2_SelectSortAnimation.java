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

// 绘制排序过程

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Ex17_2_SelectSortAnimation {

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // 使用Stadraw绘制图像
    // public void filledRectangle(double x,
    //                            double y,
    //                            double halfWidth,
    //                            double halfHeight)
    // Draws a filled rectangle of the specified size, centepred at (x, y).
    // Parameters:
    // x - the x-coordinate of the center of the rectangle
    // y - the y-coordinate of the center of the rectangle
    // halfWidth - one half the width of the rectangle
    // halfHeight - one half the height of the rectangle

    private static void show(Comparable[] a) {
        StdDraw.clear();
        StdDraw.setXscale(0, a.length); // 设置横坐标的值范围
        StdDraw.setYscale(0, 1);    // 设置纵坐标的值范围
        for (int i = 0; i < a.length; i++) {
            StdDraw.filledRectangle(i + 0.5, 0, 0.3, (double) a[i]);
        }
        StdDraw.show();
        try {
            Thread.sleep(600);
        }
        catch (InterruptedException ie) {
        }
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min]))
                    min = j;
            }
            exch(a, min, i);
            show(a); // 绘制柱状图
        }
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }
        show(a);
        sort(a);
        assert isSorted(a);
    }
}
