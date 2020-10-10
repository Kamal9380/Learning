package CodePractice;

import java.util.Arrays;

public class AnagramStringCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s1="SILENT";
        String s2="KIMBEL";
        
        if(s1.length()==s2.length()){
        	
        	char[] c1=s1.toCharArray();
        	Arrays.sort(c1);
        	System.out.println(c1);
        	
        	char[] c2=s2.toCharArray();
        	Arrays.sort(c2);
        	System.out.println(c2);
        	
        	if(Arrays.equals(c1, c2)){

        		System.out.println("Given two strings is Anagram");
        	}
        		else{
        			System.out.println("Given two strings are not Anagram");
        		}
        }
        	}
      
        }
        
       

