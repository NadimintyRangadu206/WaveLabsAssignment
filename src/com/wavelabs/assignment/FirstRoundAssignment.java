package com.wavelabs.assignment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class CableConnection {

	public int maximalNetworkRank(int n, int[][] cables) {

		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		for (int[] cable : cables) {

			int lab0 = cable[0], lab1 = cable[1];

			Set<Integer> set0 = map.getOrDefault(lab0, new HashSet<Integer>());

			Set<Integer> set1 = map.getOrDefault(lab1, new HashSet<Integer>());

			set0.add(lab1);
			set1.add(lab0);
			map.put(lab0, set0);
			map.put(lab1, set1);
		}

		int maximumNetworkRank = 0;

		for (int i = 0; i < n; i++) {
			Set<Integer> set0 = map.getOrDefault(i, new HashSet<Integer>());
			for (int j = i + 1; j < n; j++) {
				Set<Integer> set1 = map.getOrDefault(j, new HashSet<Integer>());
				int rank = set0.size() + set1.size();
				if (set0.contains(j))
					rank--;
				maximumNetworkRank = Math.max(maximumNetworkRank, rank);
			}
		}
		return maximumNetworkRank;
	}
}


public class FirstRoundAssignment {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter a Number Of Labs");
		
		int labs=sc.nextInt();
		
		int [][]cables= new int[][] {{0,1},{0,3},{1,2},{1,3}};
		
		CableConnection cc= new CableConnection();

		System.out.println("Maximum Cable Network Rank:"+cc.maximalNetworkRank(labs, cables));
	}

}
