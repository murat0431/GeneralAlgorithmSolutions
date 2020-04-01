package impl;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    private Queue<Integer> left;
    private Queue<Integer> right;

    /** initialize your data structure here. */
    public MedianFinder() {
        left = new PriorityQueue<>(Comparator.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(left.isEmpty()) {
            left.offer(num);
            return;
        }
        if(right.isEmpty()) {
            right.offer(num);
            return;
        }
        if(!left.isEmpty() && !right.isEmpty()) {
            if(right.peek() < num) {
                right.offer(num);
                if(left.size() < right.size()) {
                    left.offer(right.poll());
                }
            } else {
                left.offer(num);
                if(left.size()-1> right.size()) {
                    right.offer(left.poll());
                }
            }
        }
    }

    public double findMedian() {
        if(left.isEmpty()) return 0.0;
        if(right.isEmpty()) return left.peek();
        if(left.size() == right.size()) {
            return (double) (left.peek() + right.peek())/2;
        }
        return left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
