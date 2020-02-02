package impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BattleShip {
    public String solution(int N, String S, String T) {
        String[] ships = S.split(",");
        String[] hits = T.split(",");
        Map<Integer, Set<String>> map = new HashMap<>();
        int index = 1;
        for (String s : ships) {
            Set<String> cells = new HashSet<>();
            String[] points = s.split(" ");
            int row1 = Integer.parseInt(points[0].charAt(0)+"");
            int row2 = Integer.parseInt(points[1].charAt(0)+"");
            char col1 = points[0].charAt(1);
            char col2 = points[1].charAt(1);
            for (int i=row1;i<=row2;i++){
                for(char j=col1;j<=col2;j++) {
                    cells.add(""+i+j);
                }
            }
            map.put(index, cells);
            index++;
        }





        return null;
    }
}
