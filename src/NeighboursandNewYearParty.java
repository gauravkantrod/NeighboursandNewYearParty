import java.util.Scanner;

public class NeighboursandNewYearParty {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int numberOfTestCases = in.nextInt();

		for (int j = 0; j < numberOfTestCases; j++) {
			int numberOfHousesOrTicketsDistributed = in.nextInt();

			int[] ticketsArray = new int[numberOfHousesOrTicketsDistributed];
			for (int i = 0; i < numberOfHousesOrTicketsDistributed; i++) {
				ticketsArray[i] = in.nextInt();
			}

			FindMaxSumElements(ticketsArray, numberOfHousesOrTicketsDistributed);
		}
		in.close();
	}

	static void FindMaxSumElements(int a[], int n) {

		int[][] dp = new int[n][2];
		dp[0][0] = 0;
		dp[0][1] = a[0];

		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
			dp[i][1] = a[i] + dp[i - 1][0];
		}

		int ptr = n - 1;
		while (ptr >= 0) {
			if (dp[ptr][1] > dp[ptr][0]) {
				System.out.print(a[ptr]);
				ptr -= 2;
			} else {
				ptr--;
			}
		}
		System.out.println();

		// return Math.max(dp[n - 1][0], dp[n - 1][1]);
	}

}
