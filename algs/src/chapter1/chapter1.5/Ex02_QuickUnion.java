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

// Use with file tinyUf.txt mediumUf.txt largeUf.txt

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex02_QuickUnion {

    private int[] id;
    private int count;

    public Ex02_QuickUnion(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        count = N;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }


    public static void main(String[] args) {
        int N = StdIn.readInt();
        Ex02_QuickUnion QU = new Ex02_QuickUnion(N);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if (QU.connected(p, q)) {
                continue;
            }

            QU.union(p, q);
            StdOut.println(p + " -> " + q);
        }

        StdOut.println(QU.count() + " components ");
    }
}
