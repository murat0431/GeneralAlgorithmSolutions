package impl;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReConsrtuctQueue {
    public int[][] reconstructQueue(int[][] people) {
        int size = people.length;
        int[][] result = new int[size][size];
        Queue<Element> pq = new PriorityQueue<>(Comparator.comparing(Element::getSecondElement).
                thenComparing(Comparator.comparing(Element::getFirstElement)));
        int index = 0;
        for(int[] p : people) pq.offer(new Element(new int[]{p[0], p[1]}, new int[]{p[0], p[1]}));
        while(!pq.isEmpty()) {
            while(!pq.isEmpty() && pq.peek().curr[1] == 0) {
                result[index] = pq.poll().prev;
                for(Element el : pq) {
                    if(result[index][0]>=el.curr[0]) el.curr[1]--;
                }
                index++;
            }
        }
        return result;
    }
}

class Element implements Comparable<Element>{
    int[] prev;
    int[] curr;

    public Element(int[] prev, int[] curr) {
        this.prev = prev;
        this.curr = curr;
    }

    public int compareTo(Element e1) {
        return this.curr[1]-e1.curr[1];
    }

    public int getFirstElement() {
        return this.curr[0];
    }

    public int getSecondElement() {
        return this.curr[1];
    }
}

/*
    [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

    0->[5,0],[7,0]
    1->[6,1],[7,1]
    2->[5,2]
    4->[4,4]

    [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

    [4,4]
    [5,0]
    [5,2]
    [6,1]
    [7,0]
    [7,1]
*/