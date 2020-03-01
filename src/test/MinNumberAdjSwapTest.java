package test;

import impl.MinNumberAdjSwap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MinNumberAdjSwapTest {
    public static void main(String[] args) {
        MinNumberAdjSwap ms = new MinNumberAdjSwap();
        String s = "aaeadbbacce";
        System.out.println(ms.solution(s));
    }
}
