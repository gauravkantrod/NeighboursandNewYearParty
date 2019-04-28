import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class NeighboursandNewYearParty {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("Enter number of test cases.");
		int numberOfTestCases = in.nextInt();

		for (int j = 0; j < numberOfTestCases; j++) {
			System.out.println("Enter integers/ticket distributed for test case -- " + j);
			int numberOfHousesOrTicketsDistributed = in.nextInt();

			System.out.println("Enter numbers -- ");

			int[] ticketsArray = new int[numberOfHousesOrTicketsDistributed];
			for (int i = 0; i < numberOfHousesOrTicketsDistributed; i++) {
				ticketsArray[i] = in.nextInt();
			}

			int max = FindMaxSum(ticketsArray, numberOfHousesOrTicketsDistributed);

			System.out.println("max -- " + max);

		}

		in.close();

	}

	// if first number is negative start from 1 itself
	// if first is positive start from first in excel and then in incl list

	static int FindMaxSum(int arr[], int n) {

		int incl = arr[0];
		int excl = 0;
		int excl_new;
		int i;

		List<Integer> incList = new LinkedList<>();

		List<Integer> excList = new LinkedList<>();

		for (i = 1; i < n; i++) {

			if (incl > excl) {
				excl_new = incl;
			} else {
				excl_new = excl;
			}

			int a = arr[i];
			incl = excl + a;
			excList.add(excl);
			excl = excl_new;

			incList.add(incl);
			

		}

		System.out.println(incList);
		System.out.println(excList);

		if (incl > excl) {
			return incl;
		} else {
			return excl;
		}
	}

}
