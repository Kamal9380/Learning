package CodePractice;

public class Armstrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int c=0,a,temp;
		int number=371;
		temp=number;
		
		while(number>0){
			
			a=number%10;
			number=number/10;
			c=c+(a*a*a);
			
		}
		
		if(temp==c)
			System.out.println("The given number is Armstrong");
		else
			System.out.println("Not an Armstrong");
		
		
		
	}

}
