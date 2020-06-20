package test;

import impl.ReConsrtuctQueue;

public class ReConsrtuctQueueTest {
    public static void main(String[] args) {
        ReConsrtuctQueue rc = new ReConsrtuctQueue();
        rc.reconstructQueue(new int[][] {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}});
    }
}