package CodePractice;

import java.util.HashSet;

public final class DuplicatesCount {
	
	static int birthdayCakeCandles(int[] ar) {

		int count = 1;                                                     //all values will have at least one  count
		int maxHeight = 0;
		for(int i=0;i<ar.length;i++){
		int temp = ar[i];
		if(temp>=maxHeight){
		if(temp == maxHeight)                    //if the highest num occurs again
		count++;
		maxHeight = temp;
		}
		}
		return count;
		
		/*int count=0;
		 HashSet<Integer> set = new HashSet<Integer>();
		        
		    for (int element : ar) 
		    {
		        if( ! set.add(element))
		        {
		           
		           count++;
		            //System.out.println("Duplicate Element : "+element);
		        }
		    }

		return count+1;*/
		    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		int[] ar={1,2,2,3,4,2};
		int rowcount=birthdayCakeCandles(ar);
		System.out.println(rowcount);
		
		
		
	}

}
