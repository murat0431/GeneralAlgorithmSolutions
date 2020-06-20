package impl;

import java.util.ArrayList;
import java.util.List;

public class StockSpanner {
    List<Integer> prices;
    List<Integer> max;
    List<Integer> values;
    public StockSpanner() {
        prices = new ArrayList<>();
        max = new ArrayList<>();
        values = new ArrayList<>();
    }

    public int next(int price) {
        int sum=1;
        if(prices.isEmpty()) {
            prices.add(price);
            max.add(-1);
            values.add(1);
            return 1;
        } else {
            int index = prices.size()-1;
            int top = prices.get(index);
            if(top>price) {
                prices.add(price);
                max.add(index);
                values.add(1);
                return 1;
            } else {
                while(top<=price) {
                    sum+=values.get(index);
                    index = max.get(index);
                    if(index==-1)break;
                    top = prices.get(index);

                }
                prices.add(price);
                values.add(sum);
                max.add(index);
            }
        }
        return sum;
    }
}