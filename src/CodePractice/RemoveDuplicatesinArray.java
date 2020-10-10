package CodePractice;

public class RemoveDuplicatesinArray {

	public static int duplicate(int a[], int n){
		
		if (n==0 || n==1){  
            return n;  
        }  
		else
		{
		int j=0;
		for(int i=0;i<n-1;i++){
			
			if(a[i]!=a[i+1]){
				a[j]=a[i];
				j++;
			}
		}
		
		a[j]=a[n-1];
		return j;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
	int[] arr1= {10,20,20,30,30,40,50,50,90,90};
	int c=0;
	int length=arr1.length;
	while(c<length){
		System.out.println("The lenght is:" +length);
	System.out.println("Before removing duplicates:" +""+arr1[c]);
	c++;
	}
	
	
	length=duplicate(arr1,length);
	
	for(int i=0;i<length;i++){
		
	System.out.println("After removing duplicate is:" +" "+ arr1[i]);
	}	
	}

}
