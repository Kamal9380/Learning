package CodePractice;

import java.util.Arrays;

public class LargestvalueinArray {

	public static int getLargest(int[]a , int total){
		
		Arrays.sort(a);
		return a[total-1];
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[]={1,3,6,8,4};
		int b[]={32,76,109,65};
		
		System.out.println("The largest number in array is :" +getLargest(a,5));
		System.out.println("The largest number in array is :" +getLargest(b,4));
		
	}

}
