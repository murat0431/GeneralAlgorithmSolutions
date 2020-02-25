package impl;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class NumbersWithEqualDigitSum {
    public int solution(int[] A) {
        int max = -1;
        Map<Integer, Queue<Integer>> table = new HashMap<>();
        for (int number : A) {
            int digitSum = digitSum(number);
            Queue<Integer> pq = table.get(digitSum);
            if (pq == null) {
                Queue<Integer> q = new PriorityQueue<>();
                q.offer(number);
                table.put(digitSum, q);
            } else {
                if(pq.size() == 1) {
                    int peek = pq.peek();
                    if (max < peek + number) max = peek + number;
                    pq.add(number);
                } else if(pq.size() == 2) {
                    int peek = pq.peek();
                    if(peek >= number) continue;
                    pq.poll();
                    if(max < pq.peek() + number) max = pq.peek() + number;
                    pq.add(number);
                }
            }
        }
        return max;
    }

    public int solution2(int[] A) {
        int max = -1;
        Map<Integer, Integer> table = new HashMap<>();
        for(int number : A) {
            int digitSum = digitSum(number);
            if(table.containsKey(digitSum)) {
                table.put(digitSum, number);
            } else {
                max = Math.max(max, table.get(digitSum) + number);
                table.put(digitSum, Math.max(table.get(digitSum), number));
            }
        }
        return max;
    }

    private int digitSum(int number) {
        int sum = 0;
        while(number != 0) {
            sum += number%10;
            number /= 10;
        }
        return sum;
    }
}
