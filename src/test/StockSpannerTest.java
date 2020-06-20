package test;

import impl.StockSpanner;

public class StockSpannerTest {
    public static void main(String[] args) {
        StockSpanner st = new StockSpanner();
        System.out.println(st.next(31));
        System.out.println(st.next(41));
        System.out.println(st.next(48));
        System.out.println(st.next(59));
        System.out.println(st.next(79));
    }
}
