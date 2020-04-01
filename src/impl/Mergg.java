// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.io.*;
import java.util.*;

class Solution {
  public int solution(int N) {
    // write your code in Java SE 8
    Stack<Integer> digits = new Stack<>();
    int result = 0;
    digits = findDigits(Math.abs(N));
    boolean isNegative = N<0;
    if(N>=0) {
      while(!digits.empty()) {
        int current = digits.peek();
        if(current <= 5) {
          result = result*10 + 5;
          break;
        } else {
          result = result*10 + current;
          digits.pop();
        }
      }
      while(!digits.empty()) {
        result = result*10 + digits.pop();
      }
      return result;
    } else {
      while(!digits.empty()) {
        int current = digits.peek();
        if(current <= 5) {
          result = result*10 + current;
          digits.pop();
        } else {
          result = result*10 + 5;
          break;
        }
      }
      while(!digits.empty()) {
        result = result*10 + digits.pop();
      }
      return -result;
    }
  }

  public Stack<Integer> findDigits(int N) {
    Stack<Integer> digits = new Stack<>();
    if(N==0) digits.push(0);
    while(N > 0) {
      digits.push(N%10);
      N /= 10;
    }
    return digits;
  }
}
