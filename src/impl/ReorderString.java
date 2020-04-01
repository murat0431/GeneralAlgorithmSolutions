package impl;

import java.util.*;

public class ReorderString {
  public String reorganizeString(String S) {
    int size = S.length();
    if(size < 2) return S;
    if(size == 2) return S.charAt(0) == S.charAt(1) ? "" : S;
    Map<Character, Integer> table = new HashMap<>();
    initMap(table, S);
    Queue<Freq> pq = new PriorityQueue<>(Comparator.comparing(l -> l.freq, Comparator.reverseOrder()));
    for(Map.Entry<Character, Integer> entry : table.entrySet()) {
      pq.add(new Freq(entry.getValue(), entry.getKey()));
    }
    StringBuilder sb = new StringBuilder();
    int threshold = size%2 == 0 ? size>>1 : (size>>1) +1;
    if(pq.peek().freq > threshold) return "";
    while(!pq.isEmpty()) {
      Freq f1 = pq.poll();
      Freq f2 = pq.isEmpty() ? null : pq.poll();
      sb.append(f1.c);
      f1.freq--;
      if(f1.freq > 0) pq.offer(f1);
      if(f2 != null) {
        sb.append(f2.c);
        f2.freq--;
        if(f2.freq > 0) pq.offer(f1);
      }

    }

    return sb.toString();

  }

  private void initMap(Map<Character, Integer> table, String S) {
    for(int i=0;i<S.length();i++) {
      char curr = S.charAt(i);
      if(!table.containsKey(curr)) {
        table.put(curr, 1);
      } else {
        int freq = table.get(curr);
        table.put(curr, ++freq);
      }
    }
  }


}

class Freq {
  int freq;
  char c;

  public Freq(int freq, char c) {
    this.freq = freq;
    this.c = c;
  }
}