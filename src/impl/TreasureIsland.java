package impl;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = new char[][] {{'O', 'O', 'O', 'O'}, 
										{'D', 'O', 'D', 'O'}, 
										{'O', 'O', 'O', 'O'}, 
										{'O', 'D', 'D', 'O'}};
		System.out.println(bfs(matrix));
	}
	
	public static int bfs(char[][] matrix) {
		int size = matrix.length;
		char[][] color = new char[size][size];
		int[][] dist = new int[size][size];
		int[][] dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				color[i][j] = 'w';
				dist[i][j] = 0;
			}
		}
		q.add(new int[] {0, 0});
		color[0][0] = 'g';
		while(!q.isEmpty()) {
			int[] current = q.poll();
			if(matrix[current[0]][current[1]] == 'X') {return dist[current[0]][current[1]];}
			for (int i = 0; i < dirs.length; i++) {
				int newX = current[0] + dirs[i][0];
				int newY = current[1] + dirs[i][1];
				if (canGoDir(newX, newY, matrix, color)) {
					q.add(new int[] {newX, newY});
					dist[newX][newY] = dist[current[0]][current[1]] + 1;
					color[newX][newY] = 'g';
				}
			}
			color[current[0]][current[1]] = 'b';
		}
		
		
		return -1;
	}
	
	public static boolean canGoDir(int newX, int newY, char[][] matrix, char[][] color) {
		if(newX > matrix.length-1 || newX < 0) {return false;}
		if(newY > matrix.length-1 || newY < 0) {return false;}
		if(color[newX][newY] != 'w') {return false;}
		if(matrix[newX][newY] == 'D') {return false;}
		return true;
	}
}
