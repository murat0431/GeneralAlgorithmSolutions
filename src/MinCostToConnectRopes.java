import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MinCostToConnectRopes {
	private final static int SCANNER_CONSTANT = 4; 
	public static void main(String[] args) {
		while(true) {
			System.out.println("The result is: " + calcMinCost(initialize()));
		}
	}
	
	public static int calcMinCost(List<Integer> arr) {
		Queue<Integer> ropes = new PriorityQueue<Integer>(arr);
		int sum = 0;
		while(ropes.size() > 1) {
			int temp = ropes.poll() + ropes.poll();
			ropes.add(temp);
			sum += temp;
		}
		return sum;
	}
	
	public static List<Integer> initialize() {
		List<Integer> ropes = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < SCANNER_CONSTANT; i++) {
			ropes.add(sc.nextInt());
		}
		return ropes;
		
	}
}
