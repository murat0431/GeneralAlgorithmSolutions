package impl;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean result = false;
        int rowSize = board.length;
        int colSize = board[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for(int i=0;i<rowSize;i++) {
            for(int j=0;j<colSize;j++) {
                boolean[][] visited = new boolean[rowSize][colSize];
                result = result || exist(i, j, board, word, visited, colSize, rowSize,                                                dirs);
                if(result) return result;
            }
        }
        return result;
    }

    private boolean exist(int i, int j, char[][] board, String word, boolean[][] visited,
                          int colSize, int rowSize, int[][] dirs) {
        if(word.length() == 0) return true;
        boolean[][] newVisited = copyTwoDArr(visited);
        newVisited[i][j] = true;
        if(board[i][j] != word.charAt(0)) return false;
        if(word.length() == 1) return true;
        boolean myResult = false;
        for(int m=0;m<dirs.length;m++){
            int newRow = dirs[m][0] + i;
            int newCol = dirs[m][1] + j;
            if(newRow < rowSize && newRow > -1 && newCol < colSize && newCol > -1 && !newVisited[newRow][newCol]) {
                myResult = myResult || exist(newRow, newCol, board, word.substring(1), newVisited, colSize, rowSize, dirs);
            }

        }
        return myResult;

    }
    private boolean[][] copyTwoDArr(boolean[][] arr) {
        boolean[][] newArr = new boolean[arr.length][arr.length];
        int index = 0;
        for (boolean[] b : arr) {
            newArr[index] = b.clone();
            index++;
        }
        return newArr;
    }
}