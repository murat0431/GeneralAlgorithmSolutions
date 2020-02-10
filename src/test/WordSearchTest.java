package test;

import impl.WordSearch;

public class WordSearchTest {
    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        //[["a","b"],["c","d"]]
        //"acdb"
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        ws.exist(board, word);
    }
}